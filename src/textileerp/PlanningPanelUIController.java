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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author iftekher
 */
public class PlanningPanelUIController implements Initializable {
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
    
    private String productionPlannerId;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }
}
