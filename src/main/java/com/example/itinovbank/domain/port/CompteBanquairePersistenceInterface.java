package com.example.itinovbank.domain.port;

import com.example.itinovbank.domain.model.CompteBancaire;

import java.util.List;
import java.util.UUID;

public interface CompteBanquairePersistenceInterface {
    CompteBancaire recupererCompteBancaire(UUID idCompteBancaire);

    CompteBancaire sauvegarderCompteBancaire(CompteBancaire compteBancaire);

    List<CompteBancaire> recupererListCompteBancaireClient(UUID idClient);
}
