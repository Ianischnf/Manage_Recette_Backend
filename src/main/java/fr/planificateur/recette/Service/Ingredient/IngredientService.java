package fr.planificateur.recette.Service.Ingredient;

import fr.planificateur.recette.Entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {
    Ingredient saveIngredient(Ingredient ingredient);
    List<Ingredient> fetchAllIngredient();
    Ingredient updateIngredient(Ingredient UpdatedIngredient, Long IngredientId);
    void deleteIngredientById(Long IngredientId);
}
