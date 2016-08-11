/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author iftekher
 */
public class ProductionPanelUIController implements Initializable {
    @FXML
    private Text productionCuttingActionMessageText;
    @FXML
    private Text productionCuttingIdText;
    @FXML
    private Text productionSewingActionMessageText;
    @FXML
    private Text productionSewingIdText;
    @FXML
    private Text productionFinishingActionMessageText;
    @FXML
    private Text productionFinishingIdText;
    
    private String productionManagerId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCuttingSaveAction(ActionEvent event) {
    }

    @FXML
    private void handleCuttingRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleCuttingRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleProductionCuttingSignOutAction(ActionEvent event) {
        try {
            productionManagerId = "";
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
    private void handleProductionSewingSignOutAction(ActionEvent event) {
        try {
            productionManagerId = "";
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
    private void handleSewingSaveAction(ActionEvent event) {
    }

    @FXML
    private void handleSewingRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleSewingRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleProductionFinishingSignOutAction(ActionEvent event) {
        try {
            productionManagerId = "";
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
    private void handleFinishingSaveAction(ActionEvent event) {
    }

    @FXML
    private void handleFinishingRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleFinishingRefreshAction(ActionEvent event) {
    }
    
    public void setProductionId(String username){
        this.productionManagerId = username;
        productionCuttingIdText.setText("Production Manager ID: " + username);
        productionSewingIdText.setText("Production Manager ID: " + username);
        productionFinishingIdText.setText("Production Manager ID: " + username);
    }
}
