package fr.planificateur.recette.Entity;

import jakarta.persistence.*;

@Entity
public class ShoppingListIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quantity;

    private String unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShoppingListId")
    private ShoppingList shoppingList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IngredientId")
    private Ingredient ingredient;

    public ShoppingListIngredient() {}

    public ShoppingListIngredient(Long id, ShoppingList shoppingList, Ingredient ingredient, String quantity, String unit) {
        this.id             = id;
        this.shoppingList   = shoppingList;
        this.ingredient     = ingredient;
        this.quantity       = quantity;
        this.unit           = unit;
    }

    public ShoppingListIngredient( ShoppingList shoppingList, Ingredient ingredient, String quantity, String unit) {
        this.shoppingList   = shoppingList;
        this.ingredient     = ingredient;
        this.quantity       = quantity;
        this.unit           = unit;
    }
}
