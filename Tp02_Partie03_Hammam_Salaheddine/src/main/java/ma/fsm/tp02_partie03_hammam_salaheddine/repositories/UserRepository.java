package ma.fsm.tp02_partie03_hammam_salaheddine.repositories;

import ma.fsm.tp02_partie03_hammam_salaheddine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String userName);

}
