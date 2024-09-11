package com.kauanProjects.CRUD_AtividadeNuvem.repositories.administrator;

import com.kauanProjects.CRUD_AtividadeNuvem.entities.admnistrator.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<AdministratorEntity, Long> {
}
