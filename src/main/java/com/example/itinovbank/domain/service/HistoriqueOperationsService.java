package com.example.itinovbank.domain.service;

import com.example.itinovbank.domain.model.HistoriqueOperation;
import com.example.itinovbank.domain.port.HistoriqueOperationsInterface;
import com.example.itinovbank.domain.use_case.RecupererHistoriqueOperationsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class HistoriqueOperationsService implements HistoriqueOperationsInterface {

    private final RecupererHistoriqueOperationsUseCase recupererHistoriqueOperationsUseCase;

    public HistoriqueOperationsService(RecupererHistoriqueOperationsUseCase recupererHistoriqueOperationsUseCase) {
        this.recupererHistoriqueOperationsUseCase = recupererHistoriqueOperationsUseCase;
    }

    @Override
    public List<HistoriqueOperation> recupererListeHistoriqueOperationsClient(UUID idClient) {
        return recupererHistoriqueOperationsUseCase.executer(idClient);
    }
}
