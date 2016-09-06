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
public class ThreadConsumptionOperation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    private String operationName;
    private double seamLength;
    private String stitchType;
    private double ratio;
    @Transient
    private double initialConsumption;
    @Transient
    private double estimatedThreadConsumption;

    public ThreadConsumptionOperation() {
    }

    public ThreadConsumptionOperation(int sl, String operationName, double seamLength, String stitchType, double ratio, double initialConsumption, double estimatedThreadConsumption) {
        this.sl = sl;
        this.operationName = operationName;
        this.seamLength = seamLength;
        this.stitchType = stitchType;
        this.ratio = ratio;
        this.initialConsumption = initialConsumption;
        this.estimatedThreadConsumption = estimatedThreadConsumption;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public double getSeamLength() {
        return seamLength;
    }

    public void setSeamLength(double seamLength) {
        this.seamLength = seamLength;
    }

    public String getStitchType() {
        return stitchType;
    }

    public void setStitchType(String stitchType) {
        this.stitchType = stitchType;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getInitialConsumption() {
        initialConsumption = seamLength * ratio;
        return initialConsumption;
    }

    public void setInitialConsumption(double initialConsumption) {
        this.initialConsumption = initialConsumption;
    }

    public double getEstimatedThreadConsumption() {
        return estimatedThreadConsumption;
    }

    public void setEstimatedThreadConsumption(double estimatedThreadConsumption) {
        this.estimatedThreadConsumption = estimatedThreadConsumption;
    }

    @Override
    public String toString() {
        return "ThreadConsumptionOperation{" + "sl=" + sl + ", operationName=" + operationName + ", seamLength=" + seamLength + ", stitchType=" + stitchType + ", ratio=" + ratio + ", initialConsumption=" + initialConsumption + ", estimatedThreadConsumption=" + estimatedThreadConsumption + '}';
    }
    
}
