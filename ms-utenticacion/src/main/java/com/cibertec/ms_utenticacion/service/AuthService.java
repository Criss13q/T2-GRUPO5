package com.cibertec.ms_utenticacion.service;

import com.cibertec.ms_utenticacion.dto.AuthResponse;
import com.cibertec.ms_utenticacion.dto.LoginRequest;
import com.cibertec.ms_utenticacion.dto.RegistroRequest;
import com.cibertec.ms_utenticacion.dto.ValidacionResponse;
import com.cibertec.ms_utenticacion.entity.PersonalMedico;
import com.cibertec.ms_utenticacion.repository.PersonalMedicoRepository;

import com.cibertec.ms_utenticacion.security.JwtService;
import io.jsonwebtoken.Claims;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PersonalMedicoRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            PersonalMedicoRepository repository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String registrar(RegistroRequest request) {
        if (repository.existsByCorreo(request.correo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        if (repository.existsByDni(request.dni())) {
            throw new RuntimeException("El DNI ya está registrado");
        }

        PersonalMedico personal = new PersonalMedico();
        personal.setNombreCompleto(request.nombreCompleto());
        personal.setDni(request.dni());
        personal.setCorreo(request.correo());
        personal.setPassword(passwordEncoder.encode(request.password()));
        personal.setRol(request.rol());

        repository.save(personal);

        return "Personal médico registrado correctamente";
    }

    public AuthResponse login(LoginRequest request) {
        PersonalMedico personal = repository.findByCorreo(request.correo())
                .orElseThrow(() -> new RuntimeException("Correo o contraseña incorrectos"));

        if (!passwordEncoder.matches(request.password(), personal.getPassword())) {
            throw new RuntimeException("Correo o contraseña incorrectos");
        }

        String token = jwtService.generarToken(personal.getCorreo(), personal.getRol());

        return new AuthResponse(token);
    }

    public ValidacionResponse validar(String token) {
        if (!jwtService.validarToken(token)) {
            return new ValidacionResponse(false, null, null);
        }

        Claims claims = jwtService.obtenerClaims(token);

        return new ValidacionResponse(
                true,
                claims.getSubject(),
                claims.get("rol", String.class)
        );
    }
}
