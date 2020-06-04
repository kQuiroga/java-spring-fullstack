package com.kquiroga.gestorlibros.negocio.model;

public class Libros {

    private Long id;

    private String titulo;

    private String isbn;

    private String nombreAutor;

    private Long numeroPaginas;

    private String fecha_publicacion;

    private String fecha_edicion;

    private String imagenPortadaPath;

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

    public Long getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(final Long numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(final String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getFecha_edicion() {
        return fecha_edicion;
    }

    public void setFecha_edicion(final String fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(final String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getImagenPortadaPath() {
        return imagenPortadaPath;
    }

    public void setImagenPortadaPath(String imagenPortadaPath) {
        this.imagenPortadaPath = imagenPortadaPath;
    }
}
