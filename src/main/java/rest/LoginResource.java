package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DTO.RecipeDTO;

import DTO.WeekMenuPlanDTO;
import entities.User;

import facades.RecipeFacade;
import java.util.List;

import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author
 */
@Path("info")
public class LoginResource {

     private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final RecipeFacade RF = RecipeFacade.getRecipeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            List<User> users = em.createQuery("select user from User user").getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }
    
     //gets all recipes
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allRecipes")
    @RolesAllowed("user")
    public Set<RecipeDTO> allRecipes() {

            Set<RecipeDTO> recipes = RF.getAllRecipes();
            return recipes;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("storecheck/{name}")
    @RolesAllowed("user")
    public String isAllIngredienceInStore(@PathParam("name") String name) {

            return RF.isInStorage(name);
    }
    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("addRecipe")
//  //  @RolesAllowed("user")
//    public void addRecipe(String name) {
//        
//      
//    }
//    
    
       @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addWeekplan")
    @RolesAllowed("user")
    public String addWeekplan(String[] name) {
        
       
        RF.addWeekPlan(name);
        return "{\"msg\": \"ugeplanen blev gemt\"}";
      
    }
    
    @GET
  
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allWeekDayPlans")
    @RolesAllowed("admin")
    public Set<WeekMenuPlanDTO> allWeekplan() {
        
       
        return RF.getAllWeekeMenuPlans();
      
      
    }

    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("populate")
    public String populate() {

            return RF.populate();

    }
}
