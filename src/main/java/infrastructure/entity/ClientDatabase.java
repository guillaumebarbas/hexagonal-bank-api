package infrastructure.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class ClientDatabase {
    @Id
    private UUID id;

    private String nomFamiile;
    private String prenom;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CompteDatabase> listeCompte;


}
