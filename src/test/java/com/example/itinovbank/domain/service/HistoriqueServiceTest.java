package com.example.itinovbank.domain.service;

import com.example.itinovbank.domain.model.Client;
import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.model.HistoriqueOperation;
import com.example.itinovbank.domain.port.HistoriqueOperationsInterface;
import com.example.itinovbank.domain.port.HistoriqueOperationsPersistenceInterface;
import com.example.itinovbank.domain.use_case.RecupererHistoriqueOperationsUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HistoriqueServiceTest {

    @Mock
    HistoriqueOperationsPersistenceInterface historiqueOperationsPersistenceInterface;
    @InjectMocks
    RecupererHistoriqueOperationsUseCase recupererHistoriqueOperationsUseCase = new RecupererHistoriqueOperationsUseCase();
    HistoriqueOperationsInterface historiqueOperationsInterface = new HistoriqueOperationsService(recupererHistoriqueOperationsUseCase);

    //TODO ajouter clock , validator sur historique operation, ENUM ou type pour les type de transaction
    @DisplayName("Recuperer la liste des operations d'un client")
    @Test
    void recupererHistoriqueOperation() {

        // Given
        UUID idClient = UUID.randomUUID();
        UUID idCompteBancaire = UUID.randomUUID();
        Client client = new Client(idClient);
        CompteBancaire compteBancaire = new CompteBancaire(idCompteBancaire, "EUR", new BigDecimal(50), client);
        HistoriqueOperation historiqueOperation1 = new HistoriqueOperation(compteBancaire, "DEBIT", new BigDecimal(20), LocalDate.now());
        HistoriqueOperation historiqueOperation2 = new HistoriqueOperation(compteBancaire, "CREDIT", new BigDecimal(20), LocalDate.now());
        List<HistoriqueOperation> historiqueOperationsAttendu = List.of(historiqueOperation1, historiqueOperation2);

        // Mock
        when(historiqueOperationsPersistenceInterface.recupererListeHistoriqueOperationsClient(idClient)).thenReturn(historiqueOperationsAttendu);
        // When
        List<HistoriqueOperation> historiqueOperations = historiqueOperationsInterface.recupererListeHistoriqueOperationsClient(idClient);

        //assertThat
        assertThat(historiqueOperations).hasSize(2);

    }
}
