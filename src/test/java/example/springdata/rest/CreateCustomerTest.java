package example.springdata.rest;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

public class CreateCustomerTest extends AbstractCustomerTest {

    @Test
    public void testCreateShouldReturnCreated() {

        Customer customer = new Customer("Sandra", "Wei");

        given().spec(authenticatedRequest()).spec(halJsonRequest()).body(customer).when().post("/customers").then().statusCode(201);
    }

}
