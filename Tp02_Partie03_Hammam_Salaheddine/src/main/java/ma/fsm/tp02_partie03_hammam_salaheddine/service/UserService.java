package ma.fsm.tp02_partie03_hammam_salaheddine.service;

import ma.fsm.tp02_partie03_hammam_salaheddine.entities.Role;
import ma.fsm.tp02_partie03_hammam_salaheddine.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);
}
