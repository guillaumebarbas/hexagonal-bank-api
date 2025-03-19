package com.example.itinovbank.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compte_bancaire")
public class CompteBancaireDatabase {
    @Id
    private UUID id;
    String devise;
    BigDecimal montant;
    @ManyToOne
    ClientDatabase clientDatabase;
}
