package com.azure.analytics.purview.catalog.implementation;

import com.azure.core.exception.AzureException;
import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.serializer.DefaultJsonSerializer;
import com.azure.core.util.BinaryData;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.PollingContext;
import com.azure.core.util.polling.PollingStrategy;
import com.azure.core.util.polling.implementation.PollingUtils;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import reactor.core.publisher.Mono;

public class LocationPollingStrategy<T, U> implements PollingStrategy<T, U> {
    private final HttpPipeline httpPipeline;
    private final ObjectSerializer serializer;

    public LocationPollingStrategy(HttpPipeline httpPipeline) {
        this(httpPipeline, new DefaultJsonSerializer());
    }

    public LocationPollingStrategy(HttpPipeline httpPipeline, ObjectSerializer serializer) {
        this.httpPipeline = (HttpPipeline)Objects.requireNonNull(httpPipeline, "'httpPipeline' cannot be null");
        this.serializer = (ObjectSerializer)Objects.requireNonNull(serializer, "'serializer' cannot be null");
    }

    public Mono<Boolean> canPoll(Response<?> initialResponse) {
        HttpHeader locationHeader = initialResponse.getHeaders().get("Location");
        if (locationHeader != null) {
            try {
                new URL(locationHeader.getValue());
                return Mono.just(true);
            } catch (MalformedURLException var4) {
                return Mono.just(false);
            }
        } else {
            return Mono.just(false);
        }
    }

    public Mono<PollResponse<T>> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> pollResponseType) {
        HttpHeader locationHeader = response.getHeaders().get("Location");
        if (locationHeader != null) {
            pollingContext.setData("Location", locationHeader.getValue());
        }

        pollingContext.setData("httpMethod", response.getRequest().getHttpMethod().name());
        pollingContext.setData("requestURL", response.getRequest().getUrl().toString());
        if (response.getStatusCode() != 200 && response.getStatusCode() != 201 && response.getStatusCode() != 202 && response.getStatusCode() != 204) {
            return Mono.error(new AzureException(String.format("Operation failed or cancelled with status code %d,, 'Location' header: %s, and response body: %s", response.getStatusCode(), locationHeader, PollingUtils.serializeResponse(response.getValue(), this.serializer))));
        } else {
            String retryAfterValue = response.getHeaders().getValue("Retry-After");
            Duration retryAfter = retryAfterValue == null ? null : Duration.ofSeconds(Long.parseLong(retryAfterValue));
            return PollingUtils.convertResponse(response.getValue(), this.serializer, pollResponseType).map((value) -> {
                return new PollResponse(LongRunningOperationStatus.IN_PROGRESS, value, retryAfter);
            }).switchIfEmpty(Mono.defer(() -> {
                return Mono.just(new PollResponse(LongRunningOperationStatus.IN_PROGRESS, (Object)null, retryAfter));
            }));
        }
    }

    public Mono<PollResponse<T>> poll(PollingContext<T> pollingContext, TypeReference<T> pollResponseType) {
        HttpRequest request = new HttpRequest(HttpMethod.GET, pollingContext.getData("Location"));
        return this.httpPipeline.send(request).flatMap((response) -> {
            HttpHeader locationHeader = response.getHeaders().get("Location");
            if (locationHeader != null) {
                pollingContext.setData("Location", locationHeader.getValue());
            }

            LongRunningOperationStatus status;
            if (response.getStatusCode() == 202) {
                status = LongRunningOperationStatus.IN_PROGRESS;
            } else if (response.getStatusCode() >= 200 && response.getStatusCode() <= 204) {
                status = LongRunningOperationStatus.SUCCESSFULLY_COMPLETED;
            } else {
                status = LongRunningOperationStatus.FAILED;
            }

            return response.getBodyAsByteArray().map(BinaryData::fromBytes).flatMap((binaryData) -> {
                pollingContext.setData("pollResponseBody", binaryData.toString());
                String retryAfterValue = response.getHeaders().getValue("Retry-After");
                Duration retryAfter = retryAfterValue == null ? null : Duration.ofSeconds(Long.parseLong(retryAfterValue));
                return PollingUtils.deserializeResponse(binaryData, this.serializer, pollResponseType).map((value) -> {
                    return new PollResponse(status, value, retryAfter);
                });
            });
        });
    }

    public Mono<U> getResult(PollingContext<T> pollingContext, TypeReference<U> resultType) {
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.FAILED) {
            return Mono.error(new AzureException("Long running operation failed."));
        } else if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.USER_CANCELLED) {
            return Mono.error(new AzureException("Long running operation cancelled."));
        } else {
            String httpMethod = pollingContext.getData("httpMethod");
            String finalGetUrl;
            if (!HttpMethod.PUT.name().equalsIgnoreCase(httpMethod) && !HttpMethod.PATCH.name().equalsIgnoreCase(httpMethod)) {
                if (!HttpMethod.POST.name().equalsIgnoreCase(httpMethod) || pollingContext.getData("Location") == null) {
                    return Mono.error(new AzureException("Cannot get final result"));
                }

                finalGetUrl = pollingContext.getData("Location");
            } else {
                finalGetUrl = pollingContext.getData("requestURL");
            }

            if (finalGetUrl == null) {
                String latestResponseBody = pollingContext.getData("pollResponseBody");
                return PollingUtils.deserializeResponse(BinaryData.fromString(latestResponseBody), this.serializer, resultType);
            } else {
                HttpRequest request = new HttpRequest(HttpMethod.GET, finalGetUrl);
                return this.httpPipeline.send(request).flatMap(HttpResponse::getBodyAsByteArray).map(BinaryData::fromBytes).flatMap((binaryData) -> {
                    return PollingUtils.deserializeResponse(binaryData, this.serializer, resultType);
                });
            }
        }
    }
}
