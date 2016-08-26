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
public class FabricConsumptionComponents {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private String component;
    private double value;
    private double allowance;

    public FabricConsumptionComponents() {
    }

    public FabricConsumptionComponents(int sl, String component, double value, double allowance) {
        this.sl = sl;
        this.component = component;
        this.value = value;
        this.allowance = allowance;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return "FabricConsumptionComponents{" + "sl=" + sl + ", component=" + component + ", value=" + value + ", allowance=" + allowance + '}';
    }
    
}
