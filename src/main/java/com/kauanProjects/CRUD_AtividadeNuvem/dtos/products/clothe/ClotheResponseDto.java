package com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.ProductResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.entities.products.clothe.ClotheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClotheResponseDto extends ProductResponseDto {

    private String size;

    private String color;

    private String material;

    public ClotheResponseDto(ClotheEntity clotheEntity) {
        super.setId(clotheEntity.getId());
        super.setName(clotheEntity.getName());
        super.setPrice(clotheEntity.getPrice());
        super.setDescription(clotheEntity.getDescription());

        size = clotheEntity.getSize();
        color = clotheEntity.getColor();
        material = clotheEntity.getMaterial();
    }
}
