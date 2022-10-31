package com.portafolio.carlosmarcano.dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String cargo;

    @NotBlank
    private String acercade;

    @NotBlank
    private String img;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String cargo, String acercade, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.acercade = acercade;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAcercade() {
        return acercade;
    }

    public void setAcercade(String acercade) {
        this.acercade = acercade;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
