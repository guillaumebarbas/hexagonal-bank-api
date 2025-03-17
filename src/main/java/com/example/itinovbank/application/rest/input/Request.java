package com.example.itinovbank.application.rest.input;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Request {
    private UUID id;
    private BigDecimal montant;
}
