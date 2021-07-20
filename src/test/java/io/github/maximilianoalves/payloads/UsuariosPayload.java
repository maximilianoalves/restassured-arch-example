package io.github.maximilianoalves.payloads;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.github.maximilianoalves.utils.Utils;
import io.github.maximilianoalves.payloads.model.usuarios.UsuariosModel;
import lombok.Data;

@Data
public class UsuariosPayload {

    public static Faker faker = Utils.faker;

    public static String toJson(boolean administrador){
        UsuariosModel usuariosModel = new UsuariosModel(faker.name().fullName(), faker.internet().emailAddress(), "teste", administrador);
        return new Gson().toJson(usuariosModel);
    }

    public static String toJson(String nome, String email, String password, boolean administrador){
        UsuariosModel usuariosModel = new UsuariosModel(nome, email, password, administrador);
        return new Gson().toJson(usuariosModel);
    }
}
