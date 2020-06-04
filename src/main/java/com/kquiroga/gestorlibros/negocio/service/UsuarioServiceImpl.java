package com.kquiroga.gestorlibros.negocio.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kquiroga.gestorlibros.negocio.UsuarioService;
import com.kquiroga.gestorlibros.persistence.dao.UserDAO;
import com.kquiroga.gestorlibros.persistence.model.UserEntity;
import com.kquiroga.gestorlibros.web.model.UserForm;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UserDAO userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void registrarNuevoUsuario(final UserForm userForm) {
        final UserEntity user = new UserEntity();
        user.setUsername(userForm.getUsername());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setRoles(Arrays.asList(userDao.buscarRole("ROLE_USER")).stream().collect(Collectors.toSet()));
        userDao.insertar(user);
    }

    @Override
    @Transactional
    public Boolean nombreUsuarioNoDisponible(final String usuario) {
        return userDao.devolverUsuarios().stream().anyMatch(x -> x.getUsername().equals(usuario));
    }
}
