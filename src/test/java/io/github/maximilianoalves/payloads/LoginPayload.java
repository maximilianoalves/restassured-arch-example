package io.github.maximilianoalves.payloads;

import com.google.gson.Gson;
import io.github.maximilianoalves.payloads.model.login.LoginModel;

public class LoginPayload {

    public static String toJson(String email, String password){
        LoginModel login = new LoginModel(email, password);
        return new Gson().toJson(login);
    }

}
