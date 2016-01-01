package example.springdata.rest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.isEmptyString;

import org.junit.Test;

public class LogoutTest extends AbstractTest {

    @Test
    public void logoutShouldReturnNoContentAndAnEmptyToken() {

        given(authenticatedRequest()).when().post("/logout").then().statusCode(204).header(X_AUTH_TOKEN, isEmptyString());
    }

}
