package com.kquiroga.gestorlibros.persistence.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kquiroga.gestorlibros.persistence.dao.UserDAO;
import com.kquiroga.gestorlibros.persistence.dao.service.impl.AbstractJpaServicio;
import com.kquiroga.gestorlibros.persistence.model.RoleEntity;
import com.kquiroga.gestorlibros.persistence.model.UserEntity;

@Repository
@Component("userDao")
public class UserDAOImpl extends AbstractJpaServicio implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserEntity buscarPorNombreUsuario(final String usuario) {

        final Session session = sessionFactory.openSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<UserEntity> criQuery = criBuilder.createQuery(UserEntity.class);
        final Root<UserEntity> librosEntityRoot = criQuery.from(UserEntity.class);
        criQuery.where(criBuilder.equal(librosEntityRoot.get("username"), usuario));

        final TypedQuery<UserEntity> query = session.createQuery(criQuery);
        return query.getSingleResult();
    }

    @Override
    public RoleEntity buscarRole(final String rol) {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<RoleEntity> criQuery = criBuilder.createQuery(RoleEntity.class);
        final Root<RoleEntity> root = criQuery.from(RoleEntity.class);
        criQuery.where(criBuilder.equal(root.get("name"), rol));

        final TypedQuery<RoleEntity> query = session.createQuery(criQuery);
        return query.getSingleResult();
    }

    @Override
    public List<UserEntity> devolverUsuarios() {
        final Session session = sessionFactory.openSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<UserEntity> criQuery = criBuilder.createQuery(UserEntity.class);
        final Root<UserEntity> librosEntityRoot = criQuery.from(UserEntity.class);

        final TypedQuery<UserEntity> query = session.createQuery(criQuery);
        return query.getResultList();
    }
}
