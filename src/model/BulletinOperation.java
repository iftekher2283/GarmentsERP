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

/**
 *
 * @author iftekher
 */
@Entity
public class BulletinOperation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String component;
    private String description;
    private String mcOrHelper;
    private String machineCode;
    private int secondsCount;
    private double requiredManpower;
    private double manpowerAllocation;
    private int hundredTarget;
    private int individualTarget;
    private double machineQuantity;
    private double operator;
    private double helper;
    private double im;
    private int acTarget;
    private String remarks;

    public BulletinOperation() {
    }

    public BulletinOperation(int id, String component, String description, String mcOrHelper, String machineCode, int secondsCount, double requiredManpower, double manpowerAllocation, int hundredTarget, int individualTarget, double machineQuantity, double operator, double helper, double im, int acTarget, String remarks) {
        this.id = id;
        this.component = component;
        this.description = description;
        this.mcOrHelper = mcOrHelper;
        this.machineCode = machineCode;
        this.secondsCount = secondsCount;
        this.requiredManpower = requiredManpower;
        this.manpowerAllocation = manpowerAllocation;
        this.hundredTarget = hundredTarget;
        this.individualTarget = individualTarget;
        this.machineQuantity = machineQuantity;
        this.operator = operator;
        this.helper = helper;
        this.im = im;
        this.acTarget = acTarget;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMcOrHelper() {
        return mcOrHelper;
    }

    public void setMcOrHelper(String mcOrHelper) {
        this.mcOrHelper = mcOrHelper;
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

    public double getRequiredManpower() {
        return requiredManpower;
    }

    public void setRequiredManpower(double requiredManpower) {
        this.requiredManpower = requiredManpower;
    }

    public double getManpowerAllocation() {
        return manpowerAllocation;
    }

    public void setManpowerAllocation(double manpowerAllocation) {
        this.manpowerAllocation = manpowerAllocation;
    }

    public int getHundredTarget() {
        return hundredTarget;
    }

    public void setHundredTarget(int hundredTarget) {
        this.hundredTarget = hundredTarget;
    }

    public int getIndividualTarget() {
        return individualTarget;
    }

    public void setIndividualTarget(int individualTarget) {
        this.individualTarget = individualTarget;
    }

    public double getMachineQuantity() {
        return machineQuantity;
    }

    public void setMachineQuantity(double machineQuantity) {
        this.machineQuantity = machineQuantity;
    }

    public double getOperator() {
        return operator;
    }

    public void setOperator(double operator) {
        this.operator = operator;
    }

    public double getHelper() {
        return helper;
    }

    public void setHelper(double helper) {
        this.helper = helper;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public int getAcTarget() {
        return acTarget;
    }

    public void setAcTarget(int acTarget) {
        this.acTarget = acTarget;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "BulletinOperation{" + "id=" + id + ", component=" + component + ", description=" + description + ", mcOrHelper=" + mcOrHelper + ", machineCode=" + machineCode + ", secondsCount=" + secondsCount + ", requiredManpower=" + requiredManpower + ", manpowerAllocation=" + manpowerAllocation + ", hundredTarget=" + hundredTarget + ", individualTarget=" + individualTarget + ", machineQuantity=" + machineQuantity + ", operator=" + operator + ", helper=" + helper + ", im=" + im + ", acTarget=" + acTarget + ", remarks=" + remarks + '}';
    }
}
