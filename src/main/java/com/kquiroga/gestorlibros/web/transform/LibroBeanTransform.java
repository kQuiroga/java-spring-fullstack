package com.kquiroga.gestorlibros.web.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kquiroga.gestorlibros.negocio.model.Libros;
import com.kquiroga.gestorlibros.web.model.LibroBean;

@Component
public class LibroBeanTransform {

    public List<LibroBean> listaLibrosALibrosBean(final List<Libros> listaLibros) {
        final List<LibroBean> listLibroBean = new ArrayList<LibroBean>();
        for (final Libros libros : listaLibros) {
            listLibroBean.add(libroALibroBean(libros));
        }
        return listLibroBean;
    }

    public LibroBean libroALibroBean(final Libros libro) {
        final LibroBean libroBean = new LibroBean();
        libroBean.setId(libro.getId());
        libroBean.setAutor(libro.getNombreAutor());
        libroBean.setIsbn(libro.getIsbn());
        libroBean.setNumeroPaginas(libro.getNumeroPaginas());
        libroBean.setPublicacion(libro.getFecha_publicacion());
        libroBean.setEdicion(libro.getFecha_edicion());
        libroBean.setTitulo(libro.getTitulo());
        if (!libro.getImagenPortadaPath().isEmpty()) {
            libroBean.setTieneImagen(true);
        } else {
            libroBean.setTieneImagen(false);
        }

        return libroBean;
    }
}
