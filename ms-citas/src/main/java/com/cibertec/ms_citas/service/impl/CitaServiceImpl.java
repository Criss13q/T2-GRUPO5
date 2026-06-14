package com.cibertec.ms_citas.service.impl;

import com.cibertec.ms_citas.entity.Cita;
import com.cibertec.ms_citas.feign.PacienteClient;
import com.cibertec.ms_citas.repository.CitaRepository;
import com.cibertec.ms_citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PacienteClient pacienteClient;

    @Override
    public Cita registrarCita(Cita cita) {
        try {

            Object paciente = pacienteClient.obtenerPacientePorId(cita.getCodigoPaciente());
            if (paciente == null) {
                throw new RuntimeException("El paciente no existe.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al validar paciente. Asegúrate de que el ID exista y ms-pacientes esté UP. Detalle: " + e.getMessage());
        }

        cita.setEstado("PENDIENTE");
        return citaRepository.save(cita);
    }

    @Override
    public Cita consultarCita(Long numeroCita) {
        return citaRepository.findById(numeroCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    @Override
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }
}