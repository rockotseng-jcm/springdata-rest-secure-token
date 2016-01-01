package example.springdata.rest;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import example.springdata.rest.Customer;

public class UpdateCustomerTest extends AbstractCustomerTest {

    @Test
    public void testUpdateShouldReturnOk() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        Customer body = new Customer("Rocko", "Tseng");

        given().spec(authenticatedRequest()).spec(halJsonRequest()).body(body).when().put("/customers/{id}", customer.getId())
                .then().statusCode(200);
    }

    @Test
    public void testUpdateShouldReturnCreatedIfCustomerNotFound() {

        Customer body = new Customer("Rocko", "Tseng");

        given().spec(authenticatedRequest()).spec(halJsonRequest()).body(body).when().put("/customers/1").then().statusCode(201);
    }

}
