package com.example.tusne.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ambiente")
public class AmbienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ambi_id", nullable = false)
    private UUID id;
    @Column(name = "ambi_denominacion", nullable = false)
    private String denominacion_ambi;
    @Column(name = "ambi_capacidad", nullable = false)
    private Integer capacidad_ambi;
    @Column(name = "ambi_direccion", nullable = false)
    private String direccion_ambi;
    @Column(name = "ambi_precioporhora", nullable = false)
    private Float precioporhora_ambi;
    @Column(name = "ambi_fecha_creacion", nullable = false)
    private Date fecha_creacion_ambi;
    @Column(name = "ambi_fecha_actualizacion", nullable = false)
    private Date fecha_actualizacion_ambi;
    @Column(name = "ambi_estado", nullable = false)
    private String estado_ambi;
}
