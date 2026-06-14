package com.cibertec.ms_citas.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroCita;

    private LocalDate fecha;
    private LocalTime hora;
    private String especialidad;
    private Long codigoPaciente;
    private String estado;

    public Cita() {}

    public Long getNumeroCita() { return numeroCita; }
    public void setNumeroCita(Long numeroCita) { this.numeroCita = numeroCita; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public Long getCodigoPaciente() { return codigoPaciente; }
    public void setCodigoPaciente(Long codigoPaciente) { this.codigoPaciente = codigoPaciente; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}