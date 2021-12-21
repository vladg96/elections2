package elections.services;

import com.sun.tools.jconsole.JConsoleContext;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import elections.entities.Party.Party;
import elections.entities.politician.Politician;
import elections.entities.politician.PoliticianCreationDTO;
import elections.entities.politician.PoliticianUpdateDTO;
import elections.repositories.PoliticianRepository;
import elections.repositories.PartyRepository;

import java.util.List;


@Service
public class PoliticianService {
    PoliticianRepository politicianRepository;
    PartyRepository partyRepository;
    ModelMapper modelMapper;

    public PoliticianService(PoliticianRepository politicianRepository, PartyRepository partyRepository){
        this.politicianRepository = politicianRepository;
        this.partyRepository = partyRepository;
        this.modelMapper = new ModelMapper();
    }

    private Politician convertPoliticianCreationDTOToPolitician(PoliticianCreationDTO politician){
        return  modelMapper.map(politician, Politician.class);
    }

    public ResponseEntity<List<Politician>> getAllPoliticians() {
        return new ResponseEntity<>(politicianRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Politician> createPolitician(PoliticianCreationDTO politician) {
        Party party = partyRepository.getById(politician.getParty());
        Politician newPolitician = new Politician();
        newPolitician.setName(politician.getName());
        newPolitician.setParty(party);
        return new ResponseEntity<>(politicianRepository.save(newPolitician), HttpStatus.OK);
    }

    public ResponseEntity<Politician> updatePolitician(PoliticianUpdateDTO politician) {
        Politician savedPolitician = politicianRepository.getById(politician.getId());
        Party party = partyRepository.getById(politician.getParty());
        savedPolitician.setName(politician.getName());
        savedPolitician.setParty(party);
        return new ResponseEntity<>(politicianRepository.save(savedPolitician), HttpStatus.OK);
    }

    public ResponseEntity deletePolitician(int id) {
        politicianRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
