package com.example.itinovbank.domain.compte_bancaire.service;

import com.example.itinovbank.domain.compte_bancaire.port.CompteBancaireServiceInterface;
import com.example.itinovbank.domain.compte_bancaire.use_case.AjouterSoldeUseCase;
import com.example.itinovbank.domain.compte_bancaire.use_case.RetirerSoldeUseCase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CompteBancaireService implements CompteBancaireServiceInterface {

    private final AjouterSoldeUseCase ajouterSoldeUseCase;
    private final RetirerSoldeUseCase retirerSoldeUseCase;

    public CompteBancaireService(AjouterSoldeUseCase ajouterSoldeUseCase, RetirerSoldeUseCase retirerSoldeUseCase) {
        this.ajouterSoldeUseCase = ajouterSoldeUseCase;
        this.retirerSoldeUseCase = retirerSoldeUseCase;
    }

    @Override
    public void credit(UUID idCompteBancaire, BigDecimal montant) {
        ajouterSoldeUseCase.executer(idCompteBancaire,montant);
    }

    @Override
    public void debit(UUID idCompteBancaire, BigDecimal montant) {
        retirerSoldeUseCase.executer(idCompteBancaire,montant);
    }
}
