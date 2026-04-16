package fr.planificateur.recette.Controller;

import fr.planificateur.recette.Entity.User;
import fr.planificateur.recette.Service.User.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User userRegister(@Valid @RequestBody User user){
        return this.userService.createUser(user);
    }

    @GetMapping
    public List<User> FetchAllUsers(){
        return this.userService.FetchAllUsers();
    }

    @PutMapping("/{id}")
    public User UpdateUser(@RequestBody User user, @PathVariable("id") Long UserId) {
        return this.userService.UpdateUser(user, UserId);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") Long UserId){
        this.userService.DeleteUserById(UserId);
    }

}
