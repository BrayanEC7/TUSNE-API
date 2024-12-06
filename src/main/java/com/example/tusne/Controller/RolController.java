package com.example.tusne.Controller;

import com.example.tusne.Controller.Dto.RolDto;
import com.example.tusne.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/rol/")
@CrossOrigin(origins = "*")
public class RolController {
    @Autowired
    RolService rol;

    @GetMapping()
    public ResponseEntity<List<RolDto>> getAll(){
        try{
            return new ResponseEntity<>(rol.getAll(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/rol")
    public ResponseEntity<List<RolDto>> getRolConCliente(){
        try{
            return new ResponseEntity<>(rol.getAll(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<RolDto> save(@RequestBody RolDto dto){
        try{
            return new ResponseEntity<>(rol.saveRol(dto), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<RolDto> update(@RequestBody RolDto dto){
        try{
            return new ResponseEntity<>(rol.saveRol(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(rol.deleteRol(id))?"REGISTRO ELIMINADO":"ERROR AL ELIMINAR";
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
