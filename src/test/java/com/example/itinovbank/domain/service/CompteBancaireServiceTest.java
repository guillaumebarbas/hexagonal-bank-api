package com.example.itinovbank.domain.service;

import com.example.itinovbank.domain.model.Client;
import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.port.CompteBanquairePersistenceInterface;
import com.example.itinovbank.domain.use_case.AjouterSoldeUseCase;
import com.example.itinovbank.domain.use_case.RetirerSoldeUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompteBancaireServiceTest {

    @Mock
    CompteBanquairePersistenceInterface compteBanquairePersistence;
    @InjectMocks
    AjouterSoldeUseCase ajouterSoldeUseCase = new AjouterSoldeUseCase(compteBanquairePersistence);
    @InjectMocks
    RetirerSoldeUseCase retirerSoldeUseCase = new RetirerSoldeUseCase(compteBanquairePersistence);
    CompteBancaireService compteBancaireService = new CompteBancaireService(ajouterSoldeUseCase,retirerSoldeUseCase);

    @DisplayName("Le compte devrait avoir le montant en plus sur son compte après ajout")
    @Test
    void ajouterSoldeCompteBancaire() {
        UUID idCompteBancaireTest = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());
        CompteBancaire compteBancaireRecuperer = new CompteBancaire(idCompteBancaireTest, "EUR", new BigDecimal(5), client);

        when(compteBanquairePersistence.recupererCompteBancaire(idCompteBancaireTest)).thenReturn(compteBancaireRecuperer);

        compteBancaireService.credit(idCompteBancaireTest, new BigDecimal(15));

        verify(compteBanquairePersistence).sauvegarderCompteBancaire(argThat(compteBancaire ->
                compteBancaire.getSolde().compareTo(new BigDecimal(20)) == 0));
    }

    @DisplayName("Le compte devrait avoir le montant en moins sur son compte après débit")
    @Test
    void retirerSoldeCompteBancaire() {
        UUID idCompteBancaireTest = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());
        CompteBancaire compteBancaireRecuperer = new CompteBancaire(idCompteBancaireTest, "EUR", new BigDecimal(5), client);

        when(compteBanquairePersistence.recupererCompteBancaire(idCompteBancaireTest)).thenReturn(compteBancaireRecuperer);

        compteBancaireService.debit(idCompteBancaireTest, new BigDecimal(2));

        verify(compteBanquairePersistence).sauvegarderCompteBancaire(argThat(compteBancaire ->
                compteBancaire.getSolde().compareTo(new BigDecimal(3)) == 0));
    }

    @DisplayName("Si on veut retirer plus que le solde du compte alors une exception est levée")
    @Test
    void retirerSoldeCompteBancaireAvecException() {
        UUID idCompteBancaireTest = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());
        CompteBancaire compteBancaireRecuperer = new CompteBancaire(idCompteBancaireTest, "EUR", new BigDecimal(2), client);

        when(compteBanquairePersistence.recupererCompteBancaire(idCompteBancaireTest)).thenReturn(compteBancaireRecuperer);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                compteBancaireService.debit(idCompteBancaireTest, new BigDecimal(150))
        );

        assertEquals("Le montant ne peut pas être zéro ou négatif", exception.getMessage());
    }
}