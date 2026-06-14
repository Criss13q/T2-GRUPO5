package com.cibertec.ms_pacientes.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
}
