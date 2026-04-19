package ddd.void_archive.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String contraseña;

    private String telefono;
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    private LocalDateTime fechaRegistro;

    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
        if (this.rol == null) {
            this.rol = Rol.CLIENTE; // Asignar rol por defecto
        }
    }
    public enum Rol{
        CLIENTE, ADMIN
    }
}
