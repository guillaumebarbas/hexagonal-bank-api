package com.example.itinovbank.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historique_operations")
public class HistoriqueOperationsDatabase {
    @Id
    UUID id;
    String typeOperation;
    String montant;
}
