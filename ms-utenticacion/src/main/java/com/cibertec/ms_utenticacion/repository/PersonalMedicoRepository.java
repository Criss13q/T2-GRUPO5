package com.cibertec.ms_utenticacion.repository;

import com.cibertec.ms_utenticacion.entity.PersonalMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalMedicoRepository extends JpaRepository<PersonalMedico, Long> {
    Optional<PersonalMedico> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    boolean existsByDni(String dni);
}
