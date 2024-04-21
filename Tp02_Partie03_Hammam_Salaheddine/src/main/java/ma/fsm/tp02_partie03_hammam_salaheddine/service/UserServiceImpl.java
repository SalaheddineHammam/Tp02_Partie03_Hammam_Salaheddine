package ma.fsm.tp02_partie03_hammam_salaheddine.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.fsm.tp02_partie03_hammam_salaheddine.entities.Role;
import ma.fsm.tp02_partie03_hammam_salaheddine.entities.User;
import ma.fsm.tp02_partie03_hammam_salaheddine.repositories.RoleRepository;
import ma.fsm.tp02_partie03_hammam_salaheddine.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

//    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//    }

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("User not found");
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid username or password");
    }
}
