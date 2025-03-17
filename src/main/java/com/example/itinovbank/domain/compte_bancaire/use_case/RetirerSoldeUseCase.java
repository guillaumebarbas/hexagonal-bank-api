package com.example.itinovbank.domain.compte_bancaire.use_case;

import com.example.itinovbank.domain.compte_bancaire.CompteBancaire;
import com.example.itinovbank.domain.compte_bancaire.port.CompteBanquairePersistenceInterface;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class RetirerSoldeUseCase {

    CompteBanquairePersistenceInterface compteBancairePersistence;
    public void executer(UUID idCompteBancaire, BigDecimal montant) {
        CompteBancaire compteBancaire = compteBancairePersistence.recupererCompteBancaire(idCompteBancaire);
        compteBancaire.retirerSolde(montant);
        compteBancairePersistence.sauvegarderCompteBancaire(compteBancaire);
    }

    public RetirerSoldeUseCase(CompteBanquairePersistenceInterface compteBancairePersistence){
        this.compteBancairePersistence = compteBancairePersistence;
    }
}
