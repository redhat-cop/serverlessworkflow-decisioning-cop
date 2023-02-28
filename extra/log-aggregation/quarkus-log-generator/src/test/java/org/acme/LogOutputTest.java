package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LogOutputTest {

    @Test
    public void testLogEndpoint() {
        given()
          .when().get("/log")
          .then()
             .statusCode(200)
             .body(is("001 - Test"));
    }

}