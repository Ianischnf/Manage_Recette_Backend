package fr.planificateur.recette.Repository;

import fr.planificateur.recette.Entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
