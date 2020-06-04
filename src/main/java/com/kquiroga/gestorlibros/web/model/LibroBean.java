package com.kquiroga.gestorlibros.web.model;

public class LibroBean {

    private Long id;
    private String isbn;
    private String titulo;
    private String autor;
    private Long numeroPaginas;
    private String publicacion;
    private String edicion;
    private boolean tieneImagen;

    public String getAutor() {
        return autor;
    }

    public void setAutor(final String autor) {
        this.autor = autor;
    }

    public Long getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(final Long numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(final String publicacion) {
        this.publicacion = publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(final String edicion) {
        this.edicion = edicion;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean getTieneImagen() {
        return tieneImagen;
    }

    public void setTieneImagen(final boolean tieneImagen) {
        this.tieneImagen = tieneImagen;
    }
}
