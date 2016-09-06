/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class FabricConsumption {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private double fabricGsm;
    private double wastage;
    @OneToMany(
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "FabricConsumption_FabricConsumptionComponents",
            joinColumns = @JoinColumn(name = "FabricConsumption_sl"),
            inverseJoinColumns = @JoinColumn(name = "components_sl")
    )
    private List<FabricConsumptionComponents> components;
    @Transient
    private double consumptionPerDozen;
    @Transient
    private double consumptionPerPiece;

    public FabricConsumption() {
        components = new ArrayList<>();
    }

    public FabricConsumption(int sl, double fabricGsm, double wastage) {
        this.sl = sl;
        this.fabricGsm = fabricGsm;
        this.wastage = wastage;
        components = new ArrayList<>();
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
    
    public List<FabricConsumptionComponents> getComponents(){
        return components;
    }
    
//    public List<FabricConsumptionComponents> getComponents(List<FabricConsumptionComponents> fabricConsumptionComponents, List<FabricConsumption_FabricConsumptionComponents> componentSls) {
//        for(int i = 0; i < fabricConsumptionComponents.size(); i++){
//            if(componentSls.get(i).getFabricConsumption_sl() == sl && componentSls.get(i).getFabricConsumption_sl() == fabricConsumptionComponents.get(i).getSl()){
//                this.components.add(fabricConsumptionComponents.get(i));
//            }
//        }
//        return components;
//    }

    public void setComponents(List<FabricConsumptionComponents> components) {
        this.components = components;
    }

    public double getConsumptionPerDozen() {
        double totalComponentLength = 0;
        double totalComponentOther = 0;
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
        double totalComponentLength = 0;
        double totalComponentOther = 0;
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
