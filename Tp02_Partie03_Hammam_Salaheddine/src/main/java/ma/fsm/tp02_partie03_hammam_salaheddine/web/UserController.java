package ma.fsm.tp02_partie03_hammam_salaheddine.web;

import ma.fsm.tp02_partie03_hammam_salaheddine.entities.User;
import ma.fsm.tp02_partie03_hammam_salaheddine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user = userService.findUserByUsername(username);
        return user;
    }
}
