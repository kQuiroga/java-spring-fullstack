package com.kquiroga.gestorlibros.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kquiroga.gestorlibros.negocio.AutoresService;

@Controller
@RequestMapping("/ListadoAutores")
public class AutoresController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping
    public ModelAndView devolverListaAutores() {
        return new ModelAndView("public/autoresViews/autores").addObject("lista", autoresService.obtenerListado());
    }
}
