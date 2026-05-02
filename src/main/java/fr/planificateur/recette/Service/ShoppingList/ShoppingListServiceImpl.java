package fr.planificateur.recette.Service.ShoppingList;

import fr.planificateur.recette.Entity.Ingredient;
import fr.planificateur.recette.Entity.ShoppingList;
import fr.planificateur.recette.Entity.ShoppingListIngredient;
import fr.planificateur.recette.Repository.IngredientRepository;
import fr.planificateur.recette.Repository.ShoppingListIngredientRepository;
import fr.planificateur.recette.Repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListServiceImpl implements ShoppingListService{

    @Autowired
    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    private final IngredientRepository ingredientRepository;

    @Autowired
    private final ShoppingListIngredientRepository shoppingListIngredientRepository;

    public ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository, IngredientRepository ingredientRepository, ShoppingListIngredientRepository shoppingListIngredientRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.ingredientRepository = ingredientRepository;
        this.shoppingListIngredientRepository = shoppingListIngredientRepository;
    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        return this.shoppingListRepository.save(shoppingList);
    }

    @Override
    public ShoppingListIngredient addIngredientToShoppingList(
            Long shoppingListId,
            Long ingredientId,
            String quantity,
            String unit
    ) {
        ShoppingList shoppingList = shoppingListRepository.findById(shoppingListId)
                .orElseThrow(() -> new RuntimeException("Liste introuvable"));

        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Ingrédient introuvable"));

        ShoppingListIngredient item = new ShoppingListIngredient(
                shoppingList,
                ingredient,
                quantity,
                unit
        );

        return shoppingListIngredientRepository.save(item);
    }

    @Override
    public List<ShoppingList> FetchAllShoppingList() {
        return (List<ShoppingList>)
                    this.shoppingListRepository.findAll();
    }

    @Override
    public ShoppingList updateShoppingList(ShoppingList UpdatedshoppingList, Long ShoppingListId) {
        ShoppingList foundShoppingList = shoppingListRepository.findById(ShoppingListId)
                .orElseThrow(() -> new RuntimeException("Liste de course introuvable"));

        if(UpdatedshoppingList.getName() != null) {
            foundShoppingList.setName(UpdatedshoppingList.getName());
        }

        return shoppingListRepository.save(foundShoppingList);
    }

    @Override
    public void deleteShoppingList(Long ShoppingListId) {
        this.shoppingListRepository.deleteById(ShoppingListId);
    }
}
