package elections.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import elections.entities.Party.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
}