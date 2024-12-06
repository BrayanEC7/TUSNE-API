package com.example.tusne.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class ReservaDto {

    private UUID id;
    private UUID personaId;
    private UUID ambienteId;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaReserva;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaSolicitud;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaActualizacion=new Date();
    private Integer totalRese;
    private String pago_estadoRese;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date horaInicio;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date horaFin;
    private String denominacion_ambi;
    private String dniPers;

}
