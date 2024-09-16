package com.kauanProjects.CRUD_AtividadeNuvem.repositories.product.clothe;

import com.kauanProjects.CRUD_AtividadeNuvem.entities.products.clothe.ClotheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClotheRepository extends JpaRepository<ClotheEntity, Long> {
}
