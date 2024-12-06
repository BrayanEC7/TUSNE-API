package com.example.tusne.Controller;

import com.example.tusne.Controller.Dto.AmbienteDto;
import com.example.tusne.Service.AmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/ambientes/")
@CrossOrigin(origins = "*")
public class AmbienteController {
    @Autowired
    AmbienteService servicio;

    @GetMapping()
    public ResponseEntity<List<AmbienteDto>> getAll(){
        try{
            return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<AmbienteDto> save(@RequestBody AmbienteDto dto){
        try{
            return new ResponseEntity<>(servicio.saveAmbiente(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping()
    public ResponseEntity<AmbienteDto> update(@RequestBody AmbienteDto dto){
        try{
            return new ResponseEntity<>(servicio.saveAmbiente(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteAmbiente(id))?"Registro Eliminado":"Error al eliminar el rregistro";
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
