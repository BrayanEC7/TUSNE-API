package com.example.tusne.Service.Repository;
import com.example.tusne.Model.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, UUID> {

    @Query("SELECT rs, amb.denominacion_ambi, per.dniPers " +
            "FROM ReservaEntity rs " +
            "INNER JOIN rs.ambiente amb " +
            "JOIN rs.persona per ")
    List<Object[]> findAllReserva();

}
