package ma.fsm.tp02_partie03_hammam_salaheddine.repositories;

import ma.fsm.tp02_partie03_hammam_salaheddine.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
