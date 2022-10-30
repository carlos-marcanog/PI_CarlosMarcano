package com.portafolio.carlosmarcano.dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    @NotBlank
    private String nombreExp;

    @NotBlank
    private String descripcionExp;

    @NotBlank
    private String cargo;

    @NotBlank
    private String fechaIngreso;

    private String fechaEgreso;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String descripcionExp, String cargo, String fechaIngreso, String fechaEgreso) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getCargo() { return cargo; }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngeso) {
        this.fechaIngreso = fechaIngeso;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
}
