/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author iftekher
 */
@Entity
@Table(name="tbl_users")
public class User {
    @Id
    private int sl;
    @Column(name="user_id")
    private String employeeId;
    private String password;
    @Column(name="user_type")
    private int userType;

    public User() {
    }

    public User(String employeeId, String password, int userType) {
       // this.sl = sl;
        this.employeeId = employeeId;
        this.password = password;
        this.userType = userType;
    }

    public int getSl() {
        return sl;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPassword() {
        return password;
    }

    public int getUserType() {
        return userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "sl=" + sl + ", employeeId=" + employeeId + ", password=" + password + ", userType=" + userType + '}';
    }
    
}
