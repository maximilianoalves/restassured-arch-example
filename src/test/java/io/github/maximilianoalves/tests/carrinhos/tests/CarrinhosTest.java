package io.github.maximilianoalves.tests.carrinhos.tests;

import io.github.maximilianoalves.tests.base.tests.BaseTest;
import io.github.maximilianoalves.tests.carrinhos.requests.CarrinhosRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class CarrinhosTest extends BaseTest {

    CarrinhosRequest carrinhosRequest = new CarrinhosRequest();

    @Test
    @Tag("todos")
    @Description("Deve listar todos os carrinhos com sucesso.")
    public void deveListarTodosOsCarrinhosComSucesso() throws Exception {
        carrinhosRequest.listar()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }
}
