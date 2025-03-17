package com.example.itinovbank.application.rest;

import com.example.itinovbank.application.rest.input.RequestListCompte;
import com.example.itinovbank.domain.model.CompteBancaire;
import com.example.itinovbank.domain.port.ClientServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")

public class ClientController {

    private final ClientServiceInterface clientServiceInterface;

    public ClientController(ClientServiceInterface clientServiceInterface) {
        this.clientServiceInterface = clientServiceInterface;
    }

    @GetMapping("/lister-compte")
    public List<CompteBancaire> recupererListeCompteClient(@RequestBody RequestListCompte request) {
        return clientServiceInterface.recupererListeCompteClient(request.getIdClient());
    }
}
