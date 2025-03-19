package com.example.itinovbank.domain.port;

import com.example.itinovbank.domain.model.HistoriqueOperation;

import java.util.List;
import java.util.UUID;

public interface HistoriqueOperationsInterface {
    List<HistoriqueOperation> recupererListeHistoriqueOperationsClient(UUID idClient);
}
