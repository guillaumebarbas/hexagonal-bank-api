package com.example.itinovbank.infrastructure.mapper;

import com.example.itinovbank.domain.model.Client;
import com.example.itinovbank.infrastructure.entity.ClientDatabase;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client versClient(ClientDatabase clientDatabase) {
        return new Client(clientDatabase.getId());
    }

    public ClientDatabase versClientDatabase(Client client) {
        return new ClientDatabase(client.getId());
    }
}
