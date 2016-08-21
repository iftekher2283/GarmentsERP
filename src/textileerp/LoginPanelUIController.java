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
   
    private String DB_URL = "jdbc:mysql://127.0.0.1/textileerpdb";
    private String DB_USER = "root";
    private String DB_PASS = "123";
  /*  private static SessionFactory factory;
    private static Session session;
    private List<User> users;*/
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
      /*  factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        users = new ArrayList<>();
        
        Transaction transaction = session.beginTransaction();
        try{
//            Criteria criteria = session.createCriteria(User.class);
//            criteria.add(Restrictions.eq("user_id", username));
//            
//            User user = (User) criteria.uniqueResult();
            users = session.createCriteria(User.class).list();
            transaction.commit();
            
            for (int i = 0; i < users.size(); i++){
                User user = users.get(i);
                if(username.equals(user.getEmployeeId()) && encPass.getHash().equals(user.getPassword())){
                    if(userTypeCode == user.getUserType()){
                        loginConf = 1;
                        loginFailMessage.setText("Login Successful");
                    }
                    else{
                        loginFailMessage.setText("Sorry! You don't have access to this");
                    }
                }
                else{
                    loginFailMessage.setText("Sorry! Username or Password didn't match");
                }
            }
        }catch(Exception e){
            System.out.println(e);
//            transaction.rollback();
        }
        session.close();*/
       
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM tbl_users;";
            ResultSet users = statement.executeQuery(query);
            
            while(users.next()){
                int get_sl = users.getInt("sl");
                String get_user = users.getString("user_id");
                String get_pass = users.getString("password");
                int get_user_type = users.getInt("user_type");
                int get_is_blocked = users.getInt("isBlocked");
                String getAddedBy = users.getString("addedBy");
                String getLastUpdatedBy = users.getString("lastUpdatedBy");
                User user = new User(get_sl, get_user, get_pass, get_user_type, get_is_blocked, getAddedBy, getLastUpdatedBy);
                if(username.equals(user.getEmployeeId()) && encPass.getHash().equals(user.getPassword())){
                    if(userTypeCode == user.getUserType() && user.getIsBlocked() == 0){
                        loginConf = 1;
                        loginFailMessage.setText("Login Successful");
                        break;
                    }
                    else if(userTypeCode == user.getUserType() && user.getIsBlocked() == 1){
                        loginFailMessage.setText("Sorry! You are currently blocked by an Admin");
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
          //  System.out.println(userType);
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
