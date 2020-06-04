package com.kquiroga.gestorlibros.web.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kquiroga.gestorlibros.negocio.model.Autores;
import com.kquiroga.gestorlibros.web.model.AutorBean;

@Component
public class AutorBeanTransform {

    public List<AutorBean> listaAutorAAutorBean(final List<Autores> listaAutores) {
        final List<AutorBean> listaAutorBean = new ArrayList<AutorBean>();
        for (final Autores autores : listaAutores) {
            listaAutorBean.add(autorAAutorBean(autores));
        }
        return listaAutorBean;
    }

    public AutorBean autorAAutorBean(final Autores autores) {
        final AutorBean autorBean = new AutorBean();
        autorBean.setNombre(autores.getNombre());
        autorBean.setFechaFallecimiento(autores.getFechaFallecimiento());
        autorBean.setFechaNacimiento(autores.getFechaNacimiento());
        autorBean.setLugarNacimiento(autores.getLugarNacimiento());

        return autorBean;
    }
}
