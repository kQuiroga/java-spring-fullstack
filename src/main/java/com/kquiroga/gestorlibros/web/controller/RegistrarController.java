package com.kquiroga.gestorlibros.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kquiroga.gestorlibros.negocio.UsuarioService;
import com.kquiroga.gestorlibros.web.model.UserForm;

@Controller
public class RegistrarController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/registro")
    public ModelAndView devolverVista() {
        return new ModelAndView("public/register", "userForm", new UserForm());
    }

    @PostMapping("/procesoRegistro")
    public ModelAndView registrarUsuario(@ModelAttribute @Valid final UserForm userForm,
            final BindingResult bindingResult, final Errors errors) {
        String mensajeError = "";
        if (bindingResult.hasErrors()) {
            mensajeError = bindingResult.getGlobalError().getDefaultMessage();
            return new ModelAndView("public/register", "error", mensajeError);
        } else {
            usuarioService.registrarNuevoUsuario(userForm);
            return new ModelAndView("redirect:public/index");
        }
    }
}