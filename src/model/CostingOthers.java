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
import javax.persistence.Transient;

/**
 *
 * @author iftekher
 */
@Entity
public class CostingOthers {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private double consumption;
    private double unitPrice;
    @Transient
    private double cost;

    public CostingOthers() {
        this.cost = 0;
    }
    
    public CostingOthers(int sl, double consumption, double unitPrice) {
        this.sl = sl;
        this.consumption = consumption;
        this.unitPrice = unitPrice;
        this.cost = 0;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getCost() {
        cost = consumption * unitPrice;
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CostingYarn{" + "sl=" + sl + ", consumption=" + consumption + ", unitPrice=" + unitPrice + ", cost=" + cost + '}';
    }
}
