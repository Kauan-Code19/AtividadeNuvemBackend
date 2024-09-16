package com.kauanProjects.CRUD_AtividadeNuvem.repositories.product;

import com.kauanProjects.CRUD_AtividadeNuvem.entities.products.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
