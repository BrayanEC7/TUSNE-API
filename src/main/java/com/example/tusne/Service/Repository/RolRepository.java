package com.example.tusne.Service.Repository;

import com.example.tusne.Model.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RolRepository extends JpaRepository<RolEntity, UUID> {
}
