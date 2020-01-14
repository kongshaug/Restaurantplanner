/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.RecipeDTO;
import entities.Recipe;
import entities.Ingredient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author benja
 */
public class RecipeFacade {

    private static EntityManagerFactory emf;
    private static RecipeFacade instance;

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static RecipeFacade getRecipeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    public Set<RecipeDTO> getAllRecipes() {

        EntityManager em = emf.createEntityManager();
        List<Recipe> recipes;
        Set<RecipeDTO> recipesDTO = new HashSet();
        try {
            TypedQuery<Recipe> query = em.createQuery("SELECT r FROM Recipe r", Recipe.class);
            recipes = query.getResultList();
            //make catch if Recipe == null
        } finally {
            em.close();
        }
        for (Recipe recipe :  recipes) {
            recipesDTO.add(new RecipeDTO(recipe));
        }
        return recipesDTO;

    }

    public Ingredient isInStorage(Recipe recipe) {
        return null;
    }
}
