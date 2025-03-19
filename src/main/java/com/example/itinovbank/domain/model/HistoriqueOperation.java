package com.example.itinovbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HistoriqueOperation {
    CompteBancaire compteBancaireCible;
    String typeOperation;
    BigDecimal montant;
    LocalDate dateCreation;

    public HistoriqueOperation(CompteBancaire compteBancaireCible, String typeOperation, BigDecimal montant, LocalDate dateCreation) {
        this.compteBancaireCible = compteBancaireCible;
        this.typeOperation = typeOperation;
        this.montant = montant;
        this.dateCreation = dateCreation;
    }

    public CompteBancaire getCompteBancaireCible() {
        return compteBancaireCible;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public LocalDate getDate() {
        return dateCreation;
    }
}
