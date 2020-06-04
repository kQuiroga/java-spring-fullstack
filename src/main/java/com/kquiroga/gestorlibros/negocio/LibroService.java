package com.kquiroga.gestorlibros.negocio;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;

import com.kquiroga.gestorlibros.web.model.LibroBean;
import com.kquiroga.gestorlibros.web.model.LibroForm;

public interface LibroService {

    List<LibroBean> obtenerListado();

    List<LibroBean> obtenerLibrosPorAutor(final String autorNombre);

    LibroBean obtenerLibrosPorTitulo(final String titulo);

    void insertarLibro(LibroForm libroForm) throws NoResultException, IOException;

    void actualizarLibro(LibroForm libroForm);

    void borrarLibro(LibroForm libroForm);

    String devolverImagen(Long id) throws IOException;
}
