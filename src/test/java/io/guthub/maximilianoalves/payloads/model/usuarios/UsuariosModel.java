package io.guthub.maximilianoalves.payloads.model.usuarios;

import lombok.Data;

@Data
public class UsuariosModel {

    private String nome;
    private String email;
    private String password;
    private boolean administrador;

    public UsuariosModel(String nome, String email, String password, boolean administrador) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = administrador;
    }
}
