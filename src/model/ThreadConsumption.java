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
public class ThreadConsumption {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private double wastage;
    @OneToMany
    private List<ThreadConsumptionOperation> operations;
    @Transient
    private double threadConsumption;

    public ThreadConsumption() {
        operations = new ArrayList<>();
    }

    public ThreadConsumption(int sl, double wastage) {
        this.sl = sl;
        this.wastage = wastage;
        operations = new ArrayList<>();
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getWastage() {
        return wastage;
    }

    public void setWastage(double wastage) {
        this.wastage = wastage;
    }

    public List<ThreadConsumptionOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<ThreadConsumptionOperation> operations) {
        this.operations = operations;
    }

    public double getThreadConsumption() {
        threadConsumption = 0;
        for(int i = 0; i < operations.size(); i++){
            operations.get(i).setEstimatedThreadConsumption(operations.get(i).getInitialConsumption() + ((operations.get(i).getInitialConsumption() * wastage) / 100));
            threadConsumption = threadConsumption + operations.get(i).getEstimatedThreadConsumption();
        }
        threadConsumption = threadConsumption / 100;
        return threadConsumption;
    }

    public void setThreadConsumption(double threadConsumption) {
        this.threadConsumption = threadConsumption;
    }
    
    public void addConsumptionOperation(ThreadConsumptionOperation operation){
        operations.add(operation);
    }
    
    public void removeConsumptionOperation(ThreadConsumptionOperation operation){
        operations.remove(operation);
    }
    
    @Override
    public String toString() {
        return "ThreadConsumption{" + "sl=" + sl + ", wastage=" + wastage + ", operations=" + operations + ", threadConsumption=" + threadConsumption + '}';
    }
    
}
