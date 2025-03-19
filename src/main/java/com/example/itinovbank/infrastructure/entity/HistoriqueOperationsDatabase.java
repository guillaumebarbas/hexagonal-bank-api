package com.example.itinovbank.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "historique_operations")
public class HistoriqueOperationsDatabase {
    @Id
    UUID id;
    @ManyToOne
    CompteBancaireDatabase compteBancaireCibleDatabase;
    String typeOperation;
    BigDecimal montant;
    LocalDate dateCreation;
}
