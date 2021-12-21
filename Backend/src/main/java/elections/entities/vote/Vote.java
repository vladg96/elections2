package elections.entities.vote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import elections.entities.Party.Party;
import elections.entities.politician.Politician;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String cpr;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="politicians_id",referencedColumnName = "id")
    @JsonIgnoreProperties("votes")
    private Politician politician;

}
