package com.example.tusne.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class ReporteDto {
    public UUID id;
    private UUID ambienteId;
    private UUID personaId;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaInicioRepor;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaFinRepor;
    private Integer repor_cant_res_ambiente;
    private Integer repor_cant_res_persona;
}
