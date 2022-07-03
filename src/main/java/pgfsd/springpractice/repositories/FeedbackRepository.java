package pgfsd.springpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgfsd.springpractice.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    public Feedback save(Feedback feedback);
}