package com.example.tusne.Controller.Dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private int codigo=200;
    private String mensaje="";
    private String token="";
}
