package com.example.tusne.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class PersonaDto {
    private UUID id;
    private UUID rolId;
    private String nombrePers;
    private String dniPers;
    private String cargoPers;
    private String denominacionPers;
    private String asociacionPers;
    private String apellido_patPers;
    private String apellido_matPers;
    private String correoPers;
    private Integer telefonoPers;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fecha_registroPers;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fecha_actualizacionPers=new Date();
    private String clavePers;
    private String estadoPers;
    private String nombre_rol;
    private String codigoBoletaPers;
}
