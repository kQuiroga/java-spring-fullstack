package com.kquiroga.gestorlibros.negocio.transform;

import org.springframework.stereotype.Component;

import com.kquiroga.gestorlibros.negocio.model.Libros;
import com.kquiroga.gestorlibros.persistence.model.AutoresEntity;
import com.kquiroga.gestorlibros.persistence.model.LibrosEntity;

@Component
public class LibrosTransform {

    public LibrosEntity libroALibroEntity(final Libros libro, final AutoresEntity autorEntity) {

        final LibrosEntity libroEntity = new LibrosEntity();
        libroEntity.setId(libro.getId());
        libroEntity.setAutor(autorEntity);
        libroEntity.setFecha_edicion(libro.getFecha_edicion());
        libroEntity.setFecha_publicacion(libro.getFecha_publicacion());
        libroEntity.setIsbn(libro.getIsbn());
        libroEntity.setNumeroPaginas(libro.getNumeroPaginas());
        libroEntity.setTitulo(libro.getTitulo());

        return libroEntity;

    }
}
