package com.cibertec.ms_pacientes.service;

import com.cibertec.ms_pacientes.entity.Paciente;
import java.util.List;

public interface PacienteService {
    Paciente registrar(Paciente paciente);
    Paciente consultar(Long id);
    List<Paciente> listar();
}