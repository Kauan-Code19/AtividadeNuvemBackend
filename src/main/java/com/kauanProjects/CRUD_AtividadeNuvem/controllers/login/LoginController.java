package com.kauanProjects.CRUD_AtividadeNuvem.controllers.login;

import com.kauanProjects.CRUD_AtividadeNuvem.dtos.administrator.AdministratorDto;
import com.kauanProjects.CRUD_AtividadeNuvem.dtos.administrator.AdministratorResponseDto;
import com.kauanProjects.CRUD_AtividadeNuvem.services.login.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<AdministratorResponseDto> login(@Valid @RequestBody AdministratorDto administratorDto) {
        AdministratorResponseDto administratorResponseDto = loginService.login(administratorDto);

        return ResponseEntity.ok(administratorResponseDto);
    }
}
