package com.example.itinovbank.infrastructure.repository;

import com.example.itinovbank.infrastructure.entity.CompteBancaireDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompteBancaireJPA extends JpaRepository<CompteBancaireDatabase, UUID> {
}
