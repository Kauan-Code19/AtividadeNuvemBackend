package com.kauanProjects.CRUD_AtividadeNuvem.services.products;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe.ClotheDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe.ClotheResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.entities.products.clothe.ClotheEntity;
import com.kauanProjects.CRUD_AtividadeNuvem.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ClotheResponseDto createClothe(ClotheDto clotheDto) {
        ClotheEntity clothe = new ClotheEntity();

        clothe.setName(clotheDto.getName());
        clothe.setPrice(clotheDto.getPrice());
        clothe.setDescription(clotheDto.getDescription());
        clothe.setSize(clotheDto.getSize());
        clothe.setColor(clotheDto.getColor());
        clothe.setMaterial(clotheDto.getMaterial());

        productRepository.save(clothe);

        return new ClotheResponseDto(clothe);
    }
}
