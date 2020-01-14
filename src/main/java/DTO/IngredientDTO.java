/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Ingredient;

/**
 *
 * @author benja
 */
public class IngredientDTO {
    
    private int amount;

    
    private String itemName;
    private Long itemId;

    public IngredientDTO(Ingredient ingredient) {
        this.amount = ingredient.getAmount();
        this.itemName = ingredient.getItem().getName();
        this.itemId = ingredient.getItem().getId();
    }
    public int getAmount() {
        return amount;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getItemId() {
        return itemId;
    }
    
}
