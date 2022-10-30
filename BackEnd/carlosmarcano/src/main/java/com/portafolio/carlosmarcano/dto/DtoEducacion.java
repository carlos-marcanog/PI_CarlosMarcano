package com.portafolio.carlosmarcano.dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String nombreEdu;

    @NotBlank
    private String ubicacion;

    @NotBlank
    private String titulo;

    @NotBlank
    private String anioEgreso;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String ubicacion, String titulo, String anioEgreso) {
        this.nombreEdu = nombreEdu;
        this.ubicacion = ubicacion;
        this.titulo = titulo;
        this.anioEgreso = anioEgreso;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnioEgreso() {
        return anioEgreso;
    }

    public void setAnioEgreso(String anioEgreso) {
        this.anioEgreso = anioEgreso;
    }
}
