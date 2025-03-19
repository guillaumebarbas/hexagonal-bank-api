package com.example.itinovbank.domain.model;

import java.util.UUID;

public class Client {
    private final UUID id;

    public Client(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
