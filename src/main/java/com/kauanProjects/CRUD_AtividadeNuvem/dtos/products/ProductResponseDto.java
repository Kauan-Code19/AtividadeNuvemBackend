package com.kauanProjects.CRUD_AtividadeNuvem.dtos.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;

    private String name;

    private double price;

    private String description;
}
