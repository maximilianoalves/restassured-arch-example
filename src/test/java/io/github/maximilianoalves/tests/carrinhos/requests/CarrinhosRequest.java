package io.github.maximilianoalves.tests.carrinhos.requests;

import io.github.maximilianoalves.payloads.LoginPayload;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CarrinhosRequest {

    private final String PATH_CARRINHOS = "/carrinhos";

    @Step("Listar todos os carrinhos cadastrados.")
    public Response listar() {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(PATH_CARRINHOS);
    }

}
