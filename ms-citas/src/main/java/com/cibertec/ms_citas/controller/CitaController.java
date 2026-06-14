package com.cibertec.ms_citas.controller;

import com.cibertec.ms_citas.entity.Cita;
import com.cibertec.ms_citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<Cita> registrar(@RequestBody Cita cita) {
        return new ResponseEntity<>(citaService.registrarCita(cita), HttpStatus.CREATED);
    }

    @GetMapping("/{numeroCita}")
    public ResponseEntity<Cita> consultar(@PathVariable Long numeroCita) {
        return ResponseEntity.ok(citaService.consultarCita(numeroCita));
    }

    @GetMapping
    public ResponseEntity<List<Cita>> listar() {
        return ResponseEntity.ok(citaService.listarCitas());
    }
}