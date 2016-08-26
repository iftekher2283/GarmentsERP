/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author iftekher
 */
@Entity
public class CostingAccessories {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    @OneToMany
    private List<CostingAccessoriesItem> accessoriesItems;
    @Transient
    private double cost;

    public CostingAccessories() {
    }

    public CostingAccessories(int sl, List<CostingAccessoriesItem> accessoriesItems) {
        this.sl = sl;
        this.accessoriesItems = accessoriesItems;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public List<CostingAccessoriesItem> getAccessoriesItems() {
        return accessoriesItems;
    }

    public void setAccessoriesItems(List<CostingAccessoriesItem> accessoriesItems) {
        this.accessoriesItems = accessoriesItems;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CostingAccessories{" + "sl=" + sl + ", accessoriesItems=" + accessoriesItems + ", cost=" + cost + '}';
    }
    
}
