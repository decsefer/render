package com.ipn.mx.administracioneventos.core.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Evento", schema = "public")

public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento", nullable = false)
    //SQL ==> idEvento serial primary key
    private int idEvento;

    @NotEmpty(message = "No puede estar vacio")
    @Column(name = "nombreEvento",length = 200, nullable = false)
    private String nombreEvento;


    @NotEmpty(message = "No puede estar vacio")
    @Column(name = "descripcionEvento", length = 500, nullable = false)
    private String descripcionEvento;

    @NotNull(message = "La fecha no debe ser nula")
    @FutureOrPresent(message = "La fecha de incio debera ser hoy o cualquier fecha en el futuro")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @NotNull(message = "La fecha no debe ser nula")
    private Date fechaFin;


}
