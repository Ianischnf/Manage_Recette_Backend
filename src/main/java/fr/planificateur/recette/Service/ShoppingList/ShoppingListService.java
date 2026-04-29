package fr.planificateur.recette.Service.ShoppingList;

import fr.planificateur.recette.Entity.ShoppingList;
import fr.planificateur.recette.Entity.ShoppingListIngredient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShoppingListService {
    ShoppingList createShoppingList(ShoppingList shoppingList);
    List<ShoppingList> FetchAllShoppingList();
    ShoppingList updateShoppingList(ShoppingList UpdatedshoppingList, Long ShoppingListId);
    void deleteShoppingList(Long ShoppingListId);
}
