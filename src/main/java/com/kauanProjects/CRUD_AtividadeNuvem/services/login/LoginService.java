package com.kauanProjects.CRUD_AtividadeNuvem.services.login;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.administrator.AdministratorDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.administrator.AdministratorResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.entities.administrator.AdministratorEntity;
import com.kauanProjects.CRUD_AtividadeNuvem.repositories.administrator.AdministratorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public LoginService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Transactional(readOnly = true)
    public AdministratorResponseDto login(AdministratorDto administratorDto) {
        AdministratorEntity administrator = administratorRepository.findByEmail(administratorDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Administrator não encontrado"));

        if (!administrator.getPassword().equals(administratorDto.getPassword())) {
            throw new IllegalArgumentException("Senha Incorreta");
        }

        return new AdministratorResponseDto(administrator);
    }
}
