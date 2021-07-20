package io.guthub.maximilianoalves.tests.usuarios.tests;

import io.guthub.maximilianoalves.tests.base.tests.BaseTest;
import io.guthub.maximilianoalves.tests.usuarios.requests.UsuariosRequest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class ListarUsuariosTest extends BaseTest {

    UsuariosRequest usuarios = new UsuariosRequest();

    @Test
    public void deveListarUsuariosComSucesso() throws Exception {
        usuarios.listar()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }
}
