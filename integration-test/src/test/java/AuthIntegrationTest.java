import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;


public class AuthIntegrationTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:4005"; // Auth service URL
    }

    @Test
    public void shouldReturnOKWithValidaToken() {
        // 1. Arrange
        // 2. Act
        // 3. Assert

        String loginPayload = """
                {
                    "email": "test@test.com",
                    "password": "password123"
                }
                """;
        Response response = given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        System.out.println("Token: " + response.jsonPath().getString("token"));
    }
}
