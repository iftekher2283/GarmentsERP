/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import hibernatesingleton.HibernateSingleton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import md5.HashMD5;
import model.Employee;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author iftekher
 */
public class PlanningPanelUIController implements Initializable {
    // Planning FXML
    @FXML
    private ComboBox<?> planningIdBox;
    @FXML
    private DatePicker planningDatePicker;
    @FXML
    private TextField planningWorkingHourField;
    @FXML
    private TextField planningTotalNextMonthAllField;
    @FXML
    private TextField planningTotalCurrMonthAllField;
    @FXML
    private TextField planningTotalPrevMonthAllField;
    @FXML
    private ComboBox<?> planningCurrMonth;
    @FXML
    private ComboBox<?> planningNextMonthBox;
    @FXML
    private ComboBox<?> planningPrevMonthBox;
    @FXML
    private ComboBox<?> planningMonthBox;
    @FXML
    private TextField planningPlannedByField;
    @FXML
    private TextField planningLastUpdatedByField;
    @FXML
    private TableView<?> planningDetailsTableView;
    @FXML
    private TableColumn<?, ?> planningOrderIdTableColumn;
    @FXML
    private TableColumn<?, ?> planningBuyerNameTableColumn;
    @FXML
    private TableColumn<?, ?> planningOrderQuantityTableColumn;
    @FXML
    private TableColumn<?, ?> planningAllocatedQuantityTableColumn;
    @FXML
    private TableColumn<?, ?> planningExportStartDateTableColumn;
    @FXML
    private TableColumn<?, ?> planningPrevMonthAllTableColumn;
    @FXML
    private TableColumn<?, ?> planningCurrMonthAllTableColumn;
    @FXML
    private TableColumn<?, ?> planningNextMonthAllTableColumn;
    @FXML
    private TableColumn<?, ?> planningTargetTableColumn;
    @FXML
    private TableColumn<?, ?> planningDaysRequiredTableColumn;
    @FXML
    private TextField planningOrderIdField;
    @FXML
    private ComboBox<?> planningBuyerNameBox;
    @FXML
    private TextField planningTargetField;
    @FXML
    private TextField planningAllocatedQuantityField;
    @FXML
    private TextField planningOrderQuantityField;
    @FXML
    private TextField planningStyleField;
    @FXML
    private TextField planningColorField;
    @FXML
    private TextField planningDaysRequiredField;
    @FXML
    private TextField planningNextMonthAllField;
    @FXML
    private TextField planningCurrMonthAllField;
    @FXML
    private TextField planningPrevMonthAllField;
    @FXML
    private ComboBox<?> planningOutputEndDay;
    @FXML
    private ComboBox<?> planningOutputDayBox;
    @FXML
    private ComboBox<?> planningLineNumberBox;
    @FXML
    private ComboBox<?> planningInputDayBox;
    @FXML
    private DatePicker planningExportStartingDatePicker;
    @FXML
    private DatePicker planningFinalAuditDatePicker;
    @FXML
    private DatePicker planningOutputEndPicker;
    @FXML
    private DatePicker planningOutputDatePicker;
    @FXML
    private DatePicker planningInputDatePicker;
    @FXML
    private TextField planningFactoryNameField;
    @FXML
    private Text productionPlanningIdText;
    
    // Profile FXML
    @FXML
    private Text profileDesignationText;
    @FXML
    private Text profileJoiningDateText;
    @FXML
    private Text profileConfirmationDateText;
    @FXML
    private Text profileBranchText;
    @FXML
    private Text profileDepartmentText;
    @FXML
    private Text profileCompanyNoText;
    @FXML
    private Text profileNameText;
    @FXML
    private Text profileEmployeeIdText;
    @FXML
    private Text profileNidNoText;
    @FXML
    private Text profileEmailText;
    @FXML
    private Text profilePhoneText;
    @FXML
    private Text profileEduQualiText;
    @FXML
    private Text profilePassportNoText;
    @FXML
    private Text profileReligionText;
    @FXML
    private Text profileGenderText;
    @FXML
    private Text profileDateOfBirthText;
    @FXML
    private Text profileMotherNameText;
    @FXML
    private Text profileFatherNameText;
    @FXML
    private Text profileBloodGroupText;
    @FXML
    private Text profileNationalityText;
    @FXML
    private PasswordField profileOldPasswordField;
    @FXML
    private PasswordField profileRetypeNewPasswordField;
    @FXML
    private PasswordField profileNewPasswordField;
    @FXML
    private Text profileUsernameText;
    @FXML
    private Text plannerChangePasswordMessageText;
    @FXML
    private Text plannerProfileIdText;
    
    // Required Lists
    private List<User> users;
    private List<Employee> employees;
    
