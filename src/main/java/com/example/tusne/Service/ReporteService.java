package com.example.tusne.Service;

import com.example.tusne.Controller.Dto.ReporteDto;
import com.example.tusne.Model.ReporteEntity;
import com.example.tusne.Service.Repository.ReporteRepository;
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
public class ReporteService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ReporteRepository repository;

    public List<ReporteDto> getAll(){
        try {
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x,ReporteDto.class))
                    .collect(Collectors.toList());
        }catch (Exception ex){
            return null;
        }
    }

    public ReporteDto saveReporte(ReporteDto registro){
       try {
           return this.modelMapper.map(
                   repository.save(this.modelMapper.map(registro, ReporteEntity.class)), ReporteDto.class);
       }catch (Exception ex){
           return null;
       }
    }
    public Boolean deleteReporte(UUID id){
        try {
            Optional<ReporteEntity> registro=
                    repository.findById(id);
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
