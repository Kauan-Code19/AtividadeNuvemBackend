package com.kauanProjects.CRUD_AtividadeNuvem.entities.products.clothe;

import com.kauanProjects.CRUD_AtividadeNuvem.entities.products.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("Clothe")
public class ClotheEntity extends ProductEntity {
    @Column(name = "product_size")
    private String size;
    @Column(name = "color")
    private String color;
    @Column(name = "material")
    private String material;
}
