package com.cibertec.ms_pacientes.repository;

import com.cibertec.ms_pacientes.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
