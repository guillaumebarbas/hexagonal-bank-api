package com.example.itinovbank.domain.port;

import com.example.itinovbank.domain.model.CompteBancaire;

import java.util.List;
import java.util.UUID;

public interface ClientServiceInterface {

    List<CompteBancaire> recupererListeCompteClient(UUID idClient);
}
