package io.github.maximilianoalves.tests.login.tests;

import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.login.requests.LoginRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@Slf4j
@Feature("Login")
public class LoginTest extends BaseTest {

    LoginRequest loginRequest = new LoginRequest();

    @Test
    @Description("Deve realizar o login com sucesso.")
    public void deveRealizarOLoginComSucesso() throws Exception {
        loginRequest.logar("fulano@qa.com", "teste")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Login realizado com sucesso"));
    }
}
