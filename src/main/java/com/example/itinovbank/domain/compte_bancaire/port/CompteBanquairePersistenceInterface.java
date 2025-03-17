package com.example.itinovbank.domain.compte_bancaire.port;

import com.example.itinovbank.domain.compte_bancaire.CompteBancaire;

import java.util.UUID;

public interface CompteBanquairePersistenceInterface {
    CompteBancaire recupererCompteBancaire(UUID idCompteBancaire);
    CompteBancaire sauvegarderCompteBancaire(CompteBancaire compteBancaire);
}
