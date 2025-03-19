package com.example.itinovbank.domain.use_case;

import com.example.itinovbank.domain.model.HistoriqueOperation;
import com.example.itinovbank.domain.port.HistoriqueOperationsPersistenceInterface;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RecupererHistoriqueOperationsUseCase {

    HistoriqueOperationsPersistenceInterface historiqueOperationsPersistenceInterface;

    public RecupererHistoriqueOperationsUseCase(HistoriqueOperationsPersistenceInterface historiqueOperationsPersistenceInterface) {
        this.historiqueOperationsPersistenceInterface = historiqueOperationsPersistenceInterface;
    }

    public List<HistoriqueOperation> executer(UUID idClient) {
        return historiqueOperationsPersistenceInterface.recupererListeHistoriqueOperationsClient(idClient);
    }
}
