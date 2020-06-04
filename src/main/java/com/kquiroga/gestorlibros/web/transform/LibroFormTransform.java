package com.kquiroga.gestorlibros.web.transform;

import org.springframework.stereotype.Component;

import com.kquiroga.gestorlibros.negocio.model.Libros;
import com.kquiroga.gestorlibros.web.model.LibroForm;

@Component
public class LibroFormTransform {

    public Libros libroFormALibro(final LibroForm libroForm) {
        final Libros libro = new Libros();
        libro.setId(libroForm.getId());
        libro.setNombreAutor(libroForm.getNombreAutor());
        libro.setFecha_edicion(libroForm.getFechaEdicion());
        libro.setFecha_publicacion(libroForm.getFechaPublicacion());
        libro.setIsbn(libroForm.getIsbn());
        libro.setNumeroPaginas(Long.parseLong(libroForm.getNumPaginas()));
        libro.setTitulo(libroForm.getTitulo());
        return libro;
    }
}
