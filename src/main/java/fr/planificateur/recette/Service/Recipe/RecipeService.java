package fr.planificateur.recette.Service.Recipe;

import fr.planificateur.recette.Entity.Recipe;
import fr.planificateur.recette.Entity.RecipeIngredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    //Recipe createRecipeWitchIngredient(Recipe recipe, List<RecipeIngredient> RecipeIngredient);
    Recipe saveRecipe(Recipe recipe);
    List<Recipe> fetchAllRecipes();
    Recipe updateRecipe(Recipe RecipeUpdated, Long RecipeId);
    void deleteRecipeById(Long RecipeId);
}
