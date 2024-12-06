package com.example.tusne.Service;

import com.example.tusne.Controller.Dto.ReservaDto;
import com.example.tusne.Model.ReservaEntity;
import com.example.tusne.Service.Repository.ReservaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReservaService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ReservaRepository repository;

    public List<ReservaDto> getAll(){
        try {
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, ReservaDto.class))
                    .collect(Collectors.toList());
        }catch (Exception ex){
            return null;
        }
    }

    public List<ReservaDto> getReservaConPersonaAmbiente(){
        List<Object[]> resultados = repository.findAllReserva();
        List<ReservaDto> reservaDtoList= new ArrayList<>();
        for (Object[] resultado : resultados){
            ReservaEntity reservaEntity = (ReservaEntity) resultado[0];
            String nombreAmbiente = (String) resultado[1];
            String dniPersona = (String) resultado[2];
            ReservaDto reservaDto= new ReservaDto();
            reservaDto.setId(reservaEntity.getId());
            reservaDto.setPersonaId(reservaEntity.getPersona().getId());
            reservaDto.setAmbienteId(reservaEntity.getAmbiente().getId());
            reservaDto.setFechaReserva(reservaEntity.getFechaReserva());
            reservaDto.setFechaActualizacion(reservaEntity.getFechaActualizacion());
            reservaDto.setFechaSolicitud(reservaEntity.getFechaSolicitud());
            reservaDto.setTotalRese(reservaEntity.getTotalRese());
            reservaDto.setPago_estadoRese(reservaEntity.getPago_estadoRese());
            reservaDto.setHoraFin(reservaEntity.getHoraFin());
            reservaDto.setHoraInicio(reservaEntity.getHoraInicio());
            reservaDto.setDenominacion_ambi(nombreAmbiente);
            reservaDto.setDniPers(dniPersona);
            reservaDtoList.add(reservaDto);

        }
        return reservaDtoList;
    }
    public ReservaDto saveReserva(ReservaDto registro){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, ReservaEntity.class)), ReservaDto.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean deleteReserva(UUID id){
        try {
            Optional<ReservaEntity> registro=
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
