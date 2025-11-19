package com.example.backend.doctor;

import com.example.backend.clinica.Clinica;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    private String email;
    private String telefono;
    private LocalDate fecha_contratacion;
}
