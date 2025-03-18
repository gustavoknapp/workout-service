package com.gbk;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GreetingResourceTest {
  @Test
  void testHelloEndpoint() {
    given().when().get("/workout").then().statusCode(200).body(is(List.of()));
  }
}
