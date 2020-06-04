package com.kquiroga.gestorlibros.negocio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kquiroga.gestorlibros.negocio.model.MyUserPrincipal;
import com.kquiroga.gestorlibros.persistence.dao.UserDAO;
import com.kquiroga.gestorlibros.persistence.model.UserEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final UserEntity user = userDao.buscarPorNombreUsuario(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new MyUserPrincipal(user);
    }
}
