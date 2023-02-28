// camel-k: language=java dependency=mvn:org.apache.camel.quarkus:camel-quarkus-kafka dependency=mvn:io.strimzi:kafka-oauth-client:0.7.1.redhat-00003

import org.apache.camel.builder.RouteBuilder;

public class CamelKConsumer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        log.info("About to start route: Kafka -> Log ");

        from("kafka:logs-app?brokers=tcp://kafka-cluster-kafka-bootstrap.kafka-log.svc.cluster.local:9092")
            .routeId("FromKafka2Log")
            .log("${body}");
    }
}