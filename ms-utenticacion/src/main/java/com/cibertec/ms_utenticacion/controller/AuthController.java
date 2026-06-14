package com.cibertec.ms_utenticacion.controller;

import com.cibertec.ms_utenticacion.dto.AuthResponse;
import com.cibertec.ms_utenticacion.dto.LoginRequest;
import com.cibertec.ms_utenticacion.dto.RegistroRequest;
import com.cibertec.ms_utenticacion.dto.ValidacionResponse;
import com.cibertec.ms_utenticacion.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrar(@RequestBody RegistroRequest request) {
        return ResponseEntity.ok(service.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @GetMapping("/validar")
    public ResponseEntity<ValidacionResponse> validarToken(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        String token = authorizationHeader.replace("Bearer ", "");
        return ResponseEntity.ok(service.validar(token));
    }
}
