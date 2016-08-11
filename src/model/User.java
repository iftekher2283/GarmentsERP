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
import javax.persistence.Transient;

/**
 *
 * @author iftekher
 */
@Entity
@Table(name="tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sl;
    @Column(name="user_id")
    private String employeeId;
    private String password;
    @Column(name="user_type")
    private int userType;
    private int isBlocked;
    @Transient
    private String userTypeSt;
    @Transient
    private String isBlockedSt;

    public User() {
    }

    public User(int sl, String employeeId, String password, int userType, int isBlocked) {
        this.sl = sl;
        this.employeeId = employeeId;
        this.password = password;
        this.userType = userType;
        this.isBlocked = isBlocked;
        if(userType == 1){
            this.userTypeSt = "Merchandizer";
        }
        else if(userType == 2){
            this.userTypeSt = "Planning";
        }
        else if(userType == 3){
            this.userTypeSt = "IE";
        }
        else if(userType == 4){
            this.userTypeSt = "Production";
        }
        else if(userType == 5){
            this.userTypeSt = "QM";
        }
        else if(userType == 6){
            this.userTypeSt = "Store";
        }
        else if(userType == 7){
            this.userTypeSt = "HR";
        }
        else if(userType == 8){
            this.userTypeSt = "Admin";
        }
        if(isBlocked == 0){
            this.isBlockedSt = "No";
        }
        else if(isBlocked == 1){
            this.isBlockedSt = "Yes";
        }
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
        if(userType == 1){
            this.userTypeSt = "Merchandizer";
        }
        else if(userType == 2){
            this.userTypeSt = "Planning";
        }
        else if(userType == 3){
            this.userTypeSt = "IE";
        }
        else if(userType == 4){
            this.userTypeSt = "Production";
        }
        else if(userType == 5){
            this.userTypeSt = "QM";
        }
        else if(userType == 6){
            this.userTypeSt = "Store";
        }
        else if(userType == 7){
            this.userTypeSt = "HR";
        }
        else if(userType == 8){
            this.userTypeSt = "Admin";
        }
    }

    public int getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(int isBlocked) {
        this.isBlocked = isBlocked;
        if(isBlocked == 0){
            this.isBlockedSt = "No";
        }
        else if(isBlocked == 1){
            this.isBlockedSt = "Yes";
        }
    }

    public String getUserTypeSt() {
        return userTypeSt;
    }

    public void setUserTypeSt(String userTypeSt) {
        this.userTypeSt = userTypeSt;
    }

    public String getIsBlockedSt() {
        return isBlockedSt;
    }

    public void setIsBlockedSt(String isBlockedSt) {
        this.isBlockedSt = isBlockedSt;
    }

    @Override
    public String toString() {
        return "User{" + "sl=" + sl + ", employeeId=" + employeeId + ", password=" + password + ", userType=" + userType + ", isBlocked=" + isBlocked + ", userTypeSt=" + userTypeSt + ", isBlockedSt=" + isBlockedSt + '}';
    }
}
