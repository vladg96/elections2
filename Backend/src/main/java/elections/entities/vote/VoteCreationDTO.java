package elections.entities.vote;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VoteCreationDTO {
    private String cpr;
    private int politicianId;
}

