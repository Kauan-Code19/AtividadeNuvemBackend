package com.kauanProjects.CRUD_AtividadeNuvem.dtos.products;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDto {
    @NotBlank(message = "O nome do produto é obrigatório.")
    @Size(min = 1, max = 100, message = "O nome do produto deve ter entre 1 e 100 caracteres.")
    private String name;

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    private double price;

    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String description;
}
