package elections.entities.politician;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import elections.entities.Party.Party;
import elections.entities.vote.Vote;
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
@Table(name = "politicians")
public class Politician {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.DETACH)
    //column named partied_id in this column is referred to id in the other table
    @JoinColumn(name="parties_id",referencedColumnName = "id")
    @JsonIgnoreProperties("candidates")
    private Party party;

    @OneToMany(mappedBy = "politician")
    @JsonIgnore
    private List<Vote> votes= new ArrayList<>();
}