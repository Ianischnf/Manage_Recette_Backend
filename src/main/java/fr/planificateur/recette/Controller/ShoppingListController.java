package fr.planificateur.recette.Controller;

import fr.planificateur.recette.Entity.ShoppingList;
import fr.planificateur.recette.Service.ShoppingList.ShoppingListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingListController {

    @Autowired
    ShoppingListService shoppingListService;


    @PostMapping
    public ShoppingList createShoppingList(@Valid @RequestBody ShoppingList shoppingList){
        return this.shoppingListService.createShoppingList(shoppingList);
    }

    @GetMapping
    public List<ShoppingList> FetchAllShoppingList() {
        return this.shoppingListService.FetchAllShoppingList();
    }

    @PutMapping("/{id}")
    public ShoppingList updateShoppingList(@RequestBody ShoppingList shoppingList, @PathVariable Long ShoppingListId) {
        return this.shoppingListService.updateShoppingList(shoppingList, ShoppingListId);
    }

    @DeleteMapping("/{id}")
    public void deleteShoppingList(@PathVariable Long ShoppingListId) {
        this.shoppingListService.deleteShoppingList(ShoppingListId);
    }

}
