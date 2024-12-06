package com.example.tusne.Controller;

import com.example.tusne.Controller.Dto.LoginDto;
import com.example.tusne.Controller.Dto.LoginResponseDto;
import com.example.tusne.Controller.Dto.PersonaDto;
import com.example.tusne.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/personas/")
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    PersonaService servicio;

    @GetMapping()
    public ResponseEntity<List<PersonaDto>> getAll(){
        try{
            return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rol")
    public ResponseEntity<List<PersonaDto>> getRolConCliente(){
        try{
            return new ResponseEntity<>(servicio.getRolConCliente(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<PersonaDto> save(@RequestBody PersonaDto dto){
        try{
            return new ResponseEntity<>(servicio.savePersona(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> save(@RequestBody LoginDto dto){
        return new ResponseEntity<LoginResponseDto>(servicio.login(dto.getUser(),dto.getClave()),HttpStatus.OK);

    }
    @PutMapping()
    public ResponseEntity<PersonaDto> update(@RequestBody PersonaDto dto){
        try{
            return new ResponseEntity<>(servicio.savePersona(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deletePersona(id))?"Registro Eliminado":"Error al eliminar el rregistro";
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
