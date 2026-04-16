package fr.planificateur.recette.Controller;

import fr.planificateur.recette.Entity.Ingredient;
import fr.planificateur.recette.Repository.IngredientRepository;
import fr.planificateur.recette.Service.Ingredient.IngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public Ingredient saveIngredient(@Valid @RequestBody Ingredient ingredient) {
        return this.ingredientService.saveIngredient(ingredient);
    }

    @GetMapping
    public List<Ingredient> fetchAllIngredient() {
        return this.ingredientService.fetchAllIngredient();
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient, @PathVariable("id") Long IngredientId) {
        return this.ingredientService.updateIngredient(ingredient, IngredientId);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredientById(@PathVariable("id") Long IngredientId) {
        this.ingredientService.deleteIngredientById(IngredientId);
    }


}
