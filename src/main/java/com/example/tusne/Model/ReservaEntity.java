package com.example.tusne.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rese_id", nullable = false)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "rese_persona_fk", referencedColumnName = "pers_id")
    private PersonaEntity persona;

    @OneToOne
    @JoinColumn(name = "rese_ambiente_fk", referencedColumnName = "ambi_id")
    private AmbienteEntity ambiente;
    @Column(name = "rese_fecha_reserva", nullable = false)
    private Date fechaReserva;
    @Column(name = "rese_fecha_solicitud", nullable = false)
    private Date fechaSolicitud;
    @Column(name = "rese_fecha_actualizacion", nullable = false)
    private Date fechaActualizacion;
    @Column(name = "rese_total", nullable = false)
    private Integer totalRese;
    @Column(name = "rese_estado_pago", nullable = false, length = 9)
    private String pago_estadoRese;
    @Column(name = "rese_hora_inicio", nullable = false)
    private Timestamp horaInicio;
    @Column(name = "rese_hora_fin", nullable = false)
    private Timestamp horaFin;
}
