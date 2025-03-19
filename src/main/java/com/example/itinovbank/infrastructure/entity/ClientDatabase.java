package com.example.itinovbank.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class ClientDatabase {


    @Id
    private UUID id;
    @OneToMany(mappedBy = "clientDatabase")
    List<CompteBancaireDatabase> compteBancaireDatabaseList;

    public ClientDatabase(UUID id) {
        this.id =id;
    }
}
