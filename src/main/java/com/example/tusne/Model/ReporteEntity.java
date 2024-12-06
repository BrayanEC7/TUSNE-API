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
@Table(name = "tb_reporte_reserva")
public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "repor_id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "repor_ambiente_fk", referencedColumnName = "ambi_id")
    private AmbienteEntity ambiente;

    @OneToOne
    @JoinColumn(name = "repor_persona_fk", referencedColumnName = "pers_id")
    private PersonaEntity persona;

    @Column(name = "repor_fecha_inicio", nullable = false)
    private Date fechaInicioRepor;

    @Column(name = "repor_fecha_fin", nullable = false)
    private Date fechaFinRepor;

    @Column(name = "repor_cantidad_reservas_ambiente", nullable = false)
    private Integer repor_cant_res_ambiente;

    @Column(name = "repor_cantidad_reservas_persona", nullable = false)
    private Integer repor_cant_res_persona;
}
