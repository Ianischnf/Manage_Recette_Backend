package fr.planificateur.recette.Service.Recipe;

import fr.planificateur.recette.Entity.Recipe;
import fr.planificateur.recette.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> fetchAllRecipes() {
        return (List<Recipe>)
                recipeRepository.findAll();
    }

    @Override
    public Recipe updateRecipe(Recipe RecipeUpdated, Long RecipeId) {
        Recipe FoundRecipe = recipeRepository.findById(RecipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        if (RecipeUpdated.getTitle() != null) {
            FoundRecipe.setTitle(RecipeUpdated.getTitle());
        }

        if(RecipeUpdated.getDescription() != null) {
            FoundRecipe.setDescription(RecipeUpdated.getDescription());
        }

        if(RecipeUpdated.getInstructions() != null) {
            FoundRecipe.setInstructions(RecipeUpdated.getInstructions());
        }

        if(RecipeUpdated.getPreparationTime() != null) {
            FoundRecipe.setPreparationTime(RecipeUpdated.getPreparationTime());
        }

        if(RecipeUpdated.getCookingTime() != null) {
            FoundRecipe.setPreparationTime(RecipeUpdated.getPreparationTime());
        }

        if(RecipeUpdated.getNbPortion() != null) {
            FoundRecipe.setNbPortion(RecipeUpdated.getNbPortion());
        }

        if(RecipeUpdated.getType() != null) {
            FoundRecipe.setType(RecipeUpdated.getType());
        }

        return recipeRepository.save(FoundRecipe);
    }

    @Override
    public void deleteRecipeById(Long RecipeId) {
        recipeRepository.deleteById(RecipeId);
    }
}
