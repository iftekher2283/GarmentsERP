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
import javax.persistence.OneToOne;

/**
 *
 * @author iftekher
 */
@Entity
public class Consumption {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private int orderId;
    private String date;
    private String size;
    private int sizeQuantity;
    @OneToOne
    private FabricConsumption fabricConsumption;
    @OneToOne
    private ThreadConsumption threadConsumption;
    private String calculatedBy;
    private String lastUpdatedBy;
    
    public Consumption() {
    }

    public Consumption(int sl, int orderId, String date, String size, int sizeQuantity, FabricConsumption fabricConsumption, ThreadConsumption threadConsumption, String calculatedBy, String lastUpdatedBy) {
        this.sl = sl;
        this.orderId = orderId;
        this.date = date;
        this.size = size;
        this.sizeQuantity = sizeQuantity;
        this.fabricConsumption = fabricConsumption;
        this.threadConsumption = threadConsumption;
        this.calculatedBy = calculatedBy;
        this.lastUpdatedBy = lastUpdatedBy;
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

    public FabricConsumption getFabricConsumption() {
        return fabricConsumption;
    }

    public void setFabricConsumption(FabricConsumption fabricConsumption) {
        this.fabricConsumption = fabricConsumption;
    }

    public ThreadConsumption getThreadConsumption() {
        return threadConsumption;
    }

    public void setThreadConsumption(ThreadConsumption threadConsumption) {
        this.threadConsumption = threadConsumption;
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

    @Override
    public String toString() {
        return "Consumption{" + "sl=" + sl + ", orderId=" + orderId + ", date=" + date + ", size=" + size + ", sizeQuantity=" + sizeQuantity + ", fabricConsumption=" + fabricConsumption + ", threadConsumption=" + threadConsumption + ", calculatedBy=" + calculatedBy + ", lastUpdatedBy=" + lastUpdatedBy + '}';
    }
    
}
