package io.github.maximilianoalves.tests.usuarios.tests;

import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.usuarios.requests.UsuariosRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

@Feature("Excluir usuários")
public class ExcluirUsuariosTest extends BaseTest {

    UsuariosRequest usuarios = new UsuariosRequest();

    @Test
    @Tag("todos")
    @Description("Excluir um usuário administrador com sucesso.")
    public void excluirUsuarioAdministradorComSucesso() throws Exception {
        String idUsuario = usuarios.cadastrar(true)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("_id");

        usuarios.excluir(idUsuario)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Registro excluído com sucesso"));
    }

    @Test
    @Tag("todos")
    @Description("Excluir um usuário não administrador com sucesso.")
    public void excluirUsuarioNaoAdministradorComSucesso() throws Exception {
        String idUsuario = usuarios.cadastrar(true)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("_id");

        usuarios.excluir(idUsuario)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Registro excluído com sucesso"));
    }

}
