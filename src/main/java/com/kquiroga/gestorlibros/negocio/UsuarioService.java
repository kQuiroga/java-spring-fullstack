package com.kquiroga.gestorlibros.negocio;

import com.kquiroga.gestorlibros.web.model.UserForm;

public interface UsuarioService {
    void registrarNuevoUsuario(UserForm userForm);

    Boolean nombreUsuarioNoDisponible(String usuario);
}
