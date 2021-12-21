package elections.entities.politician;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PoliticianCreationDTO {
    private String name;
    private int party;
}