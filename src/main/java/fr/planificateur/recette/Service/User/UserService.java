package fr.planificateur.recette.Service.User;

import fr.planificateur.recette.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    List<User> FetchAllUsers();
    User UpdateUser(User updatedUser, Long UserId);
    void DeleteUserById(Long UserId);
}
