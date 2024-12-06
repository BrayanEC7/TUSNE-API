package com.example.tusne.Service;

import com.example.tusne.Controller.Dto.AmbienteDto;
import com.example.tusne.Model.AmbienteEntity;
import com.example.tusne.Service.Repository.AmbienteRepository;
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
public class AmbienteService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    AmbienteRepository repository;

    public List<AmbienteDto> getAll(){
          try{
           return repository.findAll()
           .stream()
           .map(x->modelMapper.map(x, AmbienteDto.class))
           .collect(Collectors.toList());
                }catch (Exception ex){
        return null;
                }
            }

    public AmbienteDto saveAmbiente(AmbienteDto registro){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, AmbienteEntity.class)),
                    AmbienteDto.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public Boolean deleteAmbiente (UUID id){
        try{
            Optional<AmbienteEntity> registro=repository.findById(id);
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
