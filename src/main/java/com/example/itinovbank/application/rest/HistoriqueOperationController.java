package com.example.itinovbank.application.rest;

import com.example.itinovbank.domain.model.HistoriqueOperation;
import com.example.itinovbank.domain.port.HistoriqueOperationsInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/historique-operations")
public class HistoriqueOperationController {

    private final HistoriqueOperationsInterface historiqueOperationsInterface;

    public HistoriqueOperationController(HistoriqueOperationsInterface historiqueOperationsInterface) {
        this.historiqueOperationsInterface = historiqueOperationsInterface;
    }

    @GetMapping
    public List<HistoriqueOperation> recupererHistoriqueOperations(@RequestParam UUID idClient) {
        return historiqueOperationsInterface.recupererListeHistoriqueOperationsClient(idClient);
    }
}
