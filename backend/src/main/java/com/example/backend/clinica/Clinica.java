package com.example.backend.clinica;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    private String nombre;
    private String direccion;
    private int cantidad_camas;
    private String telefono;
    private String ciudad;
    private LocalDate fecha_creacion;
}
