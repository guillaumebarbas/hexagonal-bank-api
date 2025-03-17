package com.example.itinovbank.domain.port;

import java.math.BigDecimal;
import java.util.UUID;

public interface CompteBancaireServiceInterface {

    void credit(UUID idCompteBancaire, BigDecimal montant);

    void debit(UUID idCompteBancaire, BigDecimal montant);

}
