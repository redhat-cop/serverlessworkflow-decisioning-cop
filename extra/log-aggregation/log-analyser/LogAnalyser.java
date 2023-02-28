// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;


public class LogAnalyser extends RouteBuilder {
  @Override
  public void configure() throws Exception {
      rest("/log-aggregator")
            .post()
            .to("direct:log-message");
    
      from("direct:log-message")
                .log("Received message: ${body}")
                .to("log:receivedMessage");
      
      from("netty:tcp://0.0.0.0:8008")
                .log("Received message: ${body}")
                .to("log:receivedMessage");
    
  }
}