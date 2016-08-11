/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import enums.IsBlocked;
import enums.Section;
import hibernatesingleton.HibernateSingleton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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


public class AdminPanelUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String employeeId;
    @FXML
    private TextField adminUsersEmployeeIdField;
    @FXML
    private ComboBox<Section> adminUsersSectionBox;
    @FXML
    private ComboBox<IsBlocked> adminUsersIsBlockedBox;
    @FXML
    private PasswordField adminUsersReTypePasswordField;
    @FXML
    private TextField adminUsersUsernameField;
    @FXML
    private PasswordField adminUsersPasswordField;
    @FXML
    private TableView<User> adminUsersAllUsersTableView;
    @FXML
    private TableColumn<User, Number> adminUsersAllUsersSlTableColumn;
    @FXML
    private TableColumn<User, String> adminUsersAllUsersUsernameTableColumn;
    @FXML
    private TableColumn<User, String> adminUsersAllUsersSectionTableColumn;
    @FXML
    private TableColumn<User, String> adminUsersAllUsersIsBlockedTableColumn;
    @FXML
    private TableView<Employee> adminUsersAllEmployeesTableView;
    @FXML
    private TableColumn<Employee, String> adminUsersAllEmployeesEmployeeIdTableColumn;
    @FXML
    private TableColumn<Employee, String> adminUsersAllEmployeesNameTableColumn;
    @FXML
    private TableColumn<Employee, String> adminUsersAllEmployeesGenderTableColumn;
    @FXML
    private TableColumn<Employee, Number> adminUsersAllEmployeesCompanyNoTableColumn;
    @FXML
    private TableColumn<Employee, String> adminUsersAllEmployeesDepartmentTableColumn;
    @FXML
    private TableColumn<Employee, String> adminUsersAllEmployeesBranchIdTableColumn;
    @FXML
    private TableColumn<Employee, String> adminUsersAllEmployeesDesignationTableColumn;
    @FXML
    private Text adminManageUsersIdText;
    @FXML
    private Text adminUsersActionMessageText;
    
    private List<User> users;
    private List<Employee> employees;
    private ObservableList<User> usersView;
    private ObservableList<Employee> employeesView;
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    private Employee employee;
    private User user;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        adminUsersActionMessageText.setText("");
        adminUsersSectionBox.getItems().addAll(Section.values());
        adminUsersIsBlockedBox.getItems().addAll(IsBlocked.values());
        
        users = new ArrayList<>();
        employees = new ArrayList<>();
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        try{
            users = session.createCriteria(User.class).list();
            employees = session.createCriteria(Employee.class).list();
            transaction.commit();
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
        
        usersView = FXCollections.observableArrayList();
        for(int i = 0; i < users.size(); i++){
            int sl = users.get(i).getSl();
            String username = users.get(i).getEmployeeId();
            String password = users.get(i).getPassword();
            int userType = users.get(i).getUserType();
            int isBlocked = users.get(i).getIsBlocked();
            User user = new User(sl, username, password, userType, isBlocked);
            usersView.add(user);
        }
        adminUsersAllUsersTableView.setItems(usersView);
        adminUsersAllUsersSlTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getSl()));
        adminUsersAllUsersUsernameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmployeeId()));
        adminUsersAllUsersSectionTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUserTypeSt()));
        adminUsersAllUsersIsBlockedTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getIsBlockedSt()));
        
        employeesView = FXCollections.observableArrayList();
        for(int i = 0; i < employees.size(); i++){
            employeesView.add(employees.get(i));
        }
        adminUsersAllEmployeesTableView.setItems(employeesView);
        adminUsersAllEmployeesEmployeeIdTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getId()));
        adminUsersAllEmployeesNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getName()));
        adminUsersAllEmployeesGenderTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getSex()));
        adminUsersAllEmployeesCompanyNoTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getCompanyNo()));
        adminUsersAllEmployeesDepartmentTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDepartmentCode()));
        adminUsersAllEmployeesBranchIdTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBranchId()));
        adminUsersAllEmployeesDesignationTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDesignation()));
    }   
    
    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
        adminManageUsersIdText.setText("Admin ID: " + employeeId);
    }

    @FXML
    private void handleAdminManageUsersSignOutAction(ActionEvent event) {
        adminUsersActionMessageText.setText("");
        try {
            employeeId = "";
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

    @FXML
    private void handleManageUsersGiveAccessAction(ActionEvent event) {
        adminUsersActionMessageText.setText("");
        int isEmployee = 0;
        String employeeId = adminUsersEmployeeIdField.getText();
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getId().equals(employeeId)){
                isEmployee = 1;
                break;
            }
        }
        
        if(isEmployee == 1){
            String password = adminUsersPasswordField.getText();
            String reTypePassword = adminUsersReTypePasswordField.getText();
            User user = new User();
            user.setSl(0);
            user.setEmployeeId(adminUsersEmployeeIdField.getText());
            String userType = adminUsersSectionBox.getSelectionModel().getSelectedItem() + "";
            int userTypeCode = 0;
            if(userType.equals("Merchandizer")){
                userTypeCode = 1;
            }
            else if(userType.equals("Planning")){
                userTypeCode = 2;
            }
            else if(userType.equals("IE")){
                userTypeCode = 3;
            }
            else if(userType.equals("Production")){
                userTypeCode = 4;
            }
            else if(userType.equals("QM")){
                userTypeCode = 5;
            }
            else if(userType.equals("Store")){
                userTypeCode = 6;
            }
            else if(userType.equals("HR")){
                userTypeCode = 7;
            }
            else if(userType.equals("Admin")){
                userTypeCode = 8;
            }
            user.setUserType(userTypeCode);
            user.setIsBlocked(0);

            if(password.length() >= 6){
                if(password.equals(reTypePassword)){
                    HashMD5 encPass = new HashMD5(password);
                    user.setPassword(encPass.getHash());
                }
                else{
                    adminUsersActionMessageText.setText("Please Enter Same Password in Both Fields");
                }
            }
            else{
                adminUsersActionMessageText.setText("Please Enter At Least 6 Characters");
            }

            factory = HibernateSingleton.getSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();

            users.removeAll(users);
            try{
                session.save(user);
                users = session.createCriteria(User.class).list();
                transaction.commit();
            }catch(Exception e){
                System.err.println(e);
                transaction.rollback();
            }
            session.close();

            usersView.remove(0, usersView.size());
            for(int i = 0; i < users.size(); i++){
                int sl = users.get(i).getSl();
                String username = users.get(i).getEmployeeId();
                String passwordV = users.get(i).getPassword();
                int userTypeV = users.get(i).getUserType();
                int isBlocked = users.get(i).getIsBlocked();
                User userV = new User(sl, username, passwordV, userTypeV, isBlocked);
                usersView.add(userV);
            }
            adminUsersAllUsersTableView.setItems(usersView);
            adminUsersAllUsersSlTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getSl()));
            adminUsersAllUsersUsernameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmployeeId()));
            adminUsersAllUsersSectionTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUserTypeSt()));
            adminUsersAllUsersIsBlockedTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getIsBlockedSt()));
            
            
            adminUsersEmployeeIdField.setText("");
            adminUsersSectionBox.getSelectionModel().clearSelection();
            adminUsersIsBlockedBox.getSelectionModel().clearSelection();
            adminUsersReTypePasswordField.setText("");
            adminUsersUsernameField.setText("");
            adminUsersPasswordField.setText("");
        }
        else{
            adminUsersActionMessageText.setText("Employee Not Found");
        }
    }

    @FXML
    private void handleManageUsersBlockAction(ActionEvent event) {
        adminUsersActionMessageText.setText("");
        int isUser = 0, isAdmin = 0;
        String username = adminUsersUsernameField.getText();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmployeeId().equals(username)){
                isUser = 1;
                if(users.get(i).getUserType() == 8){
                    isAdmin = 1;
                }
                break;
            }
        }
        
        if(isUser == 1 && isAdmin == 0){
            User user = new User();
            user.setSl(this.user.getSl());
            user.setEmployeeId(this.user.getEmployeeId());
            user.setPassword(this.user.getPassword());
            user.setUserType(this.user.getUserType());
            user.setIsBlocked(1);
            
            factory = HibernateSingleton.getSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();

            users.removeAll(users);
            try{
                session.update(user);
                users = session.createCriteria(User.class).list();
                transaction.commit();
            }catch(Exception e){
                System.err.println(e);
                transaction.rollback();
            }
            session.close();

            usersView.remove(0, usersView.size());
            for(int i = 0; i < users.size(); i++){
                int sl = users.get(i).getSl();
                String usernameV = users.get(i).getEmployeeId();
                String passwordV = users.get(i).getPassword();
                int userTypeV = users.get(i).getUserType();
                int isBlocked = users.get(i).getIsBlocked();
                User userV = new User(sl, usernameV, passwordV, userTypeV, isBlocked);
                usersView.add(userV);
            }
            adminUsersAllUsersTableView.setItems(usersView);
            adminUsersAllUsersSlTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getSl()));
            adminUsersAllUsersUsernameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmployeeId()));
            adminUsersAllUsersSectionTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUserTypeSt()));
            adminUsersAllUsersIsBlockedTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getIsBlockedSt()));
            
            adminUsersEmployeeIdField.setText("");
            adminUsersSectionBox.getSelectionModel().clearSelection();
            adminUsersIsBlockedBox.getSelectionModel().clearSelection();
            adminUsersReTypePasswordField.setText("");
            adminUsersUsernameField.setText("");
            adminUsersPasswordField.setText("");
        }
        else if(isUser == 1 && isAdmin == 1){
            adminUsersActionMessageText.setText("Sorry! Admins Are Only Handled By Super Admin");
        }
        else{
            adminUsersActionMessageText.setText("User Not Found");
        }
    }

    @FXML
    private void handleManageUsersUnblockAction(ActionEvent event) {
        adminUsersActionMessageText.setText("");
        int isUser = 0, isAdmin = 0;
        String username = adminUsersUsernameField.getText();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmployeeId().equals(username)){
                isUser = 1;
                if(users.get(i).getUserType() == 8){
                    isAdmin = 1;
                }
                break;
            }
        }
        
        if(isUser == 1 && isAdmin == 0){
            User user = new User();
            user.setSl(this.user.getSl());
            user.setEmployeeId(this.user.getEmployeeId());
            user.setPassword(this.user.getPassword());
            user.setUserType(this.user.getUserType());
            user.setIsBlocked(0);
            
            factory = HibernateSingleton.getSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();

            users.removeAll(users);
            try{
                session.update(user);
                users = session.createCriteria(User.class).list();
                transaction.commit();
            }catch(Exception e){
                System.err.println(e);
                transaction.rollback();
            }
            session.close();

            usersView.remove(0, usersView.size());
            for(int i = 0; i < users.size(); i++){
                int sl = users.get(i).getSl();
                String usernameV = users.get(i).getEmployeeId();
                String passwordV = users.get(i).getPassword();
                int userTypeV = users.get(i).getUserType();
                int isBlocked = users.get(i).getIsBlocked();
                User userV = new User(sl, usernameV, passwordV, userTypeV, isBlocked);
                usersView.add(userV);
            }
            adminUsersAllUsersTableView.setItems(usersView);
            adminUsersAllUsersSlTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getSl()));
            adminUsersAllUsersUsernameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmployeeId()));
            adminUsersAllUsersSectionTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUserTypeSt()));
            adminUsersAllUsersIsBlockedTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getIsBlockedSt()));
            
            adminUsersEmployeeIdField.setText("");
            adminUsersSectionBox.getSelectionModel().clearSelection();
            adminUsersIsBlockedBox.getSelectionModel().clearSelection();
            adminUsersReTypePasswordField.setText("");
            adminUsersUsernameField.setText("");
            adminUsersPasswordField.setText("");
        }
        else if(isUser == 1 && isAdmin == 1){
            adminUsersActionMessageText.setText("Sorry! Admins Are Only Handled By Super Admin");
        }
        else{
            adminUsersActionMessageText.setText("User Not Found");
        }
    }

    @FXML
    private void handleManageUsersRefreshAction(ActionEvent event) {
        adminUsersActionMessageText.setText("");
        adminUsersEmployeeIdField.setText("");
        adminUsersSectionBox.getSelectionModel().clearSelection();
        adminUsersIsBlockedBox.getSelectionModel().clearSelection();
        adminUsersReTypePasswordField.setText("");
        adminUsersUsernameField.setText("");
        adminUsersPasswordField.setText("");
    }

    @FXML
    private void handleAdminManageUsersSelectUserAction(MouseEvent event) {
        adminUsersActionMessageText.setText("");
        user = adminUsersAllUsersTableView.getSelectionModel().getSelectedItem();
        
        adminUsersEmployeeIdField.setText(user.getEmployeeId());
        adminUsersSectionBox.getSelectionModel().select(Section.valueOf(user.getUserTypeSt()));
        adminUsersIsBlockedBox.getSelectionModel().select(IsBlocked.valueOf(user.getIsBlockedSt()));
        adminUsersUsernameField.setText(user.getEmployeeId());
        adminUsersPasswordField.setText("");
        adminUsersReTypePasswordField.setText("");
    }

    @FXML
    private void handleAdminManageUsersSelectEmployeeAction(MouseEvent event) {
        adminUsersActionMessageText.setText("");
        employee = adminUsersAllEmployeesTableView.getSelectionModel().getSelectedItem();
        
        adminUsersEmployeeIdField.setText(employee.getId());
        adminUsersUsernameField.setText(employee.getId());
        adminUsersSectionBox.getSelectionModel().clearSelection();
        adminUsersIsBlockedBox.getSelectionModel().clearSelection();
        adminUsersPasswordField.setText("");
        adminUsersReTypePasswordField.setText("");
    }

    @FXML
    private void handleManageUsersUpdateAction(ActionEvent event) {
        adminUsersActionMessageText.setText("");
        int isUser = 0, isAdmin = 0;
        String username = adminUsersUsernameField.getText();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmployeeId().equals(username)){
                isUser = 1;
                if(users.get(i).getUserType() == 8){
                    isAdmin = 1;
                }
                break;
            }
        }
        
        if(isUser == 1 && isAdmin == 0){
            User user = new User();
            user.setSl(this.user.getSl());
            user.setEmployeeId(this.user.getEmployeeId());
            user.setPassword(this.user.getPassword());
            String userType = adminUsersSectionBox.getSelectionModel().getSelectedItem() + "";
            int userTypeCode = 0;
            if(userType.equals("Merchandizer")){
                userTypeCode = 1;
            }
            else if(userType.equals("Planning")){
                userTypeCode = 2;
            }
            else if(userType.equals("IE")){
                userTypeCode = 3;
            }
            else if(userType.equals("Production")){
                userTypeCode = 4;
            }
            else if(userType.equals("QM")){
                userTypeCode = 5;
            }
            else if(userType.equals("Store")){
                userTypeCode = 6;
            }
            else if(userType.equals("HR")){
                userTypeCode = 7;
            }
            else if(userType.equals("Admin")){
                userTypeCode = 8;
            }
            user.setUserType(userTypeCode);
            user.setIsBlocked(this.user.getIsBlocked());
            
            factory = HibernateSingleton.getSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();

            users.removeAll(users);
            try{
                session.update(user);
                users = session.createCriteria(User.class).list();
                transaction.commit();
            }catch(Exception e){
                System.err.println(e);
                transaction.rollback();
            }
            session.close();

            usersView.remove(0, usersView.size());
            for(int i = 0; i < users.size(); i++){
                int sl = users.get(i).getSl();
                String usernameV = users.get(i).getEmployeeId();
                String passwordV = users.get(i).getPassword();
                int userTypeV = users.get(i).getUserType();
                int isBlocked = users.get(i).getIsBlocked();
                User userV = new User(sl, usernameV, passwordV, userTypeV, isBlocked);
                usersView.add(userV);
            }
            adminUsersAllUsersTableView.setItems(usersView);
            adminUsersAllUsersSlTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getSl()));
            adminUsersAllUsersUsernameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmployeeId()));
            adminUsersAllUsersSectionTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUserTypeSt()));
            adminUsersAllUsersIsBlockedTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getIsBlockedSt()));
            
            adminUsersEmployeeIdField.setText("");
            adminUsersSectionBox.getSelectionModel().clearSelection();
            adminUsersIsBlockedBox.getSelectionModel().clearSelection();
            adminUsersReTypePasswordField.setText("");
            adminUsersUsernameField.setText("");
            adminUsersPasswordField.setText("");
        }
        else if(isUser == 1 && isAdmin == 1){
            adminUsersActionMessageText.setText("Sorry! Admins Are Only Handled By Super Admin");
        }
        else{
            adminUsersActionMessageText.setText("User Not Found");
        }
    }

    @FXML
    private void handleAdminUserPasswordMatchAction(KeyEvent event) {
        adminUsersActionMessageText.setText("");
        String password = adminUsersPasswordField.getText();
        String reTypePassword = adminUsersReTypePasswordField.getText();
        
        int isMatched = 0;
        if(!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)){
            isMatched = 1;
        }
        else{
            adminUsersActionMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }

    @FXML
    private void handleAdminUserReTypePasswordMatchAction(KeyEvent event) {
        adminUsersActionMessageText.setText("");
        String password = adminUsersPasswordField.getText();
        String reTypePassword = adminUsersReTypePasswordField.getText();
        
        int isMatched = 0;
        if(!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)){
            isMatched = 1;
        }
        else{
            adminUsersActionMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }
    
}
