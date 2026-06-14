package com.cibertec.ms_pacientes.controller;

import com.cibertec.ms_pacientes.entity.Paciente;
import com.cibertec.ms_pacientes.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.registrar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.consultar(id));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }
}