/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author iftekher
 */
@Embeddable
public class Salary {
    private double basic_salary;
   /* @Transient
    private double running_basic;
    @Transient
    private double house_rent;
    @Transient
    private double medical;
    @Transient
    private double others;
    @Transient
    private double conveyance;
    @Transient
    private double car_allow;
    @Transient
    private double gross_salary;*/
    private String bank_code;
    private String ac_no;
    @Transient
    @FXML
    private DatePicker joiningDatePicker;
    public Salary() {
    }

  /*  public Salary(double basic_salary) {
        this.basic_salary = basic_salary;
        String join_date = joiningDatePicker.getEditor().getText();
        String join_date_tokens[] = join_date.split("/");
        int join_year = Integer.parseInt(join_date_tokens[2]);
        int join_month = Integer.parseInt(join_date_tokens[1]);
        Date get_year = new Date();
        SimpleDateFormat years = new SimpleDateFormat("yyyy");
        int pres_year = Integer.parseInt(years.format(get_year));
        Date get_months = new Date();
        SimpleDateFormat months = new SimpleDateFormat("MM");
        int pres_month = Integer.parseInt(months.format(get_months));
        int job_years = 0;
        if(join_month > pres_month){
            job_years = pres_year - (join_year + 1);
        }
        else{
            job_years = pres_year - join_year;
        }
        
        double running_basic = 0;
        if(job_years > 0){
        running_basic = basic_salary + (basic_salary * job_years  * (5.0 / 100));
        }
        else{
            running_basic = basic_salary;
        }
        this.running_basic = running_basic;
        this.house_rent = (this.running_basic * 40) / 100;
        this.medical = (this.running_basic * 10) / 100;
        this.others = (this.running_basic * 5) / 100;
        this.conveyance = (this.running_basic * 5) / 100;
        this.car_allow = (this.running_basic * 10) / 100;
        this.gross_salary = this.running_basic + this.house_rent + this.medical + this.others + this.conveyance + this.car_allow;
    } */
    
    public Salary(double basic_salary, String bank_code, String ac_no) {
        this.basic_salary = basic_salary;
        /*
        String join_date = joiningDatePicker.getEditor().getText();
        String join_date_tokens[] = join_date.split("/");
        int join_year = Integer.parseInt(join_date_tokens[2]);
        int join_month = Integer.parseInt(join_date_tokens[1]);
        Date get_year = new Date();
        SimpleDateFormat years = new SimpleDateFormat("yyyy");
        int pres_year = Integer.parseInt(years.format(get_year));
        Date get_months = new Date();
        SimpleDateFormat months = new SimpleDateFormat("MM");
        int pres_month = Integer.parseInt(months.format(get_months));
        int job_years = 0;
        if(join_month > pres_month){
            job_years = pres_year - (join_year + 1);
        }
        else{
            job_years = pres_year - join_year;
        }
        
        this.running_basic = 0;
        if(job_years > 0){
            this.running_basic = basic_salary + (basic_salary * job_years  * (5.0 / 100));
        }
        else{
            this.running_basic = basic_salary;
        }
       // this.running_basic = running_basic;
        this.house_rent = (this.running_basic * 40) / 100;
        this.medical = (this.running_basic * 10) / 100;
        this.others = (this.running_basic * 5) / 100;
        this.conveyance = (this.running_basic * 5) / 100;
        this.car_allow = (this.running_basic * 10) / 100;
        this.gross_salary = this.running_basic + this.house_rent + this.medical + this.others + this.conveyance + this.car_allow;*/
        this.bank_code = bank_code;
        this.ac_no = ac_no;
    }

    public double getBasic_salary() {
        return basic_salary;
    }

    /*public double getRunning_basic() {
        return running_basic;
    }

    public double getHouse_rent() {
        return house_rent;
    }

    public double getMedical() {
        return medical;
    }

    public double getOthers() {
        return others;
    }

    public double getConveyance() {
        return conveyance;
    }

    public double getCar_allow() {
        return car_allow;
    }

    public double getGross_salary() {
        return gross_salary;
    }*/

    public String getBank_code() {
        return bank_code;
    }

    public String getAc_no() {
        return ac_no;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }
/*
    public void setRunning_basic(double running_basic) {
        this.running_basic = running_basic;
    }

    public void setHouse_rent(double house_rent) {
        this.house_rent = house_rent;
    }

    public void setMedical(double medical) {
        this.medical = medical;
    }

    public void setOthers(double others) {
        this.others = others;
    }

    public void setConveyance(double conveyance) {
        this.conveyance = conveyance;
    }

    public void setCar_allow(double car_allow) {
        this.car_allow = car_allow;
    }

    public void setGross_salary(double gross_salary) {
        this.gross_salary = gross_salary;
    }*/

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public void setAc_no(String ac_no) {
        this.ac_no = ac_no;
    }

    @Override
    public String toString() {
        return "Salary{" + "basic_salary=" + basic_salary + ", bank_code=" + bank_code + ", ac_no=" + ac_no + ", joiningDatePicker=" + joiningDatePicker + '}';
    }
}
