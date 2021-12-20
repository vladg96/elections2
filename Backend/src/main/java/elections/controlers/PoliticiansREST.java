package elections.controlers;

import elections.entities.politician.Politician;
import elections.services.PoliticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
