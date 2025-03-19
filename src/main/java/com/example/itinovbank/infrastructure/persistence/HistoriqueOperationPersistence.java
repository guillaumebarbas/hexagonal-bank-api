package com.example.itinovbank.infrastructure.persistence;

import com.example.itinovbank.domain.model.HistoriqueOperation;
import com.example.itinovbank.domain.port.HistoriqueOperationsPersistenceInterface;
import com.example.itinovbank.infrastructure.mapper.HistoriqueOperationsMapper;
import com.example.itinovbank.infrastructure.repository.HistoriqueOperationJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
public class HistoriqueOperationPersistence implements HistoriqueOperationsPersistenceInterface {

    private final HistoriqueOperationsMapper historiqueOperationsMapper;
    private final HistoriqueOperationJPA historiqueOperationJPA;

    @Override
    public void enregistrerHistoriqueOperationClient(HistoriqueOperation historiqueOperation) {
        historiqueOperationJPA.save(historiqueOperationsMapper.versHistoriqueOperationDatabase(historiqueOperation));

    }

    @Override
    public List<HistoriqueOperation> recupererListeHistoriqueOperationsClient(UUID idClient) {
        return historiqueOperationsMapper.versListeHistoriqueOperations(historiqueOperationJPA.findByCompteBancaireCibleDatabase_ClientDatabase_Id(idClient));
    }
}
