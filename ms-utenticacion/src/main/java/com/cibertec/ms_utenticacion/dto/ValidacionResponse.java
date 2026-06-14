package com.cibertec.ms_utenticacion.dto;

public record ValidacionResponse(
        boolean valido,
        String correo,
        String rol
) {
}
