package com.example.itinovbank.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CompteBancaire {
    private final UUID id;
    private final String devise;
    private BigDecimal solde;
    private final Client client;

    public CompteBancaire(UUID id, String devise, BigDecimal solde, Client client) {
        this.id = id;
        this.devise = devise;
        this.solde = solde;
        this.client = client;
    }

    public void ajouterSolde(BigDecimal montantAjouter) {
        this.solde = this.solde.add(montantAjouter);
    }

    public void retirerSolde(BigDecimal montantRetirer) {
        if (solde.subtract(montantRetirer).compareTo(BigDecimal.ZERO) > 0) {
            this.solde = this.solde.subtract(montantRetirer);
        } else {
            throw new IllegalArgumentException("Le montant ne peut pas être zéro ou négatif");
        }
    }


    public UUID getId() {
        return id;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public String getDevise() {
        return devise;
    }

    public Client getClient() {
        return client;
    }
}
