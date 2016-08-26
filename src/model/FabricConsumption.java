/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class FabricConsumption {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private double fabricGsm;
    private double wastage;
    @OneToMany
    private List<FabricConsumptionComponents> components;
    @Transient
    private double consumptionPerDozen;
    @Transient
    private double consumptionPerPiece;
    @Transient
    private double totalComponentLength = 0;
    @Transient
    private double totalComponentOther = 0;

    public FabricConsumption() {
        components = new ArrayList<>();
        totalComponentLength = 0;
        totalComponentOther = 0;
    }

    public FabricConsumption(int sl, double fabricGsm, double wastage) {
        this.sl = sl;
        this.fabricGsm = fabricGsm;
        this.wastage = wastage;
        components = new ArrayList<>();
        totalComponentLength = 0;
        totalComponentOther = 0;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getFabricGsm() {
        return fabricGsm;
    }

    public void setFabricGsm(double fabricGsm) {
        this.fabricGsm = fabricGsm;
    }

    public double getWastage() {
        return wastage;
    }

    public void setWastage(double wastage) {
        this.wastage = wastage;
    }

    public List<FabricConsumptionComponents> getComponents() {
        return components;
    }

    public void setComponents(List<FabricConsumptionComponents> components) {
        this.components = components;
    }

    public double getConsumptionPerDozen() {
        totalComponentLength = 0;
        totalComponentOther = 0;
        for(int i = 0; i< components.size(); i++){
            if(components.get(i).getComponent().contains("Length")){
                totalComponentLength = totalComponentLength + components.get(i).getValue() + components.get(i).getAllowance();
            }
            else{
                totalComponentOther = totalComponentOther + components.get(i).getValue() + components.get(i).getAllowance();
            }
        }
        consumptionPerDozen = ((totalComponentLength * totalComponentOther * 2 * fabricGsm * 12) / 10000000) + (wastage / 100);
        return consumptionPerDozen;
    }

    public void setConsumptionPerDozen(double consumptionPerDozen) {
        this.consumptionPerDozen = consumptionPerDozen;
    }

    public double getConsumptionPerPiece() {
        totalComponentLength = 0;
        totalComponentOther = 0;
        for(int i = 0; i < components.size(); i++){
            if(components.get(i).getComponent().contains("Length")){
                totalComponentLength = totalComponentLength + components.get(i).getValue() + components.get(i).getAllowance();
            }
            else{
                totalComponentOther = totalComponentOther + components.get(i).getValue() + components.get(i).getAllowance();
            }
        }
        consumptionPerDozen = ((totalComponentLength * totalComponentOther * 2 * fabricGsm * 12) / 10000000) + (wastage / 100);
        consumptionPerPiece = consumptionPerDozen / 12;
        return consumptionPerPiece;
    }

    public void setConsumptionPerPiece(double consumptionPerPiece) {
        this.consumptionPerPiece = consumptionPerPiece;
    }
    
    public void addConsumptionComponent(FabricConsumptionComponents component){
        components.add(component);
    }
    
    public void removeConsumptionComponent(FabricConsumptionComponents component){
        components.remove(component);
    }
    
    @Override
    public String toString() {
        return "FabricConsumption{" + "sl=" + sl + ", fabricGsm=" + fabricGsm + ", wastage=" + wastage + ", components=" + components + ", consumptionPerDozen=" + consumptionPerDozen + ", consumptionPerPiece=" + consumptionPerPiece + '}';
    }
    
    
}
