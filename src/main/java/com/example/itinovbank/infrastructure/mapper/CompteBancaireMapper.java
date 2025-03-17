package com.example.itinovbank.infrastructure.mapper;

import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.infrastructure.entity.CompteBancaireDatabase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<CompteBancaire> versListeCompteBancaire(List<CompteBancaireDatabase> comptesBancairesDatabase) {
        return comptesBancairesDatabase.stream()
                .map(this::versCompteBancaire)
                .toList();
    }
}