    // Hibernate Variables;
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    // Required Global Variable
    private String productionPlannerId;
    private Employee employee;
    private User user;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // Instantiate Lists
        users = new ArrayList<>();
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            users = session.createCriteria(User.class).list();
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
        session.close();
    }    

    @FXML
    private void handlePlanningSearchPlanIdAction(ActionEvent event) {
    }

    @FXML
    private void handlePlanningMonthBoxAction(ActionEvent event) {
    }

    @FXML
    private void handlePlanningSelectPlanAction(MouseEvent event) {
    }

    @FXML
    private void handlePlanningSearchOrderIdAction(ActionEvent event) {
    }

    @FXML
    private void handlePlanningSaveAction(ActionEvent event) {
    }

    @FXML
    private void handlePlanningRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handlePlanningRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleProductionPlanSignOutAction(ActionEvent event) {
        try {
            productionPlannerId = "";
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("HomePageUI.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            Scene scene = new Scene(root);
            
            TextileERP.getMainStage().setScene(scene);
            TextileERP.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(HomePageUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setPlannerId(String username){
        this.productionPlannerId = username;
        productionPlanningIdText.setText("Production Planner ID: " + username);
        plannerProfileIdText.setText("Production Planner ID: " + username);
        
        employees = new ArrayList<>();
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            employees = session.createCriteria(Employee.class).list();
            transaction.commit();
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
        
        // Get Employee Information Using ID
        for(int i = 0; i < employees.size(); i++){
            if(username.equals(employees.get(i).getId())){
                employee = employees.get(i);
            }
        }
        
        // Set Profile Information To FXML
        profileEmployeeIdText.setText(employee.getId());
        profileDesignationText.setText(employee.getDesignation());
        profileJoiningDateText.setText(employee.getJoiningDate());
        profileConfirmationDateText.setText(employee.getConfirmationDate());
        profileDepartmentText.setText(employee.getDepartmentCode());
        profileCompanyNoText.setText(employee.getCompanyNo() + "");
        profileNameText.setText(employee.getName());
        profileNidNoText.setText(employee.getPersonalInfo().getNidNo());
        profileEmailText.setText(employee.getPersonalInfo().getEmail());
        profilePhoneText.setText(employee.getPersonalInfo().getMobileNo());
        profileEduQualiText.setText(employee.getPersonalInfo().getEduQuali());
        profilePassportNoText.setText(employee.getPersonalInfo().getPassportNo());
        profileReligionText.setText(employee.getPersonalInfo().getReligion());
        profileGenderText.setText(employee.getSex());
        profileDateOfBirthText.setText(employee.getPersonalInfo().getDateOfBirth());
        profileMotherNameText.setText(employee.getPersonalInfo().getMothersName());
        profileFatherNameText.setText(employee.getPersonalInfo().getFathersName());
        profileBloodGroupText.setText(employee.getPersonalInfo().getBloodGroup());
        profileNationalityText.setText(employee.getPersonalInfo().getNationality());
        profileUsernameText.setText(employee.getId());
        profileBranchText.setText(employee.getBranchId());
    }

    @FXML
    private void handleChangePasswordReMatchAction(KeyEvent event) {
        plannerChangePasswordMessageText.setText("");
        String password = profileNewPasswordField.getText();
        String reTypePassword = profileRetypeNewPasswordField.getText();
        
        int isMatched = 0;
        if(!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)){
            isMatched = 1;
        }
        else if(!password.equals("") && !reTypePassword.equals("") && !password.equals(reTypePassword) && password != null && reTypePassword != null){
            plannerChangePasswordMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }

    @FXML
    private void handleChangePasswordMatchAction(KeyEvent event) {
        plannerChangePasswordMessageText.setText("");
        String password = profileNewPasswordField.getText();
        String reTypePassword = profileRetypeNewPasswordField.getText();
        
        int isMatched = 0;
        if(!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)){
            isMatched = 1;
        }
        else if(!password.equals("") && !reTypePassword.equals("") && !password.equals(reTypePassword) && password != null && reTypePassword != null){
            plannerChangePasswordMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }

    @FXML
    private void handlePlannerChangePasswordAction(ActionEvent event) {
        // Get Values From FXML
        String username = profileUsernameText.getText();
        String getPass = profileOldPasswordField.getText();
        
        String getNewPass = profileNewPasswordField.getText();
        String getNewRePass = profileRetypeNewPasswordField.getText();
        
        // Encrypt Passwords
        HashMD5 encPass = new HashMD5(getPass);
        String password = encPass.getHash();
        
        HashMD5 encNewPass = new HashMD5(getNewPass);
        String newPassword = encNewPass.getHash();
        
        // Get The User
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmployeeId().equals(username) && users.get(i).getPassword().equals(password)){
                user = users.get(i);
                break;
            }
        }
        
        // Set User's New Password
        if(getNewPass.equals(getNewRePass)){
            user.setPassword(newPassword);
        }
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            session.update(user);
            transaction.commit();
        }catch(Exception e){
            plannerChangePasswordMessageText.setText(e + "");
            transaction.rollback();
        }
        session.close();
        
        // Refresh FXML
        profileOldPasswordField.setText("");
        profileNewPasswordField.setText("");
        profileRetypeNewPasswordField.setText("");
    }

    @FXML
    private void handlePlannerProfileSignOutAction(ActionEvent event) {
        try {
            productionPlannerId = "";
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("HomePageUI.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            Scene scene = new Scene(root);
            
            TextileERP.getMainStage().setScene(scene);
            TextileERP.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(HomePageUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
