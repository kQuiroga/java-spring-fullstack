package com.kquiroga.gestorlibros.persistence.dao;

import java.util.List;

import com.kquiroga.gestorlibros.persistence.model.AutoresEntity;

public interface AutoresDAO {

    List<AutoresEntity> buscarListadoAutores();

    AutoresEntity buscarAutoresPorNombre(String nombreAutor);
}
