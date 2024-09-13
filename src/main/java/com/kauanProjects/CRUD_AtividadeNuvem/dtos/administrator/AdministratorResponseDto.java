package com.kauanProjects.CRUD_AtividadeNuvem.dtos.administrator;

import com.kauanProjects.CRUD_AtividadeNuvem.entities.administrator.AdministratorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AdministratorResponseDto {

    private Long id;

    private String email;

    public AdministratorResponseDto(AdministratorEntity administrator) {
        id = administrator.getId();
        email = administrator.getEmail();
    }
}

