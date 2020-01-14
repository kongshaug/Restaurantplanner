/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Recipe;
import entities.WeekMenuPlan;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author benja
 */
public class WeekMenuPlanDTO {
    
    private Set<RecipeDTO> recipes = new HashSet();
    private int week;
    private int year;

    public WeekMenuPlanDTO(WeekMenuPlan wmp) {
        
        this.week = wmp.getWeekNo();
        this.year = wmp.getYear();
        
        for (Recipe recipe : wmp.getRecipes()) {
            recipes.add(new RecipeDTO(recipe));
        }
    }

    public Set<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeDTO> recipes) {
        this.recipes = recipes;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
}
