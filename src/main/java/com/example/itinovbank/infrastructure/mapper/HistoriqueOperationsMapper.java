package com.example.itinovbank.infrastructure.mapper;

import com.example.itinovbank.domain.model.HistoriqueOperation;
import com.example.itinovbank.infrastructure.entity.HistoriqueOperationsDatabase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
public class HistoriqueOperationsMapper {

    private final CompteBancaireMapper compteBancaireMapper;

    public HistoriqueOperation versHistoriqueOperation(HistoriqueOperationsDatabase historiqueOperationsDatabase) {
        return new HistoriqueOperation(compteBancaireMapper.versCompteBancaire(historiqueOperationsDatabase.getCompteBancaireCibleDatabase()), historiqueOperationsDatabase.getTypeOperation(), historiqueOperationsDatabase.getMontant(), historiqueOperationsDatabase.getDateCreation());
    }

    public HistoriqueOperationsDatabase versHistoriqueOperationDatabase(HistoriqueOperation historiqueOperation) {
        return new HistoriqueOperationsDatabase(UUID.randomUUID(), compteBancaireMapper.versCompteBancaireDatabase(historiqueOperation.getCompteBancaireCible()), historiqueOperation.getTypeOperation(), historiqueOperation.getMontant(), historiqueOperation.getDate());
    }

    public List<HistoriqueOperation> versListeHistoriqueOperations(List<HistoriqueOperationsDatabase> historiqueOperations) {
        return historiqueOperations.stream()
                .map(this::versHistoriqueOperation)
                .toList();
    }
}
