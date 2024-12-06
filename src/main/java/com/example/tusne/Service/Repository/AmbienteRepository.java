package com.example.tusne.Service.Repository;

import com.example.tusne.Model.AmbienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AmbienteRepository extends JpaRepository<AmbienteEntity, UUID> {

}
