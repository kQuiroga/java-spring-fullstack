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

import com.kquiroga.gestorlibros.persistence.dao.AutoresDAO;
import com.kquiroga.gestorlibros.persistence.model.AutoresEntity;

@Repository
@Component("autoresDao")
public class AutoresDAOImpl implements AutoresDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AutoresEntity> buscarListadoAutores() {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilber = session.getCriteriaBuilder();
        final CriteriaQuery<AutoresEntity> criQuery = criBuilber.createQuery(AutoresEntity.class);
        final Root<AutoresEntity> root = criQuery.from(AutoresEntity.class);
        criQuery.select(root);

        final TypedQuery<AutoresEntity> query = session.createQuery(criQuery);

        return query.getResultList();

    }

    @Override
    public AutoresEntity buscarAutoresPorNombre(final String nombreAutor) {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<AutoresEntity> criQuery = criBuilder.createQuery(AutoresEntity.class);
        final Root<AutoresEntity> autorEntityRoot = criQuery.from(AutoresEntity.class);
        criQuery.where(criBuilder.equal(autorEntityRoot.get("nombre"), nombreAutor));

        final TypedQuery<AutoresEntity> query = session.createQuery(criQuery);

        return query.getSingleResult();
    }
}
