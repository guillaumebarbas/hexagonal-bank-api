package com.example.itinovbank.infrastructure.persistence;

// Controller -> Domain -> Service -> interface UseCase in -> UseCase implement in -> UseCase appele Service interface out -> Persistence implement out -> appel jpa
// Controller -> Domain -> Service interface-> ServiceImpl appele useCase et out -> Persistence implement out -> appel jpa

import com.example.itinovbank.domain.compte_bancaire.CompteBancaire;
import com.example.itinovbank.domain.compte_bancaire.port.CompteBanquairePersistenceInterface;
import com.example.itinovbank.infrastructure.mapper.CompteBancaireMapper;
import com.example.itinovbank.infrastructure.repository.CompteBancaireJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Component
public class CompteBancairePersistence implements CompteBanquairePersistenceInterface {

    private final CompteBancaireJPA compteBancaireJPA;
    private final CompteBancaireMapper compteBancaireMapper;
    @Override
    public CompteBancaire recupererCompteBancaire(UUID idCompteBancaire) {
        return compteBancaireMapper.versCompteBancaire(Objects.requireNonNull(compteBancaireJPA.findById(idCompteBancaire).orElse(null)));
    }

    @Override
    public CompteBancaire sauvegarderCompteBancaire(CompteBancaire compteBancaire) {
        return compteBancaireMapper.versCompteBancaire(compteBancaireJPA.save(compteBancaireMapper.versCompteBancaireDatabase(compteBancaire)));
    }
}
