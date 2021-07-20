package io.github.maximilianoalves.tests.usuarios.tests;

import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.usuarios.requests.UsuariosRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Feature("Listar usuários")
public class ListarUsuariosTest extends BaseTest {

    UsuariosRequest usuarios = new UsuariosRequest();

    @Test
    @Description("Deve listar os usuários com sucesso.")
    public void deveListarUsuariosComSucesso() throws Exception {
        usuarios.listar()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }

    @Tag("contratos")
    @Test
    @Description("Deve validar o contrato da lista de usuários")
    public void deveValidarContratoListaUsuarios() throws Exception {
        usuarios.listar()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("contratos/usuarios/lista-usuarios.json"));

    }

    @Test
    @Description("Deve listar um usuário utilizando o ID")
    public void deveListarUsuarioUtilizandoId() throws Exception {
        String idUsuario = usuarios.getIdPrimeiroUsuario();
        usuarios.buscarPorId(idUsuario)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }

    @Tag("contratos")
    @Test
    @Description("Deve validar o contrato de um usuário utilizando o ID")
    public void deveValidarContratoUsuarioUtilizandoId() throws Exception {
        String idUsuario = usuarios.getIdPrimeiroUsuario();
        usuarios.buscarPorId(idUsuario)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("contratos/usuarios/usuario.json"));
    }
}
