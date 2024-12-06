package com.example.tusne.Service.Repository;

import com.example.tusne.Model.ReporteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ReporteRepository extends JpaRepository<ReporteEntity, UUID> {


}
