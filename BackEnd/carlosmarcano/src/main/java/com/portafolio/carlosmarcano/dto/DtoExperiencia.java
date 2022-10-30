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
    private String fechaIngeso;

    private String fechaEgreso;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String descripcionExp, String cargo, String fechaIngeso, String fechaEgreso) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.cargo = cargo;
        this.fechaIngeso = fechaIngeso;
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

    public String getFechaIngeso() {
        return fechaIngeso;
    }

    public void setFechaIngeso(String fechaIngeso) {
        this.fechaIngeso = fechaIngeso;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
}
