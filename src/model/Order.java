/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author iftekher
 */
@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int orderId;
    private String orderName;
    private String buyerName;
    private String buyerRequirements;
    private String description;
    private String priority;
    private int quantity;
    private String category;
    private double smv;
    private String orderDate;
    private String deliveryDate;
    private double cost;
    private String currency;
    private String internalComments;
    private String addedBy;
    private String lastUpdatedBy;

    public Order() {
    }

    public Order(String orderName, String buyerName, String buyerRequirements, String description, String priority, int quantity, String category, double smv, String orderDate, String deliveryDate, double cost, String currency, String internalComments, String addedBy, String lastUpdatedBy) {
        this.orderName = orderName;
        this.buyerName = buyerName;
        this.buyerRequirements = buyerRequirements;
        this.description = description;
        this.priority = priority;
        this.quantity = quantity;
        this.category = category;
        this.smv = smv;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.cost = cost;
        this.currency = currency;
        this.internalComments = internalComments;
        this.addedBy = addedBy;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getBuyerRequirements() {
        return buyerRequirements;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getSmv() {
        return smv;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public double getCost() {
        return cost;
    }

    public String getCurrency() {
        return currency;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setBuyerRequirements(String buyerRequirements) {
        this.buyerRequirements = buyerRequirements;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSmv(double smv) {
        this.smv = smv;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderName=" + orderName + ", buyerName=" + buyerName + ", buyerRequirements=" + buyerRequirements + ", description=" + description + ", priority=" + priority + ", quantity=" + quantity + ", category=" + category + ", smv=" + smv + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", cost=" + cost + ", currency=" + currency + ", internalComments=" + internalComments + ", addedBy=" + addedBy + ", lastUpdatedBy=" + lastUpdatedBy + '}';
    }

    
}
