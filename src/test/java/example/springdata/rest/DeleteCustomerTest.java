package example.springdata.rest;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import example.springdata.rest.Customer;

public class DeleteCustomerTest extends AbstractCustomerTest {

    @Test
    public void testDeleteShouldReturnNoContent() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        given().spec(authenticatedRequest()).spec(halJsonRequest()).when().delete("/customers/{id}", customer.getId()).then()
                .statusCode(204);
    }

    @Test
    public void testDeleteShouldReturnNotFound() {

        given().spec(authenticatedRequest()).spec(halJsonRequest()).when().delete("/customers/1").then().statusCode(404);
    }

}
