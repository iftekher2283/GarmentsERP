/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author iftekher
 */
@Entity
@Table(name="tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="`orderId`")
    private int orderId;
    @Column(name="`orderName`")
    private String orderName;
    @Column(name="`buyerName`")
    private String buyerName;
    @Column(name="`buyerRequirements`")
    private String buyerRequirements;
    @Column(name="`orderDescription`")
    private String orderDescription;
    @Column(name="`orderPriority`")
    private String orderPriority;
    @Column(name="`orderQuantity`")
    private int orderQuantity;
    @Column(name="`orderFloorNo`")
    private String orderFloorNo;
    @Column(name="`orderLineNo`")
    private String orderLineNo;
    @Column(name="`orderCategory`")
    private String orderCategory;
    @Column(name="`orderSmv`")
    private double orderSmv;
    @Column(name="`orderDate`")
    private String orderDate;
    @Column(name="`orderDeliveryDate`")
    private String orderDeliveryDate;
    @Column(name="`orderCost`")
    private double orderCost;
    @Column(name="`orderCurrency`")
    private String orderCurrency;
    @Column(name="`orderInternalComments`")
    private String orderInternalComments;
    @Column(name="`orderAddedBy`")
    private String orderAddedBy;
    @Column(name="`orderLastUpdatedBy`")
    private String orderLastUpdatedBy;
    @Column(name="`orderIsDeleted`")
    private int orderIsDeleted;

    public Order() {
    }

    public Order(int orderId, String orderName, String buyerName, String buyerRequirements, String orderDescription, String orderPriority, int orderQuantity, String orderFloorNo, String orderLineNo, String orderCategory, double orderSmv, String orderDate, String orderDeliveryDate, double orderCost, String orderCurrency, String orderInternalComments, String orderAddedBy, String orderLastUpdatedBy) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.buyerName = buyerName;
        this.buyerRequirements = buyerRequirements;
        this.orderDescription = orderDescription;
        this.orderPriority = orderPriority;
        this.orderQuantity = orderQuantity;
        this.orderFloorNo = orderFloorNo;
        this.orderLineNo = orderLineNo;
        this.orderCategory = orderCategory;
        this.orderSmv = orderSmv;
        this.orderDate = orderDate;
        this.orderDeliveryDate = orderDeliveryDate;
        this.orderCost = orderCost;
        this.orderCurrency = orderCurrency;
        this.orderInternalComments = orderInternalComments;
        this.orderAddedBy = orderAddedBy;
        this.orderLastUpdatedBy = orderLastUpdatedBy;
        this.orderIsDeleted = 0;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerRequirements() {
        return buyerRequirements;
    }

    public void setBuyerRequirements(String buyerRequirements) {
        this.buyerRequirements = buyerRequirements;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderFloorNo() {
        return orderFloorNo;
    }

    public void setOrderFloorNo(String orderFloorNo) {
        this.orderFloorNo = orderFloorNo;
    }

    public String getOrderLineNo() {
        return orderLineNo;
    }

    public void setOrderLineNo(String orderLineNo) {
        this.orderLineNo = orderLineNo;
    }

    public String getOrderCategory() {
        return orderCategory;
    }

    public void setOrderCategory(String orderCategory) {
        this.orderCategory = orderCategory;
    }

    public double getOrderSmv() {
        return orderSmv;
    }

    public void setOrderSmv(double orderSmv) {
        this.orderSmv = orderSmv;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    public void setOrderDeliveryDate(String orderDeliveryDate) {
        this.orderDeliveryDate = orderDeliveryDate;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getOrderInternalComments() {
        return orderInternalComments;
    }

    public void setOrderInternalComments(String orderInternalComments) {
        this.orderInternalComments = orderInternalComments;
    }

    public String getOrderAddedBy() {
        return orderAddedBy;
    }

    public void setOrderAddedBy(String orderAddedBy) {
        this.orderAddedBy = orderAddedBy;
    }

    public String getOrderLastUpdatedBy() {
        return orderLastUpdatedBy;
    }

    public void setOrderLastUpdatedBy(String orderLastUpdatedBy) {
        this.orderLastUpdatedBy = orderLastUpdatedBy;
    }

    public int getOrderIsDeleted() {
        return orderIsDeleted;
    }

    public void setOrderIsDeleted(int orderIsDeleted) {
        this.orderIsDeleted = orderIsDeleted;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderName=" + orderName + ", buyerName=" + buyerName + ", buyerRequirements=" + buyerRequirements + ", orderDescription=" + orderDescription + ", orderPriority=" + orderPriority + ", orderQuantity=" + orderQuantity + ", orderFloorNo=" + orderFloorNo + ", orderLineNo=" + orderLineNo + ", orderCategory=" + orderCategory + ", orderSmv=" + orderSmv + ", orderDate=" + orderDate + ", orderDeliveryDate=" + orderDeliveryDate + ", orderCost=" + orderCost + ", orderCurrency=" + orderCurrency + ", orderInternalComments=" + orderInternalComments + ", orderAddedBy=" + orderAddedBy + ", orderLastUpdatedBy=" + orderLastUpdatedBy + '}';
    }
    
}
