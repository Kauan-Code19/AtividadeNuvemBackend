package com.kauanProjects.CRUD_AtividadeNuvem.controllers.products;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe.ClotheDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe.ClotheResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.services.products.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/clothe")
    public ResponseEntity<ClotheResponseDto> createClothe(@Valid @RequestBody ClotheDto clotheDto) {
        ClotheResponseDto clotheResponseDto = productService.createClothe(clotheDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clotheResponseDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(clotheResponseDto);
    }
}
