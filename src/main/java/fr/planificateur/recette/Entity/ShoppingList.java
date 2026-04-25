package fr.planificateur.recette.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shopping_list")

public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long ShoppingListId;


    private String Name;

    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingListIngredient> items;

    public ShoppingList() {}

    public ShoppingList(String name){
        this.Name = name;
    }

    public ShoppingList(Long shoppingListId, String name) {
        this.Name           = name;
        this.ShoppingListId = shoppingListId;
    }

}
