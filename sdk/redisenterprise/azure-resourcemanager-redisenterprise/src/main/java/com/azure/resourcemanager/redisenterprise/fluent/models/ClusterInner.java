// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.redisenterprise.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.Resource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.redisenterprise.models.ProvisioningState;
import com.azure.resourcemanager.redisenterprise.models.ResourceState;
import com.azure.resourcemanager.redisenterprise.models.Sku;
import com.azure.resourcemanager.redisenterprise.models.TlsVersion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** Describes the RedisEnterprise cluster. */
@JsonFlatten
@Fluent
public class ClusterInner extends Resource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ClusterInner.class);

    /*
     * The SKU to create, which affects price, performance, and features.
     */
    @JsonProperty(value = "sku", required = true)
    private Sku sku;

    /*
     * The Availability Zones where this cluster will be deployed.
     */
    @JsonProperty(value = "zones")
    private List<String> zones;

    /*
     * The minimum TLS version for the cluster to support, e.g. '1.2'
     */
    @JsonProperty(value = "properties.minimumTlsVersion")
    private TlsVersion minimumTlsVersion;

    /*
     * DNS name of the cluster endpoint
     */
    @JsonProperty(value = "properties.hostName", access = JsonProperty.Access.WRITE_ONLY)
    private String hostname;

    /*
     * Current provisioning status of the cluster
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * Current resource status of the cluster
     */
    @JsonProperty(value = "properties.resourceState", access = JsonProperty.Access.WRITE_ONLY)
    private ResourceState resourceState;

    /*
     * Version of redis the cluster supports, e.g. '6'
     */
    @JsonProperty(value = "properties.redisVersion", access = JsonProperty.Access.WRITE_ONLY)
    private String redisVersion;

    /*
     * List of private endpoint connections associated with the specified
     * RedisEnterprise cluster
     */
    @JsonProperty(value = "properties.privateEndpointConnections", access = JsonProperty.Access.WRITE_ONLY)
    private List<PrivateEndpointConnectionInner> privateEndpointConnections;

    /**
     * Get the sku property: The SKU to create, which affects price, performance, and features.
     *
     * @return the sku value.
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The SKU to create, which affects price, performance, and features.
     *
     * @param sku the sku value to set.
     * @return the ClusterInner object itself.
     */
    public ClusterInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the zones property: The Availability Zones where this cluster will be deployed.
     *
     * @return the zones value.
     */
    public List<String> zones() {
        return this.zones;
    }

    /**
     * Set the zones property: The Availability Zones where this cluster will be deployed.
     *
     * @param zones the zones value to set.
     * @return the ClusterInner object itself.
     */
    public ClusterInner withZones(List<String> zones) {
        this.zones = zones;
        return this;
    }

    /**
     * Get the minimumTlsVersion property: The minimum TLS version for the cluster to support, e.g. '1.2'.
     *
     * @return the minimumTlsVersion value.
     */
    public TlsVersion minimumTlsVersion() {
        return this.minimumTlsVersion;
    }

    /**
     * Set the minimumTlsVersion property: The minimum TLS version for the cluster to support, e.g. '1.2'.
     *
     * @param minimumTlsVersion the minimumTlsVersion value to set.
     * @return the ClusterInner object itself.
     */
    public ClusterInner withMinimumTlsVersion(TlsVersion minimumTlsVersion) {
        this.minimumTlsVersion = minimumTlsVersion;
        return this;
    }

    /**
     * Get the hostname property: DNS name of the cluster endpoint.
     *
     * @return the hostname value.
     */
    public String hostname() {
        return this.hostname;
    }

    /**
     * Get the provisioningState property: Current provisioning status of the cluster.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the resourceState property: Current resource status of the cluster.
     *
     * @return the resourceState value.
     */
    public ResourceState resourceState() {
        return this.resourceState;
    }

    /**
     * Get the redisVersion property: Version of redis the cluster supports, e.g. '6'.
     *
     * @return the redisVersion value.
     */
    public String redisVersion() {
        return this.redisVersion;
    }

    /**
     * Get the privateEndpointConnections property: List of private endpoint connections associated with the specified
     * RedisEnterprise cluster.
     *
     * @return the privateEndpointConnections value.
     */
    public List<PrivateEndpointConnectionInner> privateEndpointConnections() {
        return this.privateEndpointConnections;
    }

    /** {@inheritDoc} */
    @Override
    public ClusterInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ClusterInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sku() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property sku in model ClusterInner"));
        } else {
            sku().validate();
        }
        if (privateEndpointConnections() != null) {
            privateEndpointConnections().forEach(e -> e.validate());
        }
    }
}