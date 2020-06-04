package com.kquiroga.gestorlibros.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "autores")
public class AutoresEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NOMBRE_AUTOR", columnDefinition = "VARCHAR(40)")
    private String nombre;

    @NotNull
    @Column(name = "FECHA_NACIMIENTO", columnDefinition = "VARCHAR(10)")
    private String fechaNacimiento;

    @NotNull
    @Column(name = "LUGAR_NACIMIENTO", columnDefinition = "VARCHAR(80)")
    private String lugarNacimiento;

    @NotNull
    @Column(name = "FECHA_FALLECIMIENTO", columnDefinition = "VARCHAR(10)")
    private String fechaFallecimiento;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(final String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(final String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(final String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

}
