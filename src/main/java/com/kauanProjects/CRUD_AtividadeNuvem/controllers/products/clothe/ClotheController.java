package com.kauanProjects.CRUD_AtividadeNuvem.controllers.products.clothe;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe.ClotheResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.services.products.clothe.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/clothe")
public class ClotheController {

    private final ClotheService clotheService;

    @Autowired
    public ClotheController(ClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ClotheResponseDto>> getAllClothes() {
        List<ClotheResponseDto> clotheResponseDtos = clotheService.getAllClothes();

        return ResponseEntity.ok(clotheResponseDtos);
    }
}
