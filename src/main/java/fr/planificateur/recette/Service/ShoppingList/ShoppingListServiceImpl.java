package fr.planificateur.recette.Service.ShoppingList;

import fr.planificateur.recette.Entity.ShoppingList;
import fr.planificateur.recette.Entity.ShoppingListIngredient;
import fr.planificateur.recette.Repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingListServiceImpl implements ShoppingListService{

    @Autowired
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        return this.shoppingListRepository.save(shoppingList);
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
