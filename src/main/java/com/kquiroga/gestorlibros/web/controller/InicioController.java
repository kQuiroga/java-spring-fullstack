package com.kquiroga.gestorlibros.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class InicioController {

    @RequestMapping(value = { "/", "inicio" })
    public ModelAndView lanzarIndex() {
        return new ModelAndView("public/index");
    }
}
