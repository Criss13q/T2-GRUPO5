package com.cibertec.ms_pacientes.service.impl;

import com.cibertec.ms_pacientes.entity.Paciente;
import com.cibertec.ms_pacientes.repository.PacienteRepository;
import com.cibertec.ms_pacientes.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public Paciente registrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente consultar(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }
}