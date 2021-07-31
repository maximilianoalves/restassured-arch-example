package io.github.maximilianoalves.tests.produtos.tests;

import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.produtos.requests.ProdutosRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

@Feature("Produtos")
public class ListarProdutosTest extends BaseTest {

    ProdutosRequest produtos = new ProdutosRequest();

    @Test
    @Tag("todos")
    @Description("Deve listar os produtos com sucesso.")
    public void deveListarProdutosComSucesso() throws Exception {
        produtos.listar()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }

    @Test
    @Tag("todos")
    @Tag("schemas")
    @Description("Deve validar o schema json da lista de produtos.")
    public void deveValidarSchemaListarProdutos() throws Exception {
        produtos.listar()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/produtos/produtos.json"));
    }

    @Test
    @Tag("todos")
    @Description("Deve buscar um unico produto com sucesso")
    public void deveBuscarUnicoProdutoSucesso() throws Exception {
        String idPrimeiroProduto = produtos.buscarIdPrimeiroUsuario();

        produtos.buscarPorId(idPrimeiroProduto)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }

    @Test
    @Tag("schema")
    @Tag("todos")
    @Description("Deve validar o schema de um único produto")
    public void deveValidarSchemaUnicoProduto() throws Exception {
        String idPrimeiroProduto = produtos.buscarIdPrimeiroUsuario();

        produtos.buscarPorId(idPrimeiroProduto)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/produtos/produto.json"));
    }
}



