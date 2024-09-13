package com.kauanProjects.CRUD_AtividadeNuvem.services.administrator;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.admnistrator.AdministratorDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.admnistrator.AdministratorResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.entities.admnistrator.AdministratorEntity;
import com.kauanProjects.CRUD_AtividadeNuvem.repositories.administrator.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public AdministratorResponseDto createAdministrator(AdministratorDto administratorDto) {
        AdministratorEntity administrator = new AdministratorEntity();

        administrator.setEmail(administratorDto.getEmail());
        administrator.setPassword(administratorDto.getPassword());

        administratorRepository.save(administrator);

        return new AdministratorResponseDto(administrator);
    }
}
