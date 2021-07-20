package io.guthub.maximilianoalves.tests.login.tests;

import io.guthub.maximilianoalves.payloads.LoginPayload;
import io.guthub.maximilianoalves.tests.base.tests.BaseTest;
import io.guthub.maximilianoalves.tests.login.requests.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class LoginTest extends BaseTest {

    LoginRequest loginRequest = new LoginRequest();

    @Test
    @DisplayName("Deve realizar o login com sucesso.")
    public void deveRealizarOLoginComSucesso() throws Exception {
        loginRequest.logar("fulano@qa.com", "teste")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Login realizado com sucesso"));
    }
}
