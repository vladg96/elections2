package elections.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import elections.entities.vote.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
