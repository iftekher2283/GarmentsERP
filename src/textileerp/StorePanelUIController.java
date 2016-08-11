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
public class StorePanelUIController implements Initializable {
    @FXML
    private Text storeInventoryActionMessageText;
    @FXML
    private Text storeInventoryIdText;
    @FXML
    private Text storeShipmentActionMessageText;
    @FXML
    private Text storeShipmentIdText;
    
    private String storeManagerId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleInventorySaveAction(ActionEvent event) {
    }

    @FXML
    private void handleInventoryRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleInventoryRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleStoreInventorySignOutAction(ActionEvent event) {
        try {
            storeManagerId = "";
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
    private void handleShipmentSaveAction(ActionEvent event) {
    }

    @FXML
    private void handleShipmentRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleShipmentRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleStoreShipmentSignOutAction(ActionEvent event) {
        try {
            storeManagerId = "";
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
    
    public void setStoreManagerId(String username){
        this.storeManagerId = username;
        storeInventoryIdText.setText("Store Manager ID: " + username);
        storeShipmentIdText.setText("Store Manager ID: " + username);
    }
}
