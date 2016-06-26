/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import md5.HashMD5;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author iftekher
 */
public class LoginPanelUIController implements Initializable {
    @FXML
    private Text loginAsText;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text loginFailMessage;
    
    private String userType;
    private int userTypeCode;
    private int loginConf = 0;
    
    private String DB_URL = "jdbc:mysql://127.0.0.1/textileerpdb";
    private String DB_USER = "root";
    private String DB_PASS = "123";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleLoginAction(ActionEvent event) {
        String username = userNameField.getText();
        String password = passwordField.getText();
        
        HashMD5 encPass = new HashMD5(password);
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM tbl_users;";
            ResultSet user = statement.executeQuery(query);
            
            while(user.next()){
                String get_user = user.getString("user_id");
                String get_pass = user.getString("password");
                int get_user_type = user.getInt("user_type");

                if(username.equals(get_user) && encPass.getHash().equals(get_pass)){
                    if(userTypeCode == get_user_type){
                        loginConf = 1;
                        loginFailMessage.setText("Login Successful");
                        break;
                    }
                    else{
                        loginFailMessage.setText("Sorry! You don't have access to this");
                    }
                }
                else{
                    loginFailMessage.setText("Sorry! Username or Password didn't match");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPanelUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(loginConf == 1){
            try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(userType + "PanelUI.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            Scene scene = new Scene(root);
            
            TextileERP.getMainStage().setScene(scene);
            if(userType.equals("Admin")){
                AdminPanelUIController adminPanel = loader.getController();
                adminPanel.setEmployeeId(username);
            }
            else if(userType.equals("HR")){
                HRPanelUIController hrPanel = loader.getController();
                hrPanel.setEmployeeId(username);
            }
            TextileERP.getMainStage().show();
        } catch (IOException ex) {
            Logger.getLogger(HomePageUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        try {
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
    
    public void setUserType(String userType){
        this.userType = userType;
        loginAsText.setText(userType);
        if(userType.equals("Merchandising")){
            this.userTypeCode = 1;
        }
        else if(userType.equals("Planning")){
            this.userTypeCode = 2;
        }
        else if(userType.equals("IE")){
            this.userTypeCode = 3;
        }
        else if(userType.equals("Production")){
            this.userTypeCode = 4;
        }
        else if(userType.equals("QC")){
            this.userTypeCode = 5;
        }
        else if(userType.equals("Store")){
            this.userTypeCode = 6;
        }
        else if(userType.equals("HR")){
            this.userTypeCode = 7;
        }
        else if(userType.equals("Admin")){
            this.userTypeCode = 8;
        }
    }
}
