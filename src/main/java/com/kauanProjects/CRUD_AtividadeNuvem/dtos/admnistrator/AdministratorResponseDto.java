package com.kauanProjects.CRUD_AtividadeNuvem.dtos.admnistrator;

import com.kauanProjects.CRUD_AtividadeNuvem.entities.admnistrator.AdministratorEntity;
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

