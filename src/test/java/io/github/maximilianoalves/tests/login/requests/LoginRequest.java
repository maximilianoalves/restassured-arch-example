package io.github.maximilianoalves.tests.login.requests;

import io.github.maximilianoalves.payloads.LoginPayload;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.*;

public class LoginRequest {

    private final String PATH_LOGIN = "/login";

    @Step("Realizar login - POST")
    public Response logar(String email, String password) {
        return given()
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                .when()
                    .body(LoginPayload.toJson(email, password))
                    .post(PATH_LOGIN);
    }

    @Step("Realizar login - GET")
    public Response getLogin(String email, String password) {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(LoginPayload.toJson(email, password))
                .get(PATH_LOGIN);
    }

    @Step("Realizar login - PUT")
    public Response putLogin(String email, String password) {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(LoginPayload.toJson(email, password))
                .put(PATH_LOGIN);
    }

    @Step("Realizar login - DELETE")
    public Response deleteLogin(String email, String password) {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(LoginPayload.toJson(email, password))
                .delete(PATH_LOGIN);
    }

    public String getBearerToken(String email, String password) {
        return logar(email, password)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("authorization");
    }
}
