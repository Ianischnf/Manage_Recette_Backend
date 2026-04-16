package fr.planificateur.recette.Service.Recipe;

import fr.planificateur.recette.Entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    List<Recipe> fetchAllRecipes();
    Recipe updateRecipe(Recipe RecipeUpdated, Long RecipeId);
    void deleteRecipeById(Long RecipeId);
}
