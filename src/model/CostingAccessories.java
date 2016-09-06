/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @OneToMany(
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "CostingAccessories_CostingAccessoriesItem",
            joinColumns = @JoinColumn(name = "CostingAccessories_sl"),
            inverseJoinColumns = @JoinColumn(name = "accessoriesItems_sl")
    )
    private List<CostingAccessoriesItem> accessoriesItems;
    @Transient
    private double cost;

    public CostingAccessories() {
        this.cost = 0;
    }

    public CostingAccessories(int sl, List<CostingAccessoriesItem> accessoriesItems) {
        this.sl = sl;
        this.accessoriesItems = accessoriesItems;
        this.cost = 0;
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
        cost = 0;
        for(int i = 0; i < accessoriesItems.size(); i++){
            cost = cost + accessoriesItems.get(i).getItemCost();
        }
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public void addCostingAccessoriesItem(CostingAccessoriesItem costingAccessoriesItem){
        accessoriesItems.add(costingAccessoriesItem);
    }
    
    public void removeCostingAccessoriesItem(CostingAccessoriesItem costingAccessoriesItem){
        accessoriesItems.remove(costingAccessoriesItem);
    }
    
    @Override
    public String toString() {
        return "CostingAccessories{" + "sl=" + sl + ", accessoriesItems=" + accessoriesItems + ", cost=" + cost + '}';
    }
    
}
