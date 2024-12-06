package com.example.tusne.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rol_id", nullable = false)
    private UUID id;
    @Column(name = "rol_nombre", nullable = false)
    private String nombre_rol;
    @Column(name = "rol_descripcion", nullable = false)
    private String descripcion_rol;

}
