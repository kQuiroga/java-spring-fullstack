package com.kquiroga.gestorlibros.persistence.dao;

import java.util.List;

import com.kquiroga.gestorlibros.persistence.dao.service.JpaServicio;
import com.kquiroga.gestorlibros.persistence.model.RoleEntity;
import com.kquiroga.gestorlibros.persistence.model.UserEntity;

public interface UserDAO extends JpaServicio {
    UserEntity buscarPorNombreUsuario(String username);

    RoleEntity buscarRole(String rol);

    List<UserEntity> devolverUsuarios();
}
