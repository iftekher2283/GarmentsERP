/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author iftekher
 */
@Entity
public class Buyer {
    @Id
    private String buyerName;
    private String officeSiteName;
    private String companyBrandName;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String areaCode;
    private String addedBy;
    private String updatedBy;
    private int isDeleted;

    public Buyer() {
    }

    public Buyer(String buyerName, String officeSiteName, String companyBrandName, String phone, String email, String address, String city, String state, String zipCode, String areaCode, String addedBy, String updatedBy) {
        this.buyerName = buyerName;
        this.officeSiteName = officeSiteName;
        this.companyBrandName = companyBrandName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.areaCode = areaCode;
        this.addedBy = addedBy;
        this.updatedBy = updatedBy;
        this.isDeleted = 0;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getOfficeSiteName() {
        return officeSiteName;
    }

    public String getCompanyBrandName() {
        return companyBrandName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setOfficeSiteName(String officeSiteName) {
        this.officeSiteName = officeSiteName;
    }

    public void setCompanyBrandName(String companyBrandName) {
        this.companyBrandName = companyBrandName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    @Override
    public String toString() {
        return "Buyer{" + "buyerName=" + buyerName + ", officeSiteName=" + officeSiteName + ", companyBrandName=" + companyBrandName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", areaCode=" + areaCode + ", addedBy=" + addedBy + ", updatedBy=" + updatedBy + '}';
    }
}
