package com.kquiroga.gestorlibros.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class LibrosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO", columnDefinition = "VARCHAR(50)", unique = true, nullable = false)
    private String titulo;

    @Column(name = "ISBN", columnDefinition = "VARCHAR(14)", nullable = false)
    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AUTOR", nullable = false)
    private AutoresEntity autor;

    @Column(name = "NUMERO_PAGINAS", nullable = false)
    private Long numeroPaginas;

    @Column(name = "FECHA_PUBLICACION", columnDefinition = "VARCHAR(10)")
    private String fecha_publicacion;

    @Column(name = "FECHA_EDICION", columnDefinition = "VARCHAR(10)")
    private String fecha_edicion;

    @Column(name = "IMAGEN_PORTADA_PATH")
    private String pathImagenPortada;

    public String getPathImagenPortada() {
        return pathImagenPortada;
    }

    public void setPathImagenPortada(final String pathImagenPortada) {
        this.pathImagenPortada = pathImagenPortada;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
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

    public Long getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(final Long numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public AutoresEntity getAutor() {
        return autor;
    }

    public void setAutor(final AutoresEntity autor) {
        this.autor = autor;
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
}
