package com.kquiroga.gestorlibros.negocio;

import java.util.List;

import com.kquiroga.gestorlibros.web.model.AutorBean;
import com.kquiroga.gestorlibros.web.model.AutorForm;

public interface AutoresService {

    List<AutorBean> obtenerListado();

    AutorBean obtenerAutoresPorNombre(final AutorForm autorForm);
}
