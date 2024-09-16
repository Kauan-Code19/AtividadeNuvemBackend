package com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.clothe;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.products.ProductDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClotheDto  extends ProductDto {

    @NotBlank(message = "O tamanho do produto é obrigatório.")
    private String size;

    @NotBlank(message = "A cor do produto é obrigatória.")
    private String color;

    @NotBlank(message = "O material do produto é obrigatório.")
    private String material;
}
