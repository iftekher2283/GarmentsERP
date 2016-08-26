/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author iftekher
 */
@Entity
public class CostingAccessoriesItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private String itemName;
    private double itemCost;

    public CostingAccessoriesItem() {
    }

    public CostingAccessoriesItem(int sl, String itemName, double itemCost) {
        this.sl = sl;
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return "CostingAccessories{" + "sl=" + sl + ", itemName=" + itemName + ", itemCost=" + itemCost + '}';
    }
    
}
