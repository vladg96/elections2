package elections.repositories;

import elections.entities.politician.Politician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticianRepository extends JpaRepository<Politician, Integer> {
}


