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
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author iftekher
 */
@Entity
public class Costing {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private int orderId;
    private String date;
    private String size;
    private int sizeQuantity;
    private double fabricGsm;
    private String fabrication;
    @OneToOne
    private CostingYarn costingYarn;
    @OneToOne
    private CostingKnitting costingKnitting;
    @OneToOne
    private CostingDyeing costingDyeing;
    @OneToOne
    private CostingThread costingThread;
    @OneToOne
    private CostingOthers costingOther;
    @Transient
    private double totalFabAndProcPerDozen;
    @OneToOne
    private CostingAccessories costingAccessories;
    @Transient
    private double accessoriesCost;
    private double labTestCost;
    @Transient
    private double totalCostPerDozen;
    @Transient
    private double costOfMakingIncProfitPerDozen;
    @Transient
    private double commercialCostPerDozen;
    @Transient
    private double totalPricePerDozen;
    @Transient
    private double fobPricePerDozen;
    private String calculatedBy;
    private String lastUpdatedBy;
    private int isDeleted;

    public Costing() {
    }

    public Costing(int sl, int orderId, String date, String size, int sizeQuantity, double fabricGsm, String fabrication, CostingYarn costingYarn, CostingKnitting costingKnitting, CostingDyeing costingDyeing, CostingThread costingThread, CostingOthers costingOther, CostingAccessories costingAccessories, double labTestCost, String calculatedBy, String lastUpdatedBy) {
        this.sl = sl;
        this.orderId = orderId;
        this.date = date;
        this.size = size;
        this.sizeQuantity = sizeQuantity;
        this.fabricGsm = fabricGsm;
        this.fabrication = fabrication;
        this.costingYarn = costingYarn;
        this.costingKnitting = costingKnitting;
        this.costingDyeing = costingDyeing;
        this.costingThread = costingThread;
        this.costingOther = costingOther;
        this.costingAccessories = costingAccessories;
        this.labTestCost = labTestCost;
        this.calculatedBy = calculatedBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.isDeleted = 0;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSizeQuantity() {
        return sizeQuantity;
    }

    public void setSizeQuantity(int sizeQuantity) {
        this.sizeQuantity = sizeQuantity;
    }

    public double getFabricGsm() {
        return fabricGsm;
    }

    public void setFabricGsm(double fabricGsm) {
        this.fabricGsm = fabricGsm;
    }

    public String getFabrication() {
        return fabrication;
    }

    public void setFabrication(String fabrication) {
        this.fabrication = fabrication;
    }

    public CostingYarn getCostingYarn() {
        return costingYarn;
    }

    public void setCostingYarn(CostingYarn costingYarn) {
        this.costingYarn = costingYarn;
    }

    public CostingKnitting getCostingKnitting() {
        return costingKnitting;
    }

    public void setCostingKnitting(CostingKnitting costingKnitting) {
        this.costingKnitting = costingKnitting;
    }

    public CostingDyeing getCostingDyeing() {
        return costingDyeing;
    }

    public void setCostingDyeing(CostingDyeing costingDyeing) {
        this.costingDyeing = costingDyeing;
    }

    public CostingThread getCostingThread() {
        return costingThread;
    }

    public void setCostingThread(CostingThread costingThread) {
        this.costingThread = costingThread;
    }

    public CostingOthers getCostingOther() {
        return costingOther;
    }

    public void setCostingOther(CostingOthers costingOther) {
        this.costingOther = costingOther;
    }

    public CostingAccessories getCostingAccessories() {
        return costingAccessories;
    }

    public void setCostingAccessories(CostingAccessories costingAccessories) {
        this.costingAccessories = costingAccessories;
    }

    public double getAccessoriesCost() {
        accessoriesCost = costingAccessories.getCost();
        return accessoriesCost;
    }

    public void setAccessoriesCost(double accessoriesCost) {
        this.accessoriesCost = accessoriesCost;
    }

    public double getLabTestCost() {
        return labTestCost;
    }

    public void setLabTestCost(double labTestCost) {
        this.labTestCost = labTestCost;
    }

    public double getTotalCostPerDozen() {
        totalCostPerDozen = getTotalFabAndProcPerDozen() + getAccessoriesCost() + labTestCost;
        return totalCostPerDozen;
    }

    public void setTotalCostPerDozen(double totalCostPerDozen) {
        this.totalCostPerDozen = totalCostPerDozen;
    }

    public double getCostOfMakingIncProfitPerDozen() {
        costOfMakingIncProfitPerDozen = getTotalCostPerDozen() + ((getTotalCostPerDozen() * 12)/100);
        return costOfMakingIncProfitPerDozen;
    }

    public void setCostOfMakingIncProfitPerDozen(double costOfMakingIncProfitPerDozen) {
        this.costOfMakingIncProfitPerDozen = costOfMakingIncProfitPerDozen;
    }

    public double getCommercialCostPerDozen() {
        commercialCostPerDozen = ((getTotalCostPerDozen() * 4)/100);
        return commercialCostPerDozen;
    }

    public void setCommercialCostPerDozen(double commercialCostPerDozen) {
        this.commercialCostPerDozen = commercialCostPerDozen;
    }

    public double getTotalPricePerDozen() {
        totalPricePerDozen = getTotalCostPerDozen() + getCostOfMakingIncProfitPerDozen() + getCommercialCostPerDozen();
        return totalPricePerDozen;
    }

    public void setTotalPricePerDozen(double totalPricePerDozen) {
        this.totalPricePerDozen = totalPricePerDozen;
    }

    public double getFobPricePerDozen() {
        fobPricePerDozen = getTotalPricePerDozen() + ((getTotalCostPerDozen() * 10)/100);
        return fobPricePerDozen;
    }

    public void setFobPricePerDozen(double fobPricePerDozen) {
        this.fobPricePerDozen = fobPricePerDozen;
    }

    public String getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(String calculatedBy) {
        this.calculatedBy = calculatedBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public double getTotalFabAndProcPerDozen() {
        totalFabAndProcPerDozen = costingYarn.getCost() + costingKnitting.getCost() + costingDyeing.getCost() + costingThread.getCost() + costingOther.getCost();
        return totalFabAndProcPerDozen;
    }

    public void setTotalFabAndProcPerDozen(double totalFabAndProcPerDozen) {
        this.totalFabAndProcPerDozen = totalFabAndProcPerDozen;
    }
    
    @Override
    public String toString() {
        return "Costing{" + "sl=" + sl + ", orderId=" + orderId + ", date=" + date + ", size=" + size + ", sizeQuantity=" + sizeQuantity + ", fabricGsm=" + fabricGsm + ", fabrication=" + fabrication + ", costingYarn=" + costingYarn + ", costingKnitting=" + costingKnitting + ", costingDyeing=" + costingDyeing + ", costingThread=" + costingThread + ", costingOther=" + costingOther + ", costingAccessories=" + costingAccessories + ", accessoriesCost=" + accessoriesCost + ", labTestCost=" + labTestCost + ", totalCostPerDozen=" + totalCostPerDozen + ", costOfMakingIncProfitPerDozen=" + costOfMakingIncProfitPerDozen + ", commercialCostPerDozen=" + commercialCostPerDozen + ", totalPricePerDozen=" + totalPricePerDozen + ", fobPricePerDozen=" + fobPricePerDozen + ", calculatedBy=" + calculatedBy + ", lastUpdatedBy=" + lastUpdatedBy + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
