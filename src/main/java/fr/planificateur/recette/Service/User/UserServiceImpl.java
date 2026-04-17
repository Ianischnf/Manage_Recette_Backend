package fr.planificateur.recette.Service.User;

import fr.planificateur.recette.Entity.User;
import fr.planificateur.recette.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public List<User> FetchAllUsers() {
        return (List<User>)
                this.userRepository.findAll();
    }

    @Override
    public User UpdateUser(User updatedUser, Long UserId) {

        User FoundUser = userRepository.findById(UserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update firstname
        if (updatedUser.getFirstName() != null) {
            FoundUser.setFirstName(updatedUser.getFirstName());
        }

        // Update lastname
        if (updatedUser.getLastName() != null) {
            FoundUser.setLastName(updatedUser.getLastName());
        }

        // Update email
        if (updatedUser.getEmail() != null &&
                !updatedUser.getEmail().equals(FoundUser.getEmail())) {

            if (userRepository.existsByEmail(updatedUser.getEmail())) {
                throw new RuntimeException("Email already in use");
            }

            FoundUser.setEmail(updatedUser.getEmail());
        }

        // Update password
        if (updatedUser.getPassword() != null &&
                !updatedUser.getPassword().isBlank()) {

            FoundUser.setPassword(
                    passwordEncoder.encode(updatedUser.getPassword())
            );
        }
        return userRepository.save(FoundUser);
    }

    @Override
    public void DeleteUserById(Long UserId) {
        userRepository.deleteById(UserId);
    }
}
