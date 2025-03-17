package com.example.itinovbank.infrastructure.mapper;

import com.example.itinovbank.domain.compte_bancaire.CompteBancaire;
import com.example.itinovbank.infrastructure.entity.CompteBancaireDatabase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CompteBancaireMapper {
    private ClientMapper clientMapper;
    public CompteBancaire versCompteBancaire(CompteBancaireDatabase compteBancaireDatabase){
        return new CompteBancaire(compteBancaireDatabase.getId(),compteBancaireDatabase.getDevise(),compteBancaireDatabase.getMontant(),clientMapper.versClient(compteBancaireDatabase.getClientDatabase()));
    }

    public CompteBancaireDatabase versCompteBancaireDatabase(CompteBancaire compteBancaire){
        return new CompteBancaireDatabase(compteBancaire.getId(), compteBancaire.getDevise(), compteBancaire.getSolde(),clientMapper.versClientDatabase(compteBancaire.getClient()));
    }
}
