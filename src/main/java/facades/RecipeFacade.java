/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.IngredientDTO;
import DTO.RecipeDTO;
import entities.Recipe;
import entities.Ingredient;
import entities.Item;
import entities.WeekMenuPlan;
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
        for (Recipe recipe : recipes) {
            recipesDTO.add(new RecipeDTO(recipe));
        }
        return recipesDTO;

    }

    public String isInStorage(String name) {
         EntityManager em = emf.createEntityManager();
        Recipe recipe;
        
          try {
            TypedQuery<Recipe> query = em.createQuery("SELECT r FROM Recipe r WHERE r.name = :name", Recipe.class);
            recipe = query.setParameter("name", name).getResultList().get(0);
           
        }
          catch( Exception e){
           return "{\"msg\":\"no recipe with given name\"}";
          }
          
          finally {
            em.close();
        }
         
          for (Ingredient ingredient :  recipe.getIngredients()) {
            if(ingredient.getAmount()> ingredient.getItem().getStorageAmount())
            {
                return "{\"msg\":\""+ ingredient.getItem().getName()+"\"}";
            }
        }
          
          
        return "{\"msg\":\"true\"}";
    }

    public String populate() {
        EntityManager em = emf.createEntityManager();
      
     WeekMenuPlan w1;

     Recipe r1;
     Recipe r2;
     Recipe r3;
     Recipe r4;
     Recipe r5;
     Recipe r6;
     Recipe r7;

     Ingredient i1;
     Ingredient i2;
     Ingredient i3;
     Ingredient i4;
     Ingredient i5;
     Ingredient i6;
     Ingredient i7;
     Ingredient i8;
     Ingredient i9;
     Ingredient i10;
     Ingredient i11;
     Ingredient i12;
     Ingredient i13;

     Item it1;
     Item it2;
     Item it3;
     Item it4;
     Item it5;
     Item it6;
     Item it7;
     Item it8;
     Item it9;
     Item it10;
     Item it11;
     Item it12;
     Item it13;

    it1  = new Item("banan", 30.0, 20000);
    it2  = new Item("smør", 10.0, 50000);
    it3  = new Item("rørsukker", 5.0, 100000);
    it4  = new Item("vaniljepulver", 100.0, 500);
    it5  = new Item("hvedemel", 10.0, 80000);
    it6  = new Item("bagepulver", 50.0, 1000);
    it7  = new Item("kanel", 120.0, 1000);
    it8  = new Item("ingefær", 200.0, 3000);
    it9  = new Item("mørkchokolade", 300.0, 4000);
    it10  = new Item("piskefløde", 100.0, 3000);
    it11  = new Item("valnødder", 400.0, 6000);
    it12  = new Item("brun farin", 400.0, 6000);
    it13  = new Item("gulerødder", 50.0, 8000);

    i1  = new Ingredient(it1, 1000);
    i2  = new Ingredient(it2, 500);
    i3  = new Ingredient(it3, 2000);
    i4  = new Ingredient(it4, 100);
    i5  = new Ingredient(it5, 3000);
    i6  = new Ingredient(it6, 200);
    i7  = new Ingredient(it7, 80);
    i8  = new Ingredient(it8, 150);
    i9  = new Ingredient(it9, 500);
    i10  = new Ingredient(it10, 500);
    i11  = new Ingredient(it11, 800);
    i12  = new Ingredient(it4, 10);
    i13  = new Ingredient(it8, 100);

    r1  = new Recipe("banan brød", 4, "Bananbrød med valnødder er lækkert, svampet og smager skønt som en eftermiddagssnack. mix alle ingredienserne i en skål, fordel i fade og put i ovenen i 30 minutter ");

    r1.addIngredient (i1);

    r1.addIngredient (i2);

    r1.addIngredient (i3);

    r1.addIngredient (i4);

    r1.addIngredient (i5);

    r1.addIngredient (i6);

    r1.addIngredient (i7);

    r1.addIngredient (i8);

    r1.addIngredient (i9);

    r1.addIngredient (i10);

    r2  = new Recipe("chocolade kage", 3, "Opskrift på en nem chokoladekage i bradepande - lige til at servere! Prøv en lækker chokoladekage bland smør og mel smid i ovene og put resten på toppen");

    r2.addIngredient (i2);

    r2.addIngredient (i9);

    r2.addIngredient (i10);

    r2.addIngredient (i3);

    r2.addIngredient (i4);

    r2.addIngredient (i11);

    r3  = new Recipe("flødecreme", 1, "skum fløden og tilsæt sukker og så er du der næsten");

    r3.addIngredient (i1);

    r3.addIngredient (i10);

    r3.addIngredient (i12);

    r3.addIngredient (i3);

    r3.addIngredient (i4);

    r4  = new Recipe("chokolade bananer", 3, "smelt chocoladen, dyb bananderne (tilføj evt. nogle chilinødder i chocoladen)");

    r4.addIngredient (i9);

    r4.addIngredient (i8);

    r4.addIngredient (i7);

    r4.addIngredient (i6);

    r4.addIngredient (i5);

    r5  = new Recipe("ingefærdskage", 4, "skrald infefæren og bland dem i kagen");

    r5.addIngredient (i1);

    r5.addIngredient (i3);

    r5.addIngredient (i6);

    r5.addIngredient (i7);

    r5.addIngredient (i8);

    r6  = new Recipe("gulerodskage", 7, "skrald gulerødderne, riv dem og bland dem i kagedejen");

    r6.addIngredient (i2);

    r6.addIngredient (i5);

    r6.addIngredient (i8);

    r6.addIngredient (i10);

    r6.addIngredient (i13);

    r7  = new Recipe("coldslaw", 2, "skrald gulerødderne, riv dem og bland dem med creme");

    r7.addIngredient (i1);

    r7.addIngredient (i2);

    r7.addIngredient (i10);

    r7.addIngredient (i13);

    r7.addIngredient (i12);

    w1  = new WeekMenuPlan(2020, 1);

    w1.addRecipe (r1);

    w1.addRecipe (r2);

    w1.addRecipe (r3);

    w1.addRecipe (r4);

    w1.addRecipe (r5);

    w1.addRecipe (r6);

    w1.addRecipe (r7);

    
        try {
            em.getTransaction().begin();
        //Delete existing users and roles to get a "fresh" database
        em.createQuery("delete from WeekMenuPlan").executeUpdate();
        em.createQuery("delete from Recipe").executeUpdate();
        em.createQuery("delete from Ingredient").executeUpdate();
        em.createQuery("delete from Item").executeUpdate();

        em.persist(w1);
        System.out.println("Saved test data to database");
        em.getTransaction().commit();
        
        return "database is populated";
    }

    
        finally {
            em.close();
    }
        
      
}
}

