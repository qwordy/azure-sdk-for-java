// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.callingserver;

import com.azure.core.util.ServiceVersion;

/**
 * The versions of CallingServer Service supported by this client library.
 */
public enum CallingServerServiceVersion implements ServiceVersion {
    V2021_06_15_PREVIEW("2021-06-15-preview");

    private final String version;

    CallingServerServiceVersion(String version) {
        this.version = version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVersion() {
        return this.version;
    }

    /**
     * Gets the latest service version supported by this client library
     *
     * @return the latest {@link CallingServerServiceVersion}
     */
    public static CallingServerServiceVersion getLatest() {
        return V2021_06_15_PREVIEW;
    }
}
