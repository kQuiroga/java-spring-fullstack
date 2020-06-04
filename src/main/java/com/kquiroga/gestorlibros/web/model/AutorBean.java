package com.kquiroga.gestorlibros.web.model;

public class AutorBean {

    private String nombre;
    private String fechaNacimiento;
    private String lugarNacimiento;
    private String fechaFallecimiento;

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
