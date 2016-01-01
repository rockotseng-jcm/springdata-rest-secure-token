package example.springdata.rest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import example.springdata.rest.Customer;

public class GetCustomerTest extends AbstractCustomerTest {

    @Test
    public void testGetShouldReturnOkWithCorrespondingResource() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        given().spec(authenticatedRequest()).spec(halJsonRequest()).when().get("/customers/{id}", customer.getId()).then().statusCode(200)
                .body("firstName", equalTo(customer.getFirstName()));
    }

    @Test
    public void testGetShouldReturnNotFound() {

        given().spec(authenticatedRequest()).spec(halJsonRequest()).when().get("/customers/1").then().statusCode(404);
    }

}
