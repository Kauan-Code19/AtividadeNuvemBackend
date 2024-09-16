package com.kauanProjects.CRUD_AtividadeNuvem.services.products.clothe;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe.ClotheDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe.ClotheResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.entities.products.clothe.ClotheEntity;
import com.kauanProjects.CRUD_AtividadeNuvem.repositories.product.clothe.ClotheRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClotheService {

    private final ClotheRepository clotheRepository;

    @Autowired
    public ClotheService(ClotheRepository clotheRepository) {
        this.clotheRepository = clotheRepository;
    }

    public List<ClotheResponseDto> getAllClothes() {
        List<ClotheResponseDto> clotheResponseDtos = clotheRepository.findAll()
                .stream().map(ClotheResponseDto::new).toList();

        if (clotheResponseDtos.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma Roupa Encontrada");
        }

        return clotheResponseDtos;
    }

    public ClotheResponseDto updateClothe(Long clotheId, ClotheDto clotheDto) {
        ClotheEntity clothe = clotheRepository.getReferenceById(clotheId);

        clothe.setName(clotheDto.getName());
        clothe.setDescription(clotheDto.getDescription());
        clothe.setSize(clotheDto.getSize());
        clothe.setColor(clotheDto.getColor());
        clothe.setMaterial(clotheDto.getMaterial());
        clothe.setPrice(clotheDto.getPrice());

        clotheRepository.save(clothe);

        return new ClotheResponseDto(clothe);
    }
}
