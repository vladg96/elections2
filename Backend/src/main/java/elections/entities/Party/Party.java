package elections.entities.Party;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import elections.entities.politician.Politician;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Parties")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "party")
    @JsonIgnoreProperties("party")
    private List<Politician> politicians = new ArrayList<>();
}
