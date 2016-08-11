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
public class BulletinOperationDetails {
    private int sl;
    private String component;
    private String operationDescription;
    private String mcHelp;
    private String machineCode;
    private int secondsCount;
    private double smv;
    private double requiredMp;
    private double mpAllocation;
    private int hundredTgt;
    private int indTgt;
    private double machineQuantity;
    private double op;
    private double hp;
    private double im;
    private double acTgt;
    private String remarks;
    private int mcOrOP;
    private double total;
    
    public BulletinOperationDetails() {
    }

    public BulletinOperationDetails(int sl, String component, String operationDescription, String mcHelp, String machineCode, int secondsCount, double requiredMp, double mpAllocation, int hundredTgt, int indTgt, double machineQuantity, double op, double hp, double im, double acTgt, String remarks) {
        this.sl = sl;
        this.component = component;
        this.operationDescription = operationDescription;
        this.mcHelp = mcHelp;
        this.machineCode = machineCode;
        this.secondsCount = secondsCount;
        this.smv = this.secondsCount / 60;
        this.requiredMp = requiredMp;
        this.mpAllocation = mpAllocation;
        this.hundredTgt = hundredTgt;
        this.indTgt = indTgt;
        this.machineQuantity = machineQuantity;
        this.op = op;
        this.hp = hp;
        this.im = im;
        this.acTgt = acTgt;
        this.remarks = remarks;
        this.mcOrOP = 0;
        this.total = 0;
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

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public String getMcHelp() {
        return mcHelp;
    }

    public void setMcHelp(String mcHelp) {
        this.mcHelp = mcHelp;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public int getSecondsCount() {
        return secondsCount;
    }

    public void setSecondsCount(int secondsCount) {
        this.secondsCount = secondsCount;
    }

    public double getSmv() {
        return smv;
    }

    public void setSmv(double smv) {
        this.smv = smv;
    }

    public double getRequiredMp() {
        return requiredMp;
    }

    public void setRequiredMp(double requiredMp) {
        this.requiredMp = requiredMp;
    }

    public double getMpAllocation() {
        return mpAllocation;
    }

    public void setMpAllocation(double mpAllocation) {
        this.mpAllocation = mpAllocation;
    }

    public int getHundredTgt() {
        return hundredTgt;
    }

    public void setHundredTgt(int hundredTgt) {
        this.hundredTgt = hundredTgt;
    }

    public int getIndTgt() {
        return indTgt;
    }

    public void setIndTgt(int indTgt) {
        this.indTgt = indTgt;
    }
    
    public double getMachineQuantity() {
        return machineQuantity;
    }

    public void setMachineQuantity(double machineQuantity) {
        this.machineQuantity = machineQuantity;
    }

    public double getOp() {
        return op;
    }

    public void setOp(double op) {
        this.op = op;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getAcTgt() {
        return acTgt;
    }

    public void setAcTgt(double acTgt) {
        this.acTgt = acTgt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getMcOrOP() {
        return mcOrOP;
    }

    public void setMcOrOP(int mcOrOP) {
        this.mcOrOP = mcOrOP;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "BulletinOperationDetails{" + "sl=" + sl + ", component=" + component + ", operationDescription=" + operationDescription + ", mcHelp=" + mcHelp + ", machineCode=" + machineCode + ", secondsCount=" + secondsCount + ", smv=" + smv + ", requiredMp=" + requiredMp + ", mpAllocation=" + mpAllocation + ", hundredTgt=" + hundredTgt + ", machineQuantity=" + machineQuantity + ", op=" + op + ", hp=" + hp + ", im=" + im + ", acTgt=" + acTgt + ", remarks=" + remarks + '}';
    }
    
}
