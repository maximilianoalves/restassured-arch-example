package io.github.maximilianoalves.tests.usuarios.tests;

import com.github.javafaker.Faker;
import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.usuarios.requests.UsuariosRequest;
import io.github.maximilianoalves.utils.Utils;
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
    Faker faker = Utils.faker;

    @Test
    @Tag("todos")
    @Description("Deve cadastrar um usuário administrador com sucesso")
    public void deveCadastrarUsuarioAdministradorComSucesso() throws Exception {
        usuarios.cadastrar(true)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("message", equalTo("Cadastro realizado com sucesso"), "_id", notNullValue());
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar um usuário administrador nome em branco")
    public void deveCadastrarUsuarioAdministradorNomeEmBranco() throws Exception {
        usuarios.cadastrar("", faker.internet().emailAddress(), "teste", true)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("nome", equalTo("nome não pode ficar em branco"));
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar um usuário administrador email em branco")
    public void deveCadastrarUsuarioAdministradorEmailEmBranco() throws Exception {
        usuarios.cadastrar(faker.name().fullName(), "", "teste", true)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("email", equalTo("email não pode ficar em branco"));
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar um usuário administrador senha em branco")
    public void deveCadastrarUsuarioAdministradorSenhaEmBranco() throws Exception {
        usuarios.cadastrar(faker.name().fullName(), faker.internet().emailAddress(), "", true)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("password", equalTo("password não pode ficar em branco"));
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar um usuário não administrador com sucesso")
    public void deveCadastrarUsuarioNaoAdministradorComSucesso() throws Exception {
        usuarios.cadastrar(false)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("message", equalTo("Cadastro realizado com sucesso"), "_id", notNullValue());
    }

}
