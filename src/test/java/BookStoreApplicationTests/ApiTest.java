package BookStoreApplicationTests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ApiTest {
    @BeforeMethod
    public void setup(){
        baseURI = "https://demoqa.com";
    }

    @Test
    public void createUser(){

        String body = """
                {
                "userName": "JohnDoe24",
                "password": "Qwerty123!?"
                }
                """;

        Response creatUserResponse =
                given()
                    .header("Content-Type", "application/json")
                    .body(body)
                .when()
                    .post("/Account/v1/User")
                .then()
                     .statusCode(201)
                     .extract().response();

        String userID = creatUserResponse.jsonPath().getString("userID");

        Response tokenResponse =
                given()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .post("/Account/v1/GenerateToken")
                .then()
                        .statusCode(200)
                        .extract().response();
        String token = tokenResponse.jsonPath().getString("token");

        given()
                .header("Content-Type", "application/json")
                .body(body)
        .when()
                .post("/Account/v1/Authorized")
        .then()
                .statusCode(200);

        given()
                .header("Authorization", "Bearer " + token)
        .when()
                .get("/Account/v1/User/" + userID)
        .then()
                .statusCode(200);

        given()
                .header("Authorization", "Bearer " + token)
        .when()
                .delete("/Account/v1/User/" + userID)
        .then()
                .statusCode(204);
    }
}