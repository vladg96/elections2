package elections.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import elections.entities.vote.Vote;
import elections.entities.vote.VoteCreationDTO;
import elections.services.VoteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/votes")
public class VoteREST {
    @Autowired
    VoteService voteService;

    @GetMapping
    private ResponseEntity<List<Vote>> getAllPoliticians() {
        return voteService.getAllVotes();
    }

    @PostMapping
    private ResponseEntity createPoliticians(@RequestBody VoteCreationDTO vote) {
        return voteService.createVote(vote);
    }
}


