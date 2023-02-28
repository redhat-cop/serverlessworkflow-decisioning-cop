package camelquarkus.camelquarkus.src.main.java;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.model.dataformat.JsonLibrary;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class CamelQuarkusConsumer extends RouteBuilder{
    @Inject
    KafkaComponent kafka;

    @Override
    public void configure() throws Exception {
        from("kafka:logs-app?brokers=tcp://kafka-cluster-kafka-bootstrap.kafka-log.svc.cluster.local:9092")
                .log("Message recieved: ${body}");
    }
    
}