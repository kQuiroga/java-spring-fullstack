package com.kquiroga.gestorlibros.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kquiroga.gestorlibros.negocio.LibroService;
import com.kquiroga.gestorlibros.web.model.LibroBean;
import com.kquiroga.gestorlibros.web.model.LibroForm;

@Controller
public class LibrosController {

    private final Logger LOGGER = LoggerFactory.getLogger(LibrosController.class);

    @Autowired
    private LibroService libroService;

    @RequestMapping("/ListadoLibros")
    public ModelAndView devolverVistaListadoLibros(final Model model) {
        model.addAttribute("libroForm", new LibroForm());

        return new ModelAndView("public/librosViews/libros").addObject("listaLibros",
                libroService.obtenerListado());
    }

    @PostMapping("/ResultadoLibros2")
    public ModelAndView getResultadosAutorLibroForm(@ModelAttribute final LibroForm libroForm)
            throws SQLException, IOException {

        final ModelAndView modelAndView = new ModelAndView("public/librosViews/resultadoLibros2");
        final List<LibroBean> listaLibrosPorAutor = libroService.obtenerLibrosPorAutor(libroForm.getNombreAutor());
        if (listaLibrosPorAutor != null) {
            modelAndView.addObject("listaFiltradaLibros", listaLibrosPorAutor);
            return modelAndView;
        } else {
            LOGGER.error("Al realizar la búsqueda por autor {} no existen entradas", libroForm.getNombreAutor());
            return new ModelAndView("public/errors/sinResultados");
        }
    }

    @PostMapping("/ResultadoLibros")
    public ModelAndView getResultadosTituloLibroFrom(@ModelAttribute final LibroForm libroForm) {

        final LibroBean libroBean = libroService.obtenerLibrosPorTitulo(libroForm.getTitulo());
        final ModelAndView modelAndView = new ModelAndView("public/librosViews/resultadoLibros");

        if (!libroBean.getTitulo().isEmpty() || libroBean.getTitulo() != null) {
            modelAndView.addObject("libro", libroBean);
            return modelAndView;
        } else {
            LOGGER.error("Al realizar la búsqueda por título {} no existen entradas", libroForm.getTitulo());
            return new ModelAndView("public/errors/sinResultados");
        }
    }
}
