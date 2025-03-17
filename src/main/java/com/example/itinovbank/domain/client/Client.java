package com.example.itinovbank.domain.client;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class Client {
    private UUID id;

    public UUID getId() {
        return id;
    }
}
