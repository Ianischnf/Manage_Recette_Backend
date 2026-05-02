package fr.planificateur.recette.Repository;

import fr.planificateur.recette.Entity.ShoppingListIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListIngredientRepository extends JpaRepository<ShoppingListIngredient, Long> {
}
