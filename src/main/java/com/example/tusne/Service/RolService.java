package com.example.tusne.Service;

import com.example.tusne.Controller.Dto.RolDto;
import com.example.tusne.Model.RolEntity;
import com.example.tusne.Service.Repository.RolRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RolService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    RolRepository repository;

    public List<RolDto> getAll(){
        try {
            return repository.findAll().stream().map(x->modelMapper.map(x,RolDto.class)).collect(Collectors.toList());
        }catch (Exception ex){
            return null;
        }
    }
    public RolDto saveRol(RolDto registro){
        try {
            return this.modelMapper.map(repository.save(this.modelMapper.map(registro, RolEntity.class)),RolDto.class);
        }catch (Exception ex){
            return null;
        }
    }
    public Boolean deleteRol(UUID id){
        try{
            Optional<RolEntity> registro=repository.findById(id);
            if(registro.isPresent()){
                repository.delete(registro.get());
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }
}
