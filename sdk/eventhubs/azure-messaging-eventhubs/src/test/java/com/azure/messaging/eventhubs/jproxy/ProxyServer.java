// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.jproxy;

import java.io.IOException;
import java.util.function.Consumer;

public interface ProxyServer {
    void start(Consumer<Throwable> onError) throws IOException;

    void stop() throws IOException;
}
