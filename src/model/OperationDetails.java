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
public class OperationDetails {
    private String component;
    private String operationDescription;
    private String mcHelp;
    private String machineCode;
    private int secondsCount;
    private double smv;
    private double requiredMp;
    private double mpAllocation;
    private double hundredTgt;
    private double machineQuantity;
    private double op;
    private double hp;
    private double im;
    private double acTgt;
    private String remarks;

    public OperationDetails() {
    }

    public OperationDetails(String component, String operationDescription, String mcHelp, String machineCode, int secondsCount, double smv, double requiredMp, double mpAllocation, double hundredTgt, double machineQuantity, double op, double hp, double im, double acTgt, String remarks) {
        this.component = component;
        this.operationDescription = operationDescription;
        this.mcHelp = mcHelp;
        this.machineCode = machineCode;
        this.secondsCount = secondsCount;
        this.smv = smv;
        this.requiredMp = requiredMp;
        this.mpAllocation = mpAllocation;
        this.hundredTgt = hundredTgt;
        this.machineQuantity = machineQuantity;
        this.op = op;
        this.hp = hp;
        this.im = im;
        this.acTgt = acTgt;
        this.remarks = remarks;
    }

    public String getComponent() {
        return component;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public String getMcHelp() {
        return mcHelp;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public int getSecondsCount() {
        return secondsCount;
    }

    public double getSmv() {
        return smv;
    }

    public double getRequiredMp() {
        return requiredMp;
    }

    public double getMpAllocation() {
        return mpAllocation;
    }

    public double getHundredTgt() {
        return hundredTgt;
    }

    public double getMachineQuantity() {
        return machineQuantity;
    }

    public double getOp() {
        return op;
    }

    public double getHp() {
        return hp;
    }

    public double getIm() {
        return im;
    }

    public double getAcTgt() {
        return acTgt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public void setMcHelp(String mcHelp) {
        this.mcHelp = mcHelp;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public void setSecondsCount(int secondsCount) {
        this.secondsCount = secondsCount;
    }

    public void setSmv(double smv) {
        this.smv = smv;
    }

    public void setRequiredMp(double requiredMp) {
        this.requiredMp = requiredMp;
    }

    public void setMpAllocation(double mpAllocation) {
        this.mpAllocation = mpAllocation;
    }

    public void setHundredTgt(double hundredTgt) {
        this.hundredTgt = hundredTgt;
    }

    public void setMachineQuantity(double machineQuantity) {
        this.machineQuantity = machineQuantity;
    }

    public void setOp(double op) {
        this.op = op;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public void setAcTgt(double acTgt) {
        this.acTgt = acTgt;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "OperationDetails{" + "component=" + component + ", operationDescription=" + operationDescription + ", mcHelp=" + mcHelp + ", machineCode=" + machineCode + ", secondsCount=" + secondsCount + ", smv=" + smv + ", requiredMp=" + requiredMp + ", mpAllocation=" + mpAllocation + ", hundredTgt=" + hundredTgt + ", machineQuantity=" + machineQuantity + ", op=" + op + ", hp=" + hp + ", im=" + im + ", acTgt=" + acTgt + ", remarks=" + remarks + '}';
    }
    
}
