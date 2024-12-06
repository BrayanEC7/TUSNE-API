package com.example.tusne.Service;

import com.example.tusne.Controller.Dto.LoginResponseDto;
import com.example.tusne.Controller.Dto.PersonaDto;
import com.example.tusne.Model.PersonaEntity;
import com.example.tusne.Service.Repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonaService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PersonaRepository repository;

    public List<PersonaDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, PersonaDto.class))
                    .collect(Collectors.toList());
        }catch (Exception ex){
            return null;
        }
    }

    public String capitalizar(String txt){
        if(txt==null || txt.isEmpty()){
            return txt;
        }
        return txt.substring(0,1).toUpperCase()+txt.substring(1).toLowerCase();
    }
    public List<PersonaDto> getRolConCliente(){
        List<Object[]> resultados = repository.findAllPersona();
        List<PersonaDto> personaDtoList = new ArrayList<>();
        for (Object[] resultado : resultados){
            PersonaEntity personaEntity = (PersonaEntity) resultado[0];
            String nombreRol = (String) resultado[1];
            PersonaDto personaDto = new PersonaDto();
            personaDto.setId(personaEntity.getId());
            personaDto.setRolId(personaEntity.getRol().getId());
            personaDto.setNombrePers(personaEntity.getNombrePers());
            personaDto.setDniPers(personaEntity.getDniPers());
            personaDto.setCargoPers(personaEntity.getCargoPers());
            personaDto.setDenominacionPers(personaEntity.getDenominacionPers());
            personaDto.setAsociacionPers(personaEntity.getAsociacionPers());

            personaDto.setApellido_patPers(personaEntity.getApellido_patPers());
            personaDto.setApellido_matPers(personaEntity.getApellido_matPers());
            personaDto.setCorreoPers(personaEntity.getCorreoPers());
            personaDto.setTelefonoPers(personaEntity.getTelefonoPers());
            personaDto.setFecha_registroPers(personaEntity.getFecha_registroPers());
            personaDto.setFecha_actualizacionPers(personaEntity.getFecha_actualizacionPers());
            personaDto.setClavePers(personaEntity.getClavePers());
            personaDto.setEstadoPers(personaEntity.getEstadoPers());
            personaDto.setNombre_rol(nombreRol);
            personaDtoList.add(personaDto);
        }
        return personaDtoList;
    }
    public LoginResponseDto login(String user, String password){
        LoginResponseDto response= new LoginResponseDto();
        response.setCodigo(400);
        try{
            PersonaEntity usuariouser=repository.findByCorreoPers(user);
            if(usuariouser==null){
                response.setMensaje("UsuarioNulo");
                response.setToken("");
                return response;
            }

            if(!usuariouser.getClavePers().equals(password)){
                response.setMensaje("ClaveErronea");
                return response;
            }
            String datos="id="+usuariouser.getId()+"!=!";
            datos+="usuario="+usuariouser.getCorreoPers()+"!=!";
            datos+="password="+usuariouser.getClavePers()+"!=!";
            datos+="rol="+usuariouser.getRol().getNombre_rol()+"!=!";
            datos+="persona="+capitalizar(usuariouser.getNombrePers())+" "+capitalizar(usuariouser.getApellido_patPers())+"!=!";
            datos+="fechayhora="+ LocalDateTime.now();
            Base64 base64 = new Base64();
            String token= new String(base64.encode(datos.getBytes()));
            response.setCodigo(200);
            response.setMensaje("Inicio de Sesión Satisfactorio");
            response.setToken(token);
            return response;
        }catch(Exception ex){
            log.error("error al loguearse log",ex.getMessage());
            response.setMensaje("error al loguearse  -> "+ ex.getCause());
            response.setToken("");
            return response;
        }
    }
    public PersonaDto savePersona(PersonaDto registro){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, PersonaEntity.class)),
                    PersonaDto.class);
        }catch (Exception ex){
            return null;
        }
    }
    public Boolean deletePersona (UUID id){
        try{
            Optional<PersonaEntity> registro=repository.findById(id);
            if(registro.isPresent()){
                repository.delete(registro.get());
                return true;
            }
            return false;
        }catch (Exception ex){
            return null;
        }

    }
}
