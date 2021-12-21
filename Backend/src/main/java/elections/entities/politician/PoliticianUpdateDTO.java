package elections.entities.politician;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PoliticianUpdateDTO {
    private int id;
    private String name;
    private int party;
}

