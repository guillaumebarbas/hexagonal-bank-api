package com.example.itinovbank.domain.service;

import com.example.itinovbank.domain.model.Client;
import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.port.ClientServiceInterface;
import com.example.itinovbank.domain.port.CompteBanquairePersistenceInterface;
import com.example.itinovbank.domain.use_case.AjouterSoldeUseCase;
import com.example.itinovbank.domain.use_case.ListerCompteClientUseCase;
import com.example.itinovbank.domain.use_case.RetirerSoldeUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    CompteBanquairePersistenceInterface compteBanquairePersistence;
    @InjectMocks
    ListerCompteClientUseCase listerCompteClientUseCase = new ListerCompteClientUseCase(compteBanquairePersistence);
    ClientServiceInterface clientService = new ClientService(listerCompteClientUseCase);

    @DisplayName("Recuperer la liste des comptes devrait renvoyer la liste des comptes de l'utilisateur mit en parametre")
    @Test
    void recupererListeCompte(){

        // Given

        UUID idCompte1 = UUID.randomUUID();
        UUID idCompte2 = UUID.randomUUID();

        UUID idClient = UUID.randomUUID();
        Client client = new Client(idClient);
        CompteBancaire compteBancaire1 = new CompteBancaire(idCompte1,"EUR",new BigDecimal(10),client);
        CompteBancaire compteBancaire2 = new CompteBancaire(idCompte2,"EUR",new BigDecimal(150),client);

        // Mocks
        when(compteBanquairePersistence.recupererListCompteBancaireClient(idClient)).thenReturn(List.of(compteBancaire1,compteBancaire2));
        // when
        List<CompteBancaire> resultat = clientService.recupererListeCompteClient(idClient);

        // Then
        assertThat(resultat)
                .isNotNull()
                .hasSize(2)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(compteBancaire1, compteBancaire2);
    }
}