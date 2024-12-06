package com.example.tusne.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class AmbienteDto {
    private UUID id;
    private String denominacion_ambi;
    private Integer capacidad_ambi;
    private String direccion_ambi;
    private Float precioporhora_ambi;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fecha_creacion_ambi=new Date();
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fecha_actualizacion_ambi=new Date();
    private String estado_ambi;
}
