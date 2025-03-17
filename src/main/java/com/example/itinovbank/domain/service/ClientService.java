package com.example.itinovbank.domain.service;

import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.port.ClientServiceInterface;
import com.example.itinovbank.domain.use_case.ListerCompteClientUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClientService implements ClientServiceInterface {
    ListerCompteClientUseCase listerCompteClientUseCase;

    public ClientService(ListerCompteClientUseCase listerCompteClientUseCase) {
        this.listerCompteClientUseCase = listerCompteClientUseCase;
    }

    @Override
    public List<CompteBancaire> recupererListeCompteClient(UUID idClient) {
        return listerCompteClientUseCase.executer(idClient);
    }
}
