package pgfsd.springpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgfsd.springpractice.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findUserById(Long id);

    User findUserByIdAndPassword(Long id, String password);
}