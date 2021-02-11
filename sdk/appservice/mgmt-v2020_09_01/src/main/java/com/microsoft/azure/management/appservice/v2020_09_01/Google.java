/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2020_09_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * The Google model.
 */
@JsonFlatten
public class Google extends ProxyOnlyResource {
    /**
     * The enabled property.
     */
    @JsonProperty(value = "properties.enabled")
    private Boolean enabled;

    /**
     * The registration property.
     */
    @JsonProperty(value = "properties.registration")
    private ClientRegistration registration;

    /**
     * The login property.
     */
    @JsonProperty(value = "properties.login")
    private LoginScopes login;

    /**
     * The validation property.
     */
    @JsonProperty(value = "properties.validation")
    private AllowedAudiencesValidation validation;

    /**
     * Get the enabled value.
     *
     * @return the enabled value
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled value.
     *
     * @param enabled the enabled value to set
     * @return the Google object itself.
     */
    public Google withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the registration value.
     *
     * @return the registration value
     */
    public ClientRegistration registration() {
        return this.registration;
    }

    /**
     * Set the registration value.
     *
     * @param registration the registration value to set
     * @return the Google object itself.
     */
    public Google withRegistration(ClientRegistration registration) {
        this.registration = registration;
        return this;
    }

    /**
     * Get the login value.
     *
     * @return the login value
     */
    public LoginScopes login() {
        return this.login;
    }

    /**
     * Set the login value.
     *
     * @param login the login value to set
     * @return the Google object itself.
     */
    public Google withLogin(LoginScopes login) {
        this.login = login;
        return this;
    }

    /**
     * Get the validation value.
     *
     * @return the validation value
     */
    public AllowedAudiencesValidation validation() {
        return this.validation;
    }

    /**
     * Set the validation value.
     *
     * @param validation the validation value to set
     * @return the Google object itself.
     */
    public Google withValidation(AllowedAudiencesValidation validation) {
        this.validation = validation;
        return this;
    }

}