// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridkubernetes.implementation;

import com.azure.resourcemanager.hybridkubernetes.HybridKubernetesManager;
import com.azure.resourcemanager.hybridkubernetes.fluent.models.OperationInner;
import com.azure.resourcemanager.hybridkubernetes.models.Operation;
import com.azure.resourcemanager.hybridkubernetes.models.OperationDisplay;

public final class OperationImpl implements Operation {
    private OperationInner innerObject;

    private final HybridKubernetesManager serviceManager;

    OperationImpl(OperationInner innerObject, HybridKubernetesManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String name() {
        return this.innerModel().name();
    }

    public OperationDisplay display() {
        return this.innerModel().display();
    }

    public OperationInner innerModel() {
        return this.innerObject;
    }

    private HybridKubernetesManager manager() {
        return this.serviceManager;
    }
}