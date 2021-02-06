/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.streamanalytics.v2020_03_01_preview;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Parameters used to specify the type of function to retrieve the default
 * definition for.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "bindingType", defaultImpl = FunctionRetrieveDefaultDefinitionParameters.class)
@JsonTypeName("FunctionRetrieveDefaultDefinitionParameters")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "Microsoft.MachineLearning/WebService", value = AzureMachineLearningStudioFunctionRetrieveDefaultDefinitionParameters.class),
    @JsonSubTypes.Type(name = "Microsoft.MachineLearningServices", value = AzureMachineLearningServiceFunctionRetrieveDefaultDefinitionParameters.class),
    @JsonSubTypes.Type(name = "Microsoft.StreamAnalytics/JavascriptUdf", value = JavaScriptFunctionRetrieveDefaultDefinitionParameters.class),
    @JsonSubTypes.Type(name = "Microsoft.StreamAnalytics/CLRUdf", value = CSharpFunctionRetrieveDefaultDefinitionParameters.class)
})
public class FunctionRetrieveDefaultDefinitionParameters {
}