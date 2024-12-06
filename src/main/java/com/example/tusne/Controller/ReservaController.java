package com.example.tusne.Controller;

import com.example.tusne.Controller.Dto.ReservaDto;
import com.example.tusne.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/reservas/")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    ReservaService servicio;

    @GetMapping()
    public ResponseEntity<List<ReservaDto>> getAllReserva(){
        try {
            return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/persona_ambiente")
    public ResponseEntity<List<ReservaDto>> getReservaConPersonaANDAmbiente(){
        try{
            return new ResponseEntity<>(servicio.getReservaConPersonaAmbiente(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ReservaDto> save(@RequestBody ReservaDto dto){
        try {
            return new ResponseEntity<>(servicio.saveReserva(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<ReservaDto> update(@RequestBody ReservaDto dto){
        try {
            return new ResponseEntity<>(servicio.saveReserva(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteReserva(id))?"Registro Eliminado":"Error al eliminar Registro";
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
