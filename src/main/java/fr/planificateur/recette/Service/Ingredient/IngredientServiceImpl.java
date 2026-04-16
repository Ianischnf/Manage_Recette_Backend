package fr.planificateur.recette.Service.Ingredient;

import fr.planificateur.recette.Entity.Ingredient;
import fr.planificateur.recette.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService{

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save((ingredient));
    }

    @Override
    public List<Ingredient> fetchAllIngredient() {
        return (List<Ingredient>)
                ingredientRepository.findAll();
    }

    @Override
    public Ingredient updateIngredient(Ingredient updatedIngredient, Long IngredientId) {

        Ingredient FoundIngredient = ingredientRepository.findById(IngredientId)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        if(updatedIngredient.getName() != null){
            FoundIngredient.setName(updatedIngredient.getName());
        }

        return ingredientRepository.save(FoundIngredient);
    }

    @Override
    public void deleteIngredientById(Long IngredientId) {
        ingredientRepository.deleteById(IngredientId);
    }
}
