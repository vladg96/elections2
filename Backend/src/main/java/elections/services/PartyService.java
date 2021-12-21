package elections.services;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import elections.entities.Party.Party;
import elections.repositories.PartyRepository;

@Service
public class PartyService {
    PartyRepository partyRepository;
    ModelMapper modelMapper;

    public PartyService(PartyRepository partyRepository){
        this.partyRepository = partyRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<Party> getParty(int id) {
        return new ResponseEntity<>(partyRepository.getById(id), HttpStatus.OK);
    }
}
