/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import model.User;
import hibernatesingleton.HibernateSingleton;
import md5.HashMD5;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
    
    private static SessionFactory factory;
    private static Session session;
    private List<User> users;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        users = new ArrayList<>();
        
        Transaction transaction = session.beginTransaction();
        try{
            users = session.createCriteria(User.class).list();
            transaction.commit();
            
            
        }catch(Exception e){
            transaction.rollback();
        }
        session.close();
        
    }    

    @FXML
    private void handleLoginAction(ActionEvent event) {
        loginFailMessage.setText("");
        
        String username = userNameField.getText();
        String password = passwordField.getText();
        
        HashMD5 encPass = new HashMD5(password);
        for (int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if(username.equals(user.getEmployeeId()) && encPass.getHash().equals(user.getPassword()) && userTypeCode == user.getUserType() && user.getIsBlocked() == 0){
                loginConf = 1;
                break;
            }
            else if(username.equals(user.getEmployeeId()) && encPass.getHash().equals(user.getPassword()) && userTypeCode != user.getUserType()){
                loginConf = 2;
                break;
            }
            else if(username.equals(user.getEmployeeId()) && encPass.getHash().equals(user.getPassword()) && userTypeCode == user.getUserType() && user.getIsBlocked() == 1){
                loginConf = 3;
                break;
            }
            else{
                loginConf = 4;
            }
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
                else if(userType.equals("Merchandiser")){
                    MerchandiserPanelUIController merchandiserPanel = loader.getController();
                    merchandiserPanel.setMerchandiserId(username);
                }
                else if(userType.equals("IE")){
                    IEPanelUIController iePanel = loader.getController();
                    iePanel.setIeId(username);
                }
                else if(userType.equals("QM")){
                    QMPanelUIController qmPanel = loader.getController();
                    qmPanel.setQmId(username);
                }
                else if(userType.equals("Planning")){
                    PlanningPanelUIController planningPanel = loader.getController();
                    planningPanel.setPlannerId(username);
                }
                else if(userType.equals("Production")){
                    ProductionPanelUIController productionPanel = loader.getController();
                    productionPanel.setProductionId(username);
                }
                else if(userType.equals("Store")){
                    StorePanelUIController storePanel = loader.getController();
                    storePanel.setStoreManagerId(username);
                }
                TextileERP.getMainStage().show();
            } catch (IOException ex) {
                Logger.getLogger(HomePageUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
            loginConf = 0;
        }
        else if(loginConf == 2){
            loginFailMessage.setText("Sorry! You don't have access to this");
        }
        else if(loginConf == 3){
            loginFailMessage.setText("Sorry! You are currently blocked. Contact with administrator");
        }
        else if(loginConf == 4){
            loginFailMessage.setText("Sorry! Username or Password didn't match");
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
        if(userType.equals("Merchandiser")){
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
        else if(userType.equals("QM")){
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
