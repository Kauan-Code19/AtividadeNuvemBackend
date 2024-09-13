package com.kauanProjects.CRUD_AtividadeNuvem.repositories.administrator;

import com.kauanProjects.CRUD_AtividadeNuvem.entities.administrator.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<AdministratorEntity, Long> {
    Optional<AdministratorEntity> findByEmail(String email);
}
