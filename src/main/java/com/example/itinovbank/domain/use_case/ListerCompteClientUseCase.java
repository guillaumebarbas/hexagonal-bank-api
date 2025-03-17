package com.example.itinovbank.domain.use_case;


import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.port.CompteBanquairePersistenceInterface;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ListerCompteClientUseCase {
    CompteBanquairePersistenceInterface compteBanquairePersistence;

    public ListerCompteClientUseCase(CompteBanquairePersistenceInterface compteBanquairePersistence) {
        this.compteBanquairePersistence = compteBanquairePersistence;
    }

    //TODO : Si list <= 0 , throw exception un client ne peut pas avoir 0 compte
    public List<CompteBancaire> executer(UUID idClient) {
        return compteBanquairePersistence.recupererListCompteBancaireClient(idClient);
    }

}
