package com.kquiroga.gestorlibros.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kquiroga.gestorlibros.negocio.LibroService;
import com.kquiroga.gestorlibros.web.model.LibroBean;
import com.kquiroga.gestorlibros.web.model.LibroForm;
import com.kquiroga.gestorlibros.web.model.LibroFormAjax;

@Controller
public class AdministracionController {

    private final Logger LOGGER = LoggerFactory.getLogger(AdministracionController.class);

    @Autowired
    LibroService libroService;

    @GetMapping("/administracion")
    public ModelAndView accesoAdministracion() {
        final ModelAndView modelAndView  =  new ModelAndView("private/administracion");
        final List<LibroBean> listLibroBean = libroService.obtenerListado();
        modelAndView.addObject("listaLibros", listLibroBean);
        return modelAndView;
    }

    @GetMapping(value = "/administracion/obtenerImagenes")
    public void obtenerImagenDelLibro(@RequestParam final Long id, final HttpServletResponse resp) throws IOException {
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        final File archivoDescarga = new File(libroService.devolverImagen(id));
        final Path path = archivoDescarga.toPath();
        final OutputStream outputStream = resp.getOutputStream();
        outputStream.write(Files.readAllBytes(path));
        outputStream.flush();
    }

    @PostMapping(value = "/insertarLibro")
    public ResponseEntity<?> insertarLibro(@Valid @RequestBody final LibroForm libroForm,
            final BindingResult result)
            throws JSONException, Exception {
        if (result.hasErrors()) {
            final Map<String, String> errores = new HashMap<String, String>();
            for (final FieldError error : result.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errores, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        } else {
            libroService.insertarLibro(libroForm);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @PostMapping("/modificarLibro")
    public ResponseEntity<?> modificarLibro(@RequestBody final LibroForm libroForm) throws IOException {
        if (null != libroForm) {
            libroService.actualizarLibro(libroForm);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/borrarLibro")
    public ResponseEntity<?> borrarLibro(@RequestBody final LibroForm libroForm) {
        libroService.borrarLibro(libroForm);
        LOGGER.info("Libro con id {} borrado correctamente", libroForm.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/obtenerInfoLibrosPorTitulo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> obtenerInfoLibrosAjaxPorTitulo(@RequestBody final LibroFormAjax libroAjax)
            throws SQLException, IOException {
        final JSONObject resultado = new JSONObject();
        final LibroBean libro = libroService.obtenerLibrosPorTitulo(libroAjax.getTitulo());

        try {
            resultado.put("data", convertirObjectosAJson(libro));
        } catch (final Exception e) {
            LOGGER.error("Error en la creación del json correspondiente al realizar la búsqueda por título", e);
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return new ResponseEntity<>(resultado.toString(), headers, HttpStatus.OK);
    }


    @GetMapping("/obtenerListaTodosLibros")
    @ResponseBody
    public ResponseEntity<String> obtenerListaDeLibrosAjax() throws Exception {
        final JSONObject jsonResultado = new JSONObject();
        final HttpHeaders headers = new HttpHeaders();

        try {
            jsonResultado.put("data", convertirObjectosAJson(libroService.obtenerListado()));
            headers.add("Content-Type", "application/json; charset=UTF-8");
            LOGGER.info("Creado el objeto {}", jsonResultado);
        } catch (final JSONException e) {
            LOGGER.error("Error en la creación del objeto json {)", jsonResultado, e);
        }
        return new ResponseEntity<String>(jsonResultado.toString(), headers, HttpStatus.OK);
    }

    private <T> JSONObject convertirObjectosAJson(final T object) throws JSONException, Exception {
        final Gson gson = new Gson();
        final String json = gson.toJson(object);
        final JSONObject jsonFormado = new JSONObject(json);
        return jsonFormado;
    }
}
