package com.cibertec.ms_utenticacion.dto;

public record LoginRequest(
        String correo,
        String password
) {
}
