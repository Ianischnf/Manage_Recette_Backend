package fr.planificateur.recette.Service.Auth;

import fr.planificateur.recette.DTO.LoginRequestDTO;
import fr.planificateur.recette.DTO.LoginResponseDTO;
import fr.planificateur.recette.Entity.User;

public interface AuthService {

    User register(User user);
    LoginResponseDTO login(LoginRequestDTO request);

}
