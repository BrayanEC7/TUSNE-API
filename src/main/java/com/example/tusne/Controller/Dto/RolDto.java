package com.example.tusne.Controller.Dto;

import lombok.Data;

import java.util.UUID;
@Data
public class RolDto {
    private UUID id;
    private String nombre_rol;
    private String descripcion_rol;
}
