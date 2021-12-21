package elections.controlers;
import elections.entities.politician.PoliticianUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import elections.entities.politician.Politician;
import elections.entities.politician.PoliticianCreationDTO;
import elections.services.PoliticianService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/politicians")
public class PoliticiansREST {
    @Autowired
    PoliticianService politicianService;

    @GetMapping
    private ResponseEntity<List<Politician>> getAllPoliticians() {
        return politicianService.getAllPoliticians();
    }

    @PostMapping
    private ResponseEntity<Politician> createPolitician(@RequestBody PoliticianCreationDTO politician) {
        return politicianService.createPolitician(politician);
    }

    @PutMapping
    private ResponseEntity<Politician> updatePolitician(@RequestBody PoliticianUpdateDTO politician) {
        return politicianService.updatePolitician(politician);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deletePolitician(@PathVariable int id) {
        return politicianService.deletePolitician(id);
    }
}