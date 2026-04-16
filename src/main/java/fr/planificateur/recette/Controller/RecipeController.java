package fr.planificateur.recette.Controller;

import fr.planificateur.recette.Entity.Recipe;
import fr.planificateur.recette.Service.Recipe.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe saveRecipe(@Valid @RequestBody Recipe recipe) {
        return this.recipeService.saveRecipe(recipe);
    }

    @GetMapping
    public List<Recipe> fetchAllRecipes() {
        return this.recipeService.fetchAllRecipes();
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long RecipeId) {
        return this.recipeService.updateRecipe(recipe, RecipeId);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeById(@PathVariable Long RecipeId) {
        this.recipeService.deleteRecipeById(RecipeId);
    }
}
