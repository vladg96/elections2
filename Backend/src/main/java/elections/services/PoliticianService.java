package elections.services;

import elections.entities.politician.Politician;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import elections.repositories.PoliticianRepository;

import java.util.List;


@Service
public class PoliticianService {
    PoliticianRepository politicianRepository;
    ModelMapper modelMapper;

    public PoliticianService(PoliticianRepository politicianRepository){
        this.politicianRepository = politicianRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Politician>> getAllPoliticians() {
        return new ResponseEntity<>(politicianRepository.findAll(), HttpStatus.OK);
    }
}

