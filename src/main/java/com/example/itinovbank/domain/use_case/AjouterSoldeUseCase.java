package com.example.itinovbank.domain.use_case;

import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.port.CompteBanquairePersistenceInterface;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class AjouterSoldeUseCase {

    CompteBanquairePersistenceInterface compteBanquairePersistence;

    public AjouterSoldeUseCase(CompteBanquairePersistenceInterface compteBanquairePersistence) {
        this.compteBanquairePersistence = compteBanquairePersistence;
    }

    public void executer(UUID idCompteBancaire, BigDecimal montant) {
        CompteBancaire compteBancaire = compteBanquairePersistence.recupererCompteBancaire(idCompteBancaire);
        compteBancaire.ajouterSolde(montant);
        compteBanquairePersistence.sauvegarderCompteBancaire(compteBancaire);
    }
}
