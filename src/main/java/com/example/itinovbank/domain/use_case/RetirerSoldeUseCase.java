package com.example.itinovbank.domain.use_case;

import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.model.HistoriqueOperation;
import com.example.itinovbank.domain.port.CompteBanquairePersistenceInterface;
import com.example.itinovbank.domain.port.HistoriqueOperationsPersistenceInterface;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class RetirerSoldeUseCase {

    CompteBanquairePersistenceInterface compteBancairePersistence;
    HistoriqueOperationsPersistenceInterface historiqueOperationsPersistenceInterface;

    public RetirerSoldeUseCase(CompteBanquairePersistenceInterface compteBancairePersistence, HistoriqueOperationsPersistenceInterface historiqueOperationsPersistenceInterface) {
        this.compteBancairePersistence = compteBancairePersistence;
        this.historiqueOperationsPersistenceInterface = historiqueOperationsPersistenceInterface;
    }

    public void executer(UUID idCompteBancaire, BigDecimal montant) {
        CompteBancaire compteBancaire = compteBancairePersistence.recupererCompteBancaire(idCompteBancaire);
        compteBancaire.retirerSolde(montant);
        compteBancairePersistence.sauvegarderCompteBancaire(compteBancaire);
        historiqueOperationsPersistenceInterface.enregistrerHistoriqueOperationClient(new HistoriqueOperation(compteBancaire, "DEBIT", montant, LocalDate.now()));

    }
}
