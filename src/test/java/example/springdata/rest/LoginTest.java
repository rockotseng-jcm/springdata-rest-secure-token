package example.springdata.rest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class LoginTest extends AbstractTest {

    @Test
    public void loginShouldReturnValidToken() {

        given().auth().basic("user", "user").when().post("/login").then().statusCode(200).body("username", equalTo("user"))
                .header("x-auth-token", notNullValue());
    }

}
