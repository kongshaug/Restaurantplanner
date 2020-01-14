/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Ingredient;
import entities.Recipe;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author benja
 */
public class RecipeDTO {
    
    private Set<IngredientDTO> ingredients = new HashSet();
    private int preparationTime;
    private String directions;

    public RecipeDTO(Recipe recipe) {
        this.preparationTime = recipe.getPreparationTime();
        this.directions = recipe.getDirections();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredients.add(new IngredientDTO(ingredient));
        }
    }

    public Set<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
            
    
    
}
