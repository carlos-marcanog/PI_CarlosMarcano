package com.portafolio.carlosmarcano.dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String enlace;

    private String img;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombre, String descripcion, String enlace, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
