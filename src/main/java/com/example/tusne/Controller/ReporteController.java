package com.example.tusne.Controller;

import com.example.tusne.Controller.Dto.ReporteDto;
import com.example.tusne.Service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/reporte/")
@CrossOrigin(origins = "*")
public class ReporteController {
    @Autowired
    ReporteService servicio;

    @GetMapping()
    public ResponseEntity<List<ReporteDto>> getAllReporte(){
        try {
            return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ReporteDto> save(@RequestBody ReporteDto dto){
        try {
            return new ResponseEntity<>(servicio.saveReporte(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<ReporteDto> update(@RequestBody ReporteDto dto){
        try {
            return new ResponseEntity<>(servicio.saveReporte(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteReporte(id))?"Registro Eliminado":"Error al eliminar Registro";
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
