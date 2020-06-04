package com.kquiroga.gestorlibros.persistence.trasform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kquiroga.gestorlibros.negocio.model.Autores;
import com.kquiroga.gestorlibros.persistence.model.AutoresEntity;

@Component
public class AutorEntityTransform {

    public Autores autorEntityAAutor(final AutoresEntity autorEntity) {

        final Autores autor = new Autores();
        autor.setFechaFallecimiento(autorEntity.getFechaFallecimiento());
        autor.setFechaNacimiento((autorEntity.getFechaNacimiento()));
        autor.setId((autorEntity.getId()));
        autor.setLugarNacimiento((autorEntity.getLugarNacimiento()));
        autor.setNombre((autorEntity.getNombre()));

        return autor;
    }

    public List<Autores> listaAutorEntityAAutor(final List<AutoresEntity> listaAutoresEntity) {
        final List<Autores> listaAutores = new ArrayList<Autores>();

        for (final AutoresEntity autoresEntity : listaAutoresEntity) {
            listaAutores.add(autorEntityAAutor(autoresEntity));
        }

        return listaAutores;
    }

}
