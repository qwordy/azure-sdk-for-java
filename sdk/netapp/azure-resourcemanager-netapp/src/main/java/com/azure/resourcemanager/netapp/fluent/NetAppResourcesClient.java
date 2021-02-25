// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.netapp.fluent.models.CheckAvailabilityResponseInner;
import com.azure.resourcemanager.netapp.models.QuotaAvailabilityRequest;
import com.azure.resourcemanager.netapp.models.ResourceNameAvailabilityRequest;

/** An instance of this class provides access to all the operations defined in NetAppResourcesClient. */
public interface NetAppResourcesClient {
    /**
     * Check if a resource name is available.
     *
     * @param location The location.
     * @param body Name availability request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information regarding availability of a resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CheckAvailabilityResponseInner checkNameAvailability(String location, ResourceNameAvailabilityRequest body);

    /**
     * Check if a resource name is available.
     *
     * @param location The location.
     * @param body Name availability request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information regarding availability of a resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CheckAvailabilityResponseInner> checkNameAvailabilityWithResponse(
        String location, ResourceNameAvailabilityRequest body, Context context);

    /**
     * Check if a file path is available.
     *
     * @param location The location.
     * @param body File path availability request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information regarding availability of a resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CheckAvailabilityResponseInner checkFilePathAvailability(String location, ResourceNameAvailabilityRequest body);

    /**
     * Check if a file path is available.
     *
     * @param location The location.
     * @param body File path availability request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information regarding availability of a resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CheckAvailabilityResponseInner> checkFilePathAvailabilityWithResponse(
        String location, ResourceNameAvailabilityRequest body, Context context);

    /**
     * Check if a quota is available.
     *
     * @param location The location.
     * @param body Quota availability request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information regarding availability of a resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CheckAvailabilityResponseInner checkQuotaAvailability(String location, QuotaAvailabilityRequest body);

    /**
     * Check if a quota is available.
     *
     * @param location The location.
     * @param body Quota availability request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information regarding availability of a resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CheckAvailabilityResponseInner> checkQuotaAvailabilityWithResponse(
        String location, QuotaAvailabilityRequest body, Context context);
}