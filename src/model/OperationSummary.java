/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author iftekher
 */
public class OperationSummary {
    private String component;
    private double smv;
    private double mpAllocation;
    private double machineQuanity;
    private double operator;
    private double helper;
    private String mcOp;
    private double im;
    private double hp;
    private double total;
    private double hundredTgt;
    private double tgt;

    public OperationSummary() {
    }

    public OperationSummary(String component, double smv, double mpAllocation, double machineQuanity, double operator, double helper, String mcOp, double im, double hp, double total, double hundredTgt, double tgt) {
        this.component = component;
        this.smv = smv;
        this.mpAllocation = mpAllocation;
        this.machineQuanity = machineQuanity;
        this.operator = operator;
        this.helper = helper;
        this.mcOp = mcOp;
        this.im = im;
        this.hp = hp;
        this.total = total;
        this.hundredTgt = hundredTgt;
        this.tgt = tgt;
    }

    public String getComponent() {
        return component;
    }

    public double getSmv() {
        return smv;
    }

    public double getMpAllocation() {
        return mpAllocation;
    }

    public double getMachineQuanity() {
        return machineQuanity;
    }

    public double getOperator() {
        return operator;
    }

    public double getHelper() {
        return helper;
    }

    public String getMcOp() {
        return mcOp;
    }

    public double getIm() {
        return im;
    }

    public double getHp() {
        return hp;
    }

    public double getTotal() {
        return total;
    }

    public double getHundredTgt() {
        return hundredTgt;
    }

    public double getTgt() {
        return tgt;
    }

    @Override
    public String toString() {
        return "OperationSummary{" + "component=" + component + ", smv=" + smv + ", mpAllocation=" + mpAllocation + ", machineQuanity=" + machineQuanity + ", operator=" + operator + ", helper=" + helper + ", mcOp=" + mcOp + ", im=" + im + ", hp=" + hp + ", total=" + total + ", hundredTgt=" + hundredTgt + ", tgt=" + tgt + '}';
    }
    
}
