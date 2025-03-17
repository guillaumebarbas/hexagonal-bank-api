package com.example.itinovbank.application.rest;


import com.example.itinovbank.application.rest.input.Request;
import com.example.itinovbank.domain.compte_bancaire.port.CompteBancaireServiceInterface;
import com.example.itinovbank.domain.compte_bancaire.service.CompteBancaireService;
import com.example.itinovbank.domain.compte_bancaire.use_case.AjouterSoldeUseCase;
import com.example.itinovbank.domain.compte_bancaire.use_case.RetirerSoldeUseCase;
import com.example.itinovbank.infrastructure.mapper.ClientMapper;
import com.example.itinovbank.infrastructure.mapper.CompteBancaireMapper;
import com.example.itinovbank.infrastructure.persistence.CompteBancairePersistence;
import com.example.itinovbank.infrastructure.repository.CompteBancaireJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/compte-bancaire")
public class CompteBancaireController {
    private final CompteBancaireServiceInterface compteBancaireService;

    public CompteBancaireController(CompteBancaireServiceInterface compteBancaireService) {
        this.compteBancaireService = compteBancaireService;
    }

    @PatchMapping("/credit")
    public ResponseEntity<HttpStatus> credit(@RequestBody Request compteBancaireRequest) {
        BigDecimal decimal = compteBancaireRequest.getMontant();
        compteBancaireService.credit(compteBancaireRequest.getId(), decimal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
