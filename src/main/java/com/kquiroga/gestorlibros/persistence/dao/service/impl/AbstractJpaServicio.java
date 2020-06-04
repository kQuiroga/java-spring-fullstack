package com.kquiroga.gestorlibros.persistence.dao.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kquiroga.gestorlibros.persistence.dao.service.JpaServicio;

public abstract class AbstractJpaServicio implements JpaServicio {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public <T> T insertar(final T object) {
        sessionFactory.getCurrentSession().persist(object);
        return object;
    }

    @Override
    public <T> T borrar(final T object) {
        sessionFactory.getCurrentSession().delete(object);
        return object;
    }

    @Override
    public <T> T actualizar(final T object) {
        sessionFactory.getCurrentSession().update(object);
        return object;
    }
}
