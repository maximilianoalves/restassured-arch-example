package io.github.maximilianoalves.tests.login.tests;

import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.login.requests.LoginRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@Slf4j
@Feature("Login")
public class LoginTest extends BaseTest {

    LoginRequest loginRequest = new LoginRequest();

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com sucesso.")
    public void deveRealizarOLoginComSucesso() throws Exception {
        loginRequest.logar("fulano@qa.com", "teste")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Login realizado com sucesso"));
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com email inválido.")
    public void deveRealizarOLoginComEmailInvalido() throws Exception {
        loginRequest.logar("emailinvalido", "teste")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("email", equalTo("email deve ser um email válido"));
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com email em branco.")
    public void deveRealizarOLoginComEmailEmBranco() throws Exception {
        loginRequest.logar("", "teste")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("email", equalTo("email não pode ficar em branco"));
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com senha inválida.")
    public void deveRealizarOLoginComSenhaInvalida() throws Exception {
        loginRequest.logar("fulano@qa.com", "test")
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("message", equalTo("Email e/ou senha inválidos"));
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com senha em branco.")
    public void deveRealizarOLoginComSenhaEmBranco() throws Exception {
        loginRequest.logar("fulano@qa.com", "")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("password", equalTo("password não pode ficar em branco"));
    }

    @Test
    @Tag("todos")
    @Description("Não deve ser permitido realizar um GET no login.")
    public void naoDeveSerRealizadoUmGetNoLogin() throws Exception {
        loginRequest.getLogin("fulano@qa.com", "")
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                .body("message", equalTo("Não é possível realizar GET em /login. Acesse https://serverest.dev para ver as rotas disponíveis e como utilizá-las."));
    }

    @Test
    @Tag("todos")
    @Description("Não deve ser permitido realizar um PUT no login.")
    public void naoDeveSerRealizadoUmPutNoLogin() throws Exception {
        loginRequest.putLogin("fulano@qa.com", "")
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                .body("message", equalTo("Não é possível realizar PUT em /login. Acesse https://serverest.dev para ver as rotas disponíveis e como utilizá-las."));
    }

    @Test
    @Tag("todos")
    @Description("Não deve ser permitido realizar um DELETE no login.")
    public void naoDeveSerRealizadoUmDeleteNoLogin() throws Exception {
        loginRequest.deleteLogin("fulano@qa.com", "")
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                .body("message", equalTo("Não é possível realizar DELETE em /login. Acesse https://serverest.dev para ver as rotas disponíveis e como utilizá-las."));
    }



}
