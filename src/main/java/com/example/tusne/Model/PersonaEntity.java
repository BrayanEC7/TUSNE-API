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
@Table(name = "tb_persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pers_id", nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "pers_rol_fk", referencedColumnName = "rol_id")
    private RolEntity rol;
    @Column(name = "pers_nombre", nullable = false)
    private String nombrePers;
    @Column(name = "pers_dni", nullable = false, length = 8)
    private String dniPers;
    @Column(name = "pers_cargo", nullable = false)
    private String cargoPers;
    @Column(name = "pers_denominacion", nullable = false)
    private String denominacionPers;
    @Column(name = "pers_asociacion", nullable = false)
    private String asociacionPers;
    @Column(name = "pers_apellido_pat", nullable = false)
    private String apellido_patPers;
    @Column(name = "pers_apellido_mat", nullable = false)
    private String apellido_matPers;
    @Column(name = "pers_correo", nullable = false)
    private String correoPers;
    @Column(name = "pers_telefono", nullable = false)
    private Integer telefonoPers;
    @Column(name = "pers_fecha_registro", nullable = false)
    private Date fecha_registroPers;
    @Column(name = "pers_fecha_actualizacion", nullable = false)
    private Date fecha_actualizacionPers;
    @Column(name = "pers_clave", nullable = false)
    private String clavePers;
    @Column(name = "pers_estado", nullable = false, length = 10)
    private String estadoPers;
    @Column(name = "pers_codigo_boleta", nullable = true)
    private String codigoBoletaPers;
}
