package example.springdata.rest;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest(randomPort = true)
public abstract class AbstractTest {

    protected final static String X_AUTH_TOKEN = "x-auth-token";
    
    @Value("${local.server.port}")
    protected int port;
    
    @Before
    public void setup() {
        RestAssured.port = this.port;
    }

    protected RequestSpecification halJsonRequest() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType(MediaTypes.HAL_JSON_VALUE);
        return builder.build();
    }
    
    protected RequestSpecification authenticatedRequest() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader(X_AUTH_TOKEN, login());
        return builder.build();
    }

    protected String login() {
        return given().auth().basic("user", "user").when().post("/login").getHeader(X_AUTH_TOKEN);
    }
    
}
