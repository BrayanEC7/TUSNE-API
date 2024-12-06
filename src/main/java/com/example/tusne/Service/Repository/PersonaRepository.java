package com.example.tusne.Service.Repository;
import com.example.tusne.Model.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, UUID> {
    @Query("SELECT ps, rl.nombre_rol " +
            "FROM PersonaEntity ps " +
            "INNER JOIN ps.rol rl WHERE ps.correoPers=?1 AND ps.clavePers=?2")
    PersonaEntity login(String pers_correo, String pers_clave);
    PersonaEntity findByCorreoPers(String pers_correo);
    PersonaEntity findByCorreoPersAndClavePers(String pers_correo, String pers_clave);

    @Query("SELECT ps, rl.nombre_rol " +
            "FROM PersonaEntity ps " +
            "INNER JOIN ps.rol rl ")
    List<Object[]> findAllPersona();
}
