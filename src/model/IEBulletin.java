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

/**
 *
 * @author iftekher
 */
@Entity
public class IEBulletin {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private int orderId;
    @OneToMany
    private List<BulletinOperation> bulletinOperations;
    private double planMP;
    private double pitchTime;
    private double ucl;
    private double lcl;
    private int targetEFF;
    private int indTargetEFF;
    private int workHours;
    private int workMinutes;
    private int planTagHr;

    public IEBulletin() {
    }

    public IEBulletin(int sl, int orderId, List<BulletinOperation> operationDetails, double planMP, double pitchTime, double ucl, double lcl, int targetEFF, int indTargetEFF, int workHours, int workMinutes, int planTagHr) {
        this.sl = sl;
        this.orderId = orderId;
        this.bulletinOperations = operationDetails;
        this.planMP = planMP;
        this.pitchTime = pitchTime;
        this.ucl = ucl;
        this.lcl = lcl;
        this.targetEFF = targetEFF;
        this.indTargetEFF = indTargetEFF;
        this.workHours = workHours;
        this.workMinutes = workMinutes;
        this.planTagHr = planTagHr;
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

    public List<BulletinOperation> getOperationDetails() {
        return bulletinOperations;
    }

    public void setOperationDetails(List<BulletinOperation> operationDetails) {
        this.bulletinOperations = operationDetails;
    }

    public double getPlanMP() {
        return planMP;
    }

    public void setPlanMP(double planMP) {
        this.planMP = planMP;
    }

    public double getPitchTime() {
        return pitchTime;
    }

    public void setPitchTime(double pitchTime) {
        this.pitchTime = pitchTime;
    }

    public double getUcl() {
        return ucl;
    }

    public void setUcl(double ucl) {
        this.ucl = ucl;
    }

    public double getLcl() {
        return lcl;
    }

    public void setLcl(double lcl) {
        this.lcl = lcl;
    }

    public int getTargetEFF() {
        return targetEFF;
    }

    public void setTargetEFF(int targetEFF) {
        this.targetEFF = targetEFF;
    }

    public int getIndTargetEFF() {
        return indTargetEFF;
    }

    public void setIndTargetEFF(int indTargetEFF) {
        this.indTargetEFF = indTargetEFF;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getWorkMinutes() {
        return workMinutes;
    }

    public void setWorkMinutes(int workMinutes) {
        this.workMinutes = workMinutes;
    }

    public int getPlanTagHr() {
        return planTagHr;
    }

    public void setPlanTagHr(int planTagHr) {
        this.planTagHr = planTagHr;
    }
    
    public void addBulletinOperation(BulletinOperation operation){
        bulletinOperations.add(operation);
    }
    
    public void removeBulletinOperation(BulletinOperation operation){
        bulletinOperations.remove(operation);
    }
    
    @Override
    public String toString() {
        return "IEBulletin{" + "sl=" + sl + ", orderId=" + orderId + ", operationDetails=" + bulletinOperations + ", planMP=" + planMP + ", pitchTime=" + pitchTime + ", ucl=" + ucl + ", lcl=" + lcl + ", targetEFF=" + targetEFF + ", indTargetEFF=" + indTargetEFF + ", workHours=" + workHours + ", workMinutes=" + workMinutes + ", planTagHr=" + planTagHr + '}';
    }
}
