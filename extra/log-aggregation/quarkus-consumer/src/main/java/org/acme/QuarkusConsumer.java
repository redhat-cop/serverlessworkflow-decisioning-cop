package org.acme;

import org.eclipse.microprofile.reactive.messaging.*;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuarkusConsumer {

    @Incoming("logs-app")
    public void sink(String message) {
        System.out.println("Received message:" + message);
    }
}
