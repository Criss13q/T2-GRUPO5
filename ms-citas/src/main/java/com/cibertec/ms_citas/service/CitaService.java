package com.cibertec.ms_citas.service;

import com.cibertec.ms_citas.entity.Cita;
import java.util.List;

public interface CitaService {
    Cita registrarCita(Cita cita);
    Cita consultarCita(Long numeroCita);
    List<Cita> listarCitas();
}