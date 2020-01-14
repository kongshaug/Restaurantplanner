/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.WeekMenuPlan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;

/**
 *
 * @author benja
 */
public class RecipeFacadeTest {

    private static EntityManagerFactory emf;
    private static RecipeFacade facade;

    private WeekMenuPlan w1;

    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;
    private Recipe r6;
    private Recipe r7;

    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private Ingredient i4;
    private Ingredient i5;
    private Ingredient i6;
    private Ingredient i7;
    private Ingredient i8;
    private Ingredient i9;
    private Ingredient i10;
    private Ingredient i11;
    private Ingredient i12;
    private Ingredient i13;

    private Item it1;
    private Item it2;
    private Item it3;
    private Item it4;
    private Item it5;
    private Item it6;
    private Item it7;
    private Item it8;
    private Item it9;
    private Item it10;
    private Item it11;
    private Item it12;
    private Item it13;

    public RecipeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {

        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = RecipeFacade.getRecipeFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        it1 = new Item("banan", 30.0, 20000);
        it2 = new Item("smør", 10.0, 50000);
        it3 = new Item("rørsukker", 5.0, 100000);
        it4 = new Item("vaniljepulver", 100.0, 500);
        it5 = new Item("hvedemel", 10.0, 80000);
        it6 = new Item("bagepulver", 50.0, 1000);
        it7 = new Item("kanel", 120.0, 1000);
        it8 = new Item("ingefær", 200.0, 3000);
        it9 = new Item("mørkchokolade", 300.0, 4000);
        it10 = new Item("piskefløde", 100.0, 3000);
        it11 = new Item("valnødder", 400.0, 6000);
        it12 = new Item("brun farin", 400.0, 6000);
        it13 = new Item("gulerødder", 50.0, 8000);

        i1 = new Ingredient(it1, 1000);
        i2 = new Ingredient(it2, 500);
        i3 = new Ingredient(it3, 2000);
        i4 = new Ingredient(it4, 100);
        i5 = new Ingredient(it5, 3000);
        i6 = new Ingredient(it6, 200);
        i7 = new Ingredient(it7, 80);
        i8 = new Ingredient(it8, 150);
        i9 = new Ingredient(it9, 500);
        i10 = new Ingredient(it10, 500);
        i11 = new Ingredient(it11, 800);
        i12 = new Ingredient(it4, 10);
        i13 = new Ingredient(it8, 100);

        r1 = new Recipe("banan brød", 4, "Bananbrød med valnødder er lækkert, svampet og smager skønt som en eftermiddagssnack. mix alle ingredienserne i en skål, fordel i fade og put i ovenen i 30 minutter ");
        r1.addIngredient(i1);
        r1.addIngredient(i2);
        r1.addIngredient(i3);
        r1.addIngredient(i4);
        r1.addIngredient(i5);
        r1.addIngredient(i6);
        r1.addIngredient(i7);
        r1.addIngredient(i8);
        r1.addIngredient(i9);
        r1.addIngredient(i10);

        r2 = new Recipe("chocolade kage", 3, "Opskrift på en nem chokoladekage i bradepande - lige til at servere! Prøv en lækker chokoladekage bland smør og mel smid i ovene og put resten på toppen");
        r2.addIngredient(i2);
        r2.addIngredient(i9);
        r2.addIngredient(i10);
        r2.addIngredient(i3);
        r2.addIngredient(i4);
        r2.addIngredient(i11);

        r3 = new Recipe("flødecreme", 1, "skum fløden og tilsæt sukker og så er du der næsten");
        r3.addIngredient(i1);
        r3.addIngredient(i10);
        r3.addIngredient(i12);
        r3.addIngredient(i3);
        r3.addIngredient(i4);

        r4 = new Recipe("chokolade bananer", 3, "smelt chocoladen, dyb bananderne (tilføj evt. nogle chilinødder i chocoladen)");
        r4.addIngredient(i9);
        r4.addIngredient(i8);
        r4.addIngredient(i7);
        r4.addIngredient(i6);
        r4.addIngredient(i5);

        r5 = new Recipe("ingefærdskage", 4, "skrald infefæren og bland dem i kagen");
        r5.addIngredient(i1);
        r5.addIngredient(i3);
        r5.addIngredient(i6);
        r5.addIngredient(i7);
        r5.addIngredient(i8);

        r6 = new Recipe("gulerodskage", 7, "skrald gulerødderne, riv dem og bland dem i kagedejen");
        r6.addIngredient(i2);
        r6.addIngredient(i5);
        r6.addIngredient(i8);
        r6.addIngredient(i10);
        r6.addIngredient(i13);

        r7 = new Recipe("coldslaw", 2, "skrald gulerødderne, riv dem og bland dem med creme");
        r7.addIngredient(i1);
        r7.addIngredient(i2);
        r7.addIngredient(i10);
        r7.addIngredient(i13);
        r7.addIngredient(i12);

        w1 = new WeekMenuPlan(1, 2020);
        w1.addRecipe(r1);
        w1.addRecipe(r2);
        w1.addRecipe(r3);
        w1.addRecipe(r4);
        w1.addRecipe(r5);
        w1.addRecipe(r6);
        w1.addRecipe(r7);

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
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRecipeFacade method, of class RecipeFacade.
     */
//    @Test
//    public void testGetRecipeFacade() {
//        System.out.println("getRecipeFacade");
//        EntityManagerFactory _emf = null;
//        RecipeFacade expResult = null;
//        RecipeFacade result = RecipeFacade.getRecipeFacade(_emf);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    
        /**
     * Test of GetAllWeekMenuPlans method, of class RecipeFacade.
     */
    @Test
    public void testGetAllWeekMenuPlans() {
        System.out.println("GetAllWeekMenuPlans");
       
        
       
       
        int result = facade.getAllWeekeMenuPlans().size();
        
        
      
        assertTrue(result == 1);

        

    }
    /**
     * Test of getAllRecipes method, of class RecipeFacade.
     */
    @Test
    public void testGetAllRecipes() {
        System.out.println("getAllRecipes");

        int amountafRecipes = facade.getAllRecipes().size();
        assertEquals(7, amountafRecipes);

    }


    /**
     * Test of isInStorage method, of class RecipeFacade.
     */
    @Test
    public void testIsInStorage() {
        System.out.println("isInStorage");
        String result = facade.isInStorage(r1.getName());
      
        assertEquals("{\"msg\":\"true\"}", result);

    }
    
    
     /**
     * Test of addRecipe method, of class RecipeFacade.
     */
    @Test
    public void testAddRecipe() {
        System.out.println("addRecipe");
        int before = facade.getAllRecipes().size();
        
        
        Map<String, Integer> testIngredience = new HashMap<String, Integer>();
        testIngredience.put("mørkchokolade", 400);
        testIngredience.put("hvedemel", 100);
         testIngredience.put("smør", 700);
          testIngredience.put("vaniljepulver", 600);

        facade.addRecipe("TestRecipe", "test description", 3, testIngredience);
        
         int after = facade.getAllRecipes().size();
      
        assertTrue(before +1 == after);

        

    }
    
     /**
     * Test of AddWeekMenuPlan method, of class RecipeFacade.
     */
    @Test
    public void testAddWeekMenuPlan() {
        System.out.println("AddWeekMenuPlan");
        int before = facade.getAllWeekeMenuPlans().size();
        
        String[] recipes = {"chokolade bananer","banan brød","flødecreme","ingefærdskage","gulerodskage","coldslaw", "chocolade kage", "23","2021"};
       
        facade.addWeekPlan(recipes);
        
         int after = facade.getAllWeekeMenuPlans().size();
      
        assertTrue(before +1 == after);

    }
    
//      /**
//     * Test of DeleteRecipe method, of class RecipeFacade.
//     */
//    @Test
//    public void testDeleteRecipe() {
//        System.out.println("DeleteRecipe");
//        int before = facade.getAllRecipes().size();
//       
//        facade.DeleteRecipe("coldslaw");
//        
//        int after = facade.getAllRecipes().size();
//      
//        assertTrue(before -1 == after);
//
//    }
    
}
