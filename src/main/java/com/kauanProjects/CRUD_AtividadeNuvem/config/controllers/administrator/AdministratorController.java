package com.kauanProjects.CRUD_AtividadeNuvem.config.controllers.administrator;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.admnistrator.AdministratorDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.admnistrator.AdministratorResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.services.administrator.AdministratorService;
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
@RequestMapping("/administrator")
public class AdministratorController {

    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping
    public ResponseEntity<AdministratorResponseDto> createAdministrator
            (@Valid @RequestBody AdministratorDto administratorDto) {

        AdministratorResponseDto administratorResponseDto = administratorService.createAdministrator(administratorDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(administratorResponseDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(administratorResponseDto);
    }
}
