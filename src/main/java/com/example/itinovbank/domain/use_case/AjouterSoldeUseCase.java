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
public class AjouterSoldeUseCase {

    CompteBanquairePersistenceInterface compteBanquairePersistence;
    HistoriqueOperationsPersistenceInterface historiqueOperationsPersistenceInterface;

    public AjouterSoldeUseCase(CompteBanquairePersistenceInterface compteBanquairePersistence, HistoriqueOperationsPersistenceInterface historiqueOperationsPersistenceInterface) {
        this.compteBanquairePersistence = compteBanquairePersistence;
        this.historiqueOperationsPersistenceInterface = historiqueOperationsPersistenceInterface;
    }

    public void executer(UUID idCompteBancaire, BigDecimal montant) {
        CompteBancaire compteBancaire = compteBanquairePersistence.recupererCompteBancaire(idCompteBancaire);
        compteBancaire.ajouterSolde(montant);
        compteBanquairePersistence.sauvegarderCompteBancaire(compteBancaire);
        historiqueOperationsPersistenceInterface.enregistrerHistoriqueOperationClient(new HistoriqueOperation(compteBancaire, "CREDIT", montant, LocalDate.now()));
    }
}
