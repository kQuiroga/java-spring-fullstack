package com.kquiroga.gestorlibros.web.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class LibroForm {

    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 50, message = "El título tiene un máximo de 50 caracteres")
    private String titulo;

    @NotBlank(message = "Debe introducir un autor existente")
    private String nombreAutor;

    @NotBlank(message = "Debe introducir el numero de páginas")
    @Size(max = 4, message = "No existen libros con más de xxxx páginas")
    private String numPaginas;

    @NotBlank(message = "Debe introducir una fecha de publicación")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String fechaPublicacion;

    @NotBlank(message = "Debe introducir una fecha de edición")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String fechaEdicion;

    @Size(min = 10, max = 13, message = "El numero ISBN debe estar comprendido entre 10 y máximo 13")
    private String isbn;

    @NotBlank
    private String imagenPortadaBase64;

    @NotBlank
    private String nombreImagen;

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(final String numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(final String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(final String fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(final String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getImagenPortadaBase64() {
        return imagenPortadaBase64;
    }

    public void setImagenPortadaBase64(final String imagenPortadaBase64) {
        this.imagenPortadaBase64 = imagenPortadaBase64;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(final String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
}
