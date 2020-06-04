package com.kquiroga.gestorlibros.negocio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kquiroga.gestorlibros.negocio.AutoresService;
import com.kquiroga.gestorlibros.negocio.model.Autores;
import com.kquiroga.gestorlibros.persistence.dao.AutoresDAO;
import com.kquiroga.gestorlibros.persistence.model.AutoresEntity;
import com.kquiroga.gestorlibros.persistence.trasform.AutorEntityTransform;
import com.kquiroga.gestorlibros.web.model.AutorBean;
import com.kquiroga.gestorlibros.web.model.AutorForm;
import com.kquiroga.gestorlibros.web.transform.AutorBeanTransform;

@Service
public class AutoresServiceImpl implements AutoresService {

    @Autowired
    private AutoresDAO autoresDao;

    @Autowired
    @Qualifier("autorEntityTransform")
    private AutorEntityTransform autorEntity2Autor;

    @Autowired
    private AutorBeanTransform autor2AutorBean;

    @Override
    @Transactional

    public List<AutorBean> obtenerListado() {

        final List<Autores> listaAutores = getAutores();

        return autor2AutorBean.listaAutorAAutorBean(listaAutores);
    }

    private List<Autores> getAutores(){

        final List<AutoresEntity> listaAutoresEntity = autoresDao.buscarListadoAutores();

        return autorEntity2Autor.listaAutorEntityAAutor(listaAutoresEntity);

    }

    @Override
    @Transactional
    public AutorBean obtenerAutoresPorNombre(final AutorForm autorForm) {

        final Autores autor = getAutoresXNombre(autorForm);

        return autor2AutorBean.autorAAutorBean(autor);

    }

    private Autores getAutoresXNombre(final AutorForm autorForm) {

        final Autores autores = new Autores();
        autores.setNombre(autorForm.getNombre());

        final AutoresEntity autoresEntity = autoresDao.buscarAutoresPorNombre(autores.getNombre());

        return autorEntity2Autor.autorEntityAAutor(autoresEntity);

    }
}
