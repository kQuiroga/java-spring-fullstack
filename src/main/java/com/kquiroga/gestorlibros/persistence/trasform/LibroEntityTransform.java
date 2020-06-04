package com.kquiroga.gestorlibros.persistence.trasform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kquiroga.gestorlibros.negocio.model.Libros;
import com.kquiroga.gestorlibros.persistence.model.LibrosEntity;

@Component
public class LibroEntityTransform {

    public Libros libroEntityALibro(final LibrosEntity libroEntity) {
        final Libros libro = new Libros();
        libro.setNombreAutor(libroEntity.getAutor().getNombre());
        libro.setFecha_edicion(libroEntity.getFecha_edicion());
        libro.setFecha_publicacion(libroEntity.getFecha_publicacion());
        libro.setId(libroEntity.getId());
        libro.setIsbn(libroEntity.getIsbn());
        libro.setTitulo(libroEntity.getTitulo());
        libro.setNumeroPaginas(libroEntity.getNumeroPaginas());
        libro.setImagenPortadaPath(libroEntity.getPathImagenPortada());

        return libro;
    }

    public List<Libros> listaLibrosEntityALibros(final List<LibrosEntity> listLibrosEntity) {

        final List<Libros> libros = new ArrayList<Libros>();
        for (final LibrosEntity libroEntity : listLibrosEntity) {
            libros.add(libroEntityALibro(libroEntity));
        }
        return libros;
    }

}
