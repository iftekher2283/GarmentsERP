/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author iftekher
 */
public class IEBulletin {
    private int orderId;
    private String buyerName;
    private String orderDescription;
    private int orderQuantity;
    private int allocatedQuantity;
    private String floorNo;
    private String lineNo;
    private List<OperationDetails> operationDetails;
    private List<OperationSummary> operationSummaries;
    private double planMP;
    private double pitchTime;
    private double ucl;
    private double lcl;
    private double targetEFF;
    private double indTargetEFF;
    private double workHours;
    private double workMinutes;
    private double planTagHr;

    public IEBulletin() {
    }

    public IEBulletin(int orderId, String buyerName, String orderDescription, int orderQuantity, int allocatedQuantity, String floorNo, String lineNo, List<OperationDetails> operationDetails, List<OperationSummary> operationSummaries, double planMP, double pitchTime, double ucl, double lcl, double targetEFF, double indTargetEFF, double workHours, double workMinutes, double planTagHr) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.orderDescription = orderDescription;
        this.orderQuantity = orderQuantity;
        this.allocatedQuantity = allocatedQuantity;
        this.floorNo = floorNo;
        this.lineNo = lineNo;
        this.operationDetails = operationDetails;
        this.operationSummaries = operationSummaries;
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

    public int getOrderId() {
        return orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public int getAllocatedQuantity() {
        return allocatedQuantity;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public String getLineNo() {
        return lineNo;
    }

    public List<OperationDetails> getOperationDetails() {
        return operationDetails;
    }

    public List<OperationSummary> getOperationSummaries() {
        return operationSummaries;
    }

    public double getPlanMP() {
        return planMP;
    }

    public double getPitchTime() {
        return pitchTime;
    }

    public double getUcl() {
        return ucl;
    }

    public double getLcl() {
        return lcl;
    }

    public double getTargetEFF() {
        return targetEFF;
    }

    public double getIndTargetEFF() {
        return indTargetEFF;
    }

    public double getWorkHours() {
        return workHours;
    }

    public double getWorkMinutes() {
        return workMinutes;
    }

    public double getPlanTagHr() {
        return planTagHr;
    }
    
    private void addOperationDetils(OperationDetails operationDetail){
        operationDetails.add(operationDetail);
    }
}
