package fr.planificateur.recette.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IngredientId")
    private Long IngredientId;

    @Column(name = "Name")
    private String Name;

    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeIngredients;

    @OneToMany(mappedBy = "ingredient")
    private List<ShoppingListIngredient> ShoppingListIngredient;


    public Ingredient() {}

    public Ingredient(Long ingredientId, String name) {
        this.IngredientId   = ingredientId;
        this.Name           = name;
    }

    public Ingredient(String name) {
        this.Name = name;
    }

    public Long getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(Long ingredientId) {
        IngredientId = ingredientId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
