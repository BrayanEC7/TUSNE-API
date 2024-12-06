package com.example.tusne.Controller;

import com.example.tusne.Controller.Dto.MenuDto;
import com.example.tusne.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/menu/")
@CrossOrigin(origins = "*")
public class MenuController {
    @Autowired
    MenuService servicio;

    @GetMapping("menupadres")
    public ResponseEntity<List<MenuDto>> getAllConMenuPadres(){
        try{
            return  new ResponseEntity<>(servicio.getAllConMenuPadres(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<MenuDto> save(@RequestBody MenuDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveMenu(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<MenuDto> update(@RequestBody MenuDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveMenu(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteMenu(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
