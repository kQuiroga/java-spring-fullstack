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

import com.kquiroga.gestorlibros.negocio.model.Autores;
import com.kquiroga.gestorlibros.persistence.dao.LibrosDAO;
import com.kquiroga.gestorlibros.persistence.dao.service.impl.AbstractJpaServicio;
import com.kquiroga.gestorlibros.persistence.model.LibrosEntity;

@Repository
@Component("librosDao")
public class LibrosDAOImpl extends AbstractJpaServicio implements LibrosDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<LibrosEntity> obtenerListadoLibros() {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilber = session.getCriteriaBuilder();
        final CriteriaQuery<LibrosEntity> criQuery = criBuilber.createQuery(LibrosEntity.class);
        criQuery.from(LibrosEntity.class);

        final TypedQuery<LibrosEntity> query = session.createQuery(criQuery);

        return query.getResultList();
    }

    @Override
    public List<LibrosEntity> buscarLibrosPorAutor(final Autores autor) {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<LibrosEntity> criQuery = criBuilder.createQuery(LibrosEntity.class);
        final Root<LibrosEntity> librosEntityRoot = criQuery.from(LibrosEntity.class);
        criQuery.where(criBuilder.equal(librosEntityRoot.get("autor"), autor.getId()));

        final TypedQuery<LibrosEntity> query = session.createQuery(criQuery);

        return query.getResultList();
    }

    @Override
    public LibrosEntity buscarLibrosPorTitulo(final String titulo) {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<LibrosEntity> criQuery = criBuilder.createQuery(LibrosEntity.class);
        final Root<LibrosEntity> librosEntityRoot = criQuery.from(LibrosEntity.class);
        criQuery.where(criBuilder.equal(librosEntityRoot.get("titulo"), titulo));

        final TypedQuery<LibrosEntity> query = session.createQuery(criQuery);

        return query.getSingleResult();
    }

    @Override
    public String obtenerImagenPorId(final Long id) {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<LibrosEntity> criQuery = criBuilder.createQuery(LibrosEntity.class);
        final Root<LibrosEntity> librosEntityRoot = criQuery.from(LibrosEntity.class);
        criQuery.where(criBuilder.equal(librosEntityRoot.get("id"), id));

        final TypedQuery<LibrosEntity> query = session.createQuery(criQuery);

        return query.getSingleResult().getPathImagenPortada();
    }

    @Override
    public LibrosEntity obtenerLibroPorId(final Long id) {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder criBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<LibrosEntity> criQuery = criBuilder.createQuery(LibrosEntity.class);
        final Root<LibrosEntity> librosEntityRoot = criQuery.from(LibrosEntity.class);
        criQuery.where(criBuilder.equal(librosEntityRoot.get("id"), id));

        final TypedQuery<LibrosEntity> query = session.createQuery(criQuery);
        return query.getSingleResult();
    }
}
