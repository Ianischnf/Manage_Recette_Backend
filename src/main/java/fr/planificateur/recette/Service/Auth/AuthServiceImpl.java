package fr.planificateur.recette.Service.Auth;

import fr.planificateur.recette.DTO.LoginRequestDTO;
import fr.planificateur.recette.DTO.LoginResponseDTO;
import fr.planificateur.recette.Entity.User;
import fr.planificateur.recette.Repository.UserRepository;
import fr.planificateur.recette.Security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public User register(User user) {

        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email déjà utilisée");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save((user));
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {

        // 1 - Retrouver l'user via son email
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Email introuvable"));

        // 2 - Vérifier le mdp
        if(!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        // 3 - Générer le token
        String token = jwtService.generateToken(user.getEmail());

        // 4 - return le token

        return new LoginResponseDTO(token);
    }


}
