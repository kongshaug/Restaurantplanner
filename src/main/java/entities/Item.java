/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author benja
 */
@Entity
@NamedQuery(name = "Item.deleteAllRows", query = "DELETE from Item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double pricePrKg;
    private int storageAmount;

    public Item() {
    }

    public Item(String name, double pricePrKg, int storageAmount) {
        this.name = name;
        this.pricePrKg = pricePrKg;
        this.storageAmount = storageAmount;
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

    public double getPricePrKg() {
        return pricePrKg;
    }

    public void setPricePrKg(double pricePrKg) {
        this.pricePrKg = pricePrKg;
    }

    public int getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(int storageAmount) {
        this.storageAmount = storageAmount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.pricePrKg) ^ (Double.doubleToLongBits(this.pricePrKg) >>> 32));
        hash = 71 * hash + this.storageAmount;
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
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.pricePrKg) != Double.doubleToLongBits(other.pricePrKg)) {
            return false;
        }
        if (this.storageAmount != other.storageAmount) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

  
}
