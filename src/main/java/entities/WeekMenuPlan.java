/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


/**
 *
 * @author benja
 */
@Entity
@NamedQuery(name = "WeekMenuPlan.deleteAllRows", query = "DELETE from WeekMenuPlan")
public class WeekMenuPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Recipe> recipes = new HashSet();
    private int weekNo;
    private int year;

    public WeekMenuPlan() {
    }

    public WeekMenuPlan(int weekNo, int year) {
        this.weekNo = weekNo;
        this.year = year;
       
    }
    
    
    
    public void addRecipe(Recipe recipe){
             this.recipes.add(recipe);
            recipe.addWeekMenuPlan(this);
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.weekNo;
        hash = 11 * hash + this.year;
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
        final WeekMenuPlan other = (WeekMenuPlan) obj;
        if (this.weekNo != other.weekNo) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

   

    
}
