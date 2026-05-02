package fr.planificateur.recette.DTO;

public record ShoppingListIngredientRequestDTO(
        Long ingredientId,
        String quantity,
        String unit
) {


}
