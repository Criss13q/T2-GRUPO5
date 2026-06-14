package com.cibertec.ms_utenticacion.dto;

public record RegistroRequest(
        String nombreCompleto,
        String dni,
        String correo,
        String password,
        String rol
) {}