package io.github.maximilianoalves.tests.usuarios.tests;

import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.usuarios.requests.UsuariosRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@Feature("Cadastrar usuários")
public class CadastrarUsuariosTest extends BaseTest {

    UsuariosRequest usuarios = new UsuariosRequest();

    @Test
    @Tag("todos")
    @Description("Deve cadastrar um usuário administrador com sucesso")
    public void deveCadastrarUsuarioAdministradoComSucesso() throws Exception {
        usuarios.cadastrar(true)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("message", equalTo("Cadastro realizado com sucesso"), "_id", notNullValue());
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar um usuário não administrador com sucesso")
    public void deveCadastrarUsuarioNaoAdministradoComSucesso() throws Exception {
        usuarios.cadastrar(false)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("message", equalTo("Cadastro realizado com sucesso"), "_id", notNullValue());
    }

}
