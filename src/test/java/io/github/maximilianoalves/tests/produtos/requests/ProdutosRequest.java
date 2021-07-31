package io.github.maximilianoalves.tests.produtos.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class ProdutosRequest {

    private final String PATH_PRODUTOS = "/produtos";

    @Step("Listar produtos cadastrados")
    public Response listar() {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(PATH_PRODUTOS);
    }

    @Step("Buscar produtos por ID")
    public Response buscarPorId(String id) {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .pathParam("_id", id)
                .get(PATH_PRODUTOS + "/{_id}");
    }

    @Step("Buscar ID do primeiro usuário.")
    public String buscarIdPrimeiroUsuario() {
        return this.listar().then().statusCode(HttpStatus.SC_OK).extract().path("produtos[0]._id");
    }

}
