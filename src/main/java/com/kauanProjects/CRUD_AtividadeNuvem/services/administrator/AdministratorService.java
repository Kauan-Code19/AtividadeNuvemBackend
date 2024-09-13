package com.kauanProjects.CRUD_AtividadeNuvem.services.administrator;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.administrator.AdministratorDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.administrator.AdministratorResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.entities.administrator.AdministratorEntity;
import com.kauanProjects.CRUD_AtividadeNuvem.repositories.administrator.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Transactional
    public AdministratorResponseDto createAdministrator(AdministratorDto administratorDto) {
        AdministratorEntity administrator = new AdministratorEntity();

        administrator.setEmail(administratorDto.getEmail());
        administrator.setPassword(administratorDto.getPassword());

        administratorRepository.save(administrator);

        return new AdministratorResponseDto(administrator);
    }
}
