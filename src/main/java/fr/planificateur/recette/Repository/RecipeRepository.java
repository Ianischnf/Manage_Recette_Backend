package fr.planificateur.recette.Repository;

import fr.planificateur.recette.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
