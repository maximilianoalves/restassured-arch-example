package io.guthub.maximilianoalves.payloads.model;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginModel {

    private String email;
    private String password;

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
