package elections.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import elections.entities.Party.Party;
import elections.services.PartyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/parties")
public class PartyREST {
    @Autowired
    PartyService partyService;

    @GetMapping("/{id}")
    private ResponseEntity<Party> deletePolitician(@PathVariable int id) {
        return partyService.getParty(id);
    }
}
