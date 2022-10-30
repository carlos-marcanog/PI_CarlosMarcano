package com.portafolio.carlosmarcano.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "La Longitud debe ser entre 1 y 50")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "La Longitud debe ser entre 1 y 50")
    private String apellido;

    @NotNull
    @Size(min = 1, max = 50, message = "La Longitud debe ser entre 1 y 50")
    private String cargo;

    @NotNull
    @Size(min = 1, max = 1000, message = "La Longitud debe ser entre 1 y 50")
    private String acercade;
}

