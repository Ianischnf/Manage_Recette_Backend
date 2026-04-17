package fr.planificateur.recette.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long RecipeId;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Instructions")
    private String Instructions;

    @Column(name = "PreparationTime")
    private String PreparationTime;

    @Column(name = "CookingTime")
    private Double CookingTime;

    @Column(name = "NbPortion")
    private Integer NbPortion;

    @Column(name = "Type")
    private String Type;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> recipeIngredients;

    public Recipe() {}

    public Recipe(Long recipeId, String title, String description, String instructions, String preparationTime, Double cookingTime, Integer nbPortion, String type) {
        this.RecipeId           = recipeId;
        this.Title              = title;
        this.Description        = description;
        this.Instructions       = instructions;
        this.PreparationTime    = preparationTime;
        this.CookingTime        = cookingTime;
        this.NbPortion          = nbPortion;
        this.Type               = type;
    }

    public Recipe(String title, String description, String instructions, String preparationTime, Double cookingTime, Integer nbPortion, String type) {
        this.Title              = title;
        this.Description        = description;
        this.Instructions       = instructions;
        this.PreparationTime    = preparationTime;
        this.CookingTime        = cookingTime;
        this.NbPortion          = nbPortion;
        this.Type               = type;
    }

    public Long getRecipeId() {
        return RecipeId;
    }

    public void setRecipeId(Long recipeId) {
        RecipeId = recipeId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    public String getPreparationTime() {
        return PreparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        PreparationTime = preparationTime;
    }

    public Double getCookingTime() {
        return CookingTime;
    }

    public void setCookingTime(Double cookingTime) {
        CookingTime = cookingTime;
    }

    public Integer getNbPortion() {
        return NbPortion;
    }

    public void setNbPortion(Integer nbPortion) {
        NbPortion = nbPortion;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
