package com.example.itinovbank.infrastructure.repository;

import com.example.itinovbank.infrastructure.entity.HistoriqueOperationsDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HistoriqueOperationJPA extends JpaRepository<HistoriqueOperationsDatabase, UUID> {
    List<HistoriqueOperationsDatabase> findByCompteBancaireCibleDatabase_ClientDatabase_Id(UUID clientId);

}
