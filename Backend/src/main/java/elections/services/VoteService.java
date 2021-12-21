package elections.services;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import elections.entities.Party.Party;
import elections.entities.politician.Politician;
import elections.entities.vote.Vote;
import elections.entities.vote.VoteCreationDTO;
import elections.repositories.PoliticianRepository;
import elections.repositories.PartyRepository;
import elections.repositories.VoteRepository;

import java.util.List;

@Service
public class VoteService {
    PoliticianRepository politicianRepository;
    PartyRepository partyRepository;
    VoteRepository voteRepository;
    ModelMapper modelMapper;

    public VoteService(VoteRepository voteRepository, PoliticianRepository politicianRepository, PartyRepository partyRepository){
        this.politicianRepository = politicianRepository;
        this.partyRepository = partyRepository;
        this.voteRepository = voteRepository;
        this.modelMapper = new ModelMapper();
    }


    public ResponseEntity<List<Vote>> getAllVotes() {
        return new ResponseEntity<>(voteRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity createVote(VoteCreationDTO vote) {
        Vote newVote = new Vote();
        Politician politician = politicianRepository.getById(vote.getPoliticianId());
        newVote.setPolitician(politician);
        newVote.setCpr(vote.getCpr());
        voteRepository.save(newVote);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}