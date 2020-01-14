/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author benja
 */
@Entity
@NamedQuery(name = "Recipe.deleteAllRows", query = "DELETE from Recipe")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Ingredient> ingredients = new HashSet();
    private int preparationTime;
    private String directions;
    @ManyToMany(mappedBy = "recipes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<WeekMenuPlan> weekMenuPlans = new HashSet();

    public Recipe(String name, int preparationTime, String directions) {
        this.name = name;
        this.preparationTime = preparationTime;
        this.directions = directions;
    }

    
    
    
    public Recipe() {
    }
    
    
    public void addIngredient(Ingredient ingridient){
    this.ingredients.add(ingridient);
    }
    
    public void addWeekMenuPlan(WeekMenuPlan wmp){
    this.weekMenuPlans.add(wmp);
    }
    
     public void RemoveWeekMenuPlan(WeekMenuPlan wmp){
    this.weekMenuPlans.remove(wmp);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
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

    public Set<WeekMenuPlan> getWeekMenuPlans() {
        return weekMenuPlans;
    }

    public void setWeekMenuPlans(Set<WeekMenuPlan> weekMenuPlans) {
        this.weekMenuPlans = weekMenuPlans;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + this.preparationTime;
        hash = 71 * hash + Objects.hashCode(this.directions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        if (this.preparationTime != other.preparationTime) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.directions, other.directions)) {
            return false;
        }
        return true;
    }

 
    
}
