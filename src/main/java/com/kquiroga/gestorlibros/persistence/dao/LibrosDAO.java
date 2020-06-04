package com.kquiroga.gestorlibros.persistence.dao;

import java.util.List;

import com.kquiroga.gestorlibros.negocio.model.Autores;
import com.kquiroga.gestorlibros.persistence.dao.service.JpaServicio;
import com.kquiroga.gestorlibros.persistence.model.LibrosEntity;

public interface LibrosDAO extends JpaServicio {

    List<LibrosEntity> obtenerListadoLibros();

    List<LibrosEntity> buscarLibrosPorAutor(Autores autor);

    LibrosEntity buscarLibrosPorTitulo(String titulo);

    String obtenerImagenPorId(Long id);

    LibrosEntity obtenerLibroPorId(Long id);
}
