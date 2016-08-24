/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import enums.Currency;
import enums.Floors;
import enums.Lines;
import enums.OrderCategory;
import hibernatesingleton.HibernateSingleton;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import md5.HashMD5;
import model.Buyer;
import model.Employee;
import model.Order;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author iftekher
 */
public class MerchandiserPanelUIController implements Initializable {
    // Buyer FXML
    @FXML
    private TextField buyerNameField;
    @FXML
    private TextField buyerOfficeSiteNameField;
    @FXML
    private TextField buyerCompanyBrandNameField;
    @FXML
    private TextField buyerCityField;
    @FXML
    private TextField buyerPhoneField;
    @FXML
    private TextField buyerEmailField;
    @FXML
    private TextField buyerStateField;
    @FXML
    private TextField buyerZipCodeField;
    @FXML
    private TextField buyerAreaCodeField;
    @FXML
    private TextArea buyerAddressArea;
    @FXML
    private TableView<Buyer> buyersTableView;
    @FXML
    private TableColumn<Buyer, String> buyerNameTableColumn;
    @FXML
    private TableColumn<Buyer, String> buyerSiteNameTableColumn;
    @FXML
    private TableColumn<Buyer, String> buyerBrandNameTableColummn;
    @FXML
    private TableColumn<Buyer, String> buyerPhoneTableColumn;
    @FXML
    private TableColumn<Buyer, String> buyerEmailTableColumn;
    @FXML
    private TableColumn<Buyer, String> buyerAddedByTableColumn;
    @FXML
    private TableColumn<Buyer, String> buyerLastUpdatedByTableColumn;
    @FXML
    private Text buyerNameMatchingText;
    @FXML
    private Text merchandiserBuyerIdText;
    
    // Order FXML
    @FXML
    private Text orderIdSearchMessageText;
    @FXML
    private Text manageOrderActionMessageText;
    @FXML
    private TextField orderIdField;
    @FXML
    private TextField orderNameField;
    @FXML
    private TextField orderBuyerReqirementsField;
    @FXML
    private TextField orderPriorityField;
    @FXML
    private ComboBox<Lines> orderLineNoBox;
    @FXML
    private ComboBox<Floors> orderFloorNoBox;
    @FXML
    private TextField orderQuantityField;
    @FXML
    private TextField orderSmvField;
    @FXML
    private TextField orderCostField;
    @FXML
    private TextField orderInternalCommentsField;
    @FXML
    private TextArea orderDescriptionArea;
    @FXML
    private ComboBox<String> orderBuyerNameBox;
    @FXML
    private ComboBox<OrderCategory> orderCategoryBox;
    @FXML
    private ComboBox<Currency> orderCurrencyBox;
    @FXML
    private DatePicker orderDeliveryDatePicker;
    @FXML
    private TableView<Order> ordersTableView;
    @FXML
    private TableColumn<Order, Number> orderIdTableColumn;
    @FXML
    private TableColumn<Order, String> orderNameTableColumn;
    @FXML
    private TableColumn<Order, String> orderBuyerNameTableColumn;
    @FXML
    private TableColumn<Order, Number> orderQuantityTableColumn;
    @FXML
    private TableColumn<Order, String> orderCategoryTableColumn;
    @FXML
    private TableColumn<Order, String> orderDateTableColumn;
    @FXML
    private TableColumn<Order, String> orderDeliveryDateTableColumn;
    @FXML
    private TableColumn<Order, String> orderAddedByTableColumn;
    @FXML
    private TableColumn<Order, String> orderLastUpdatedByTableColumn;
    @FXML
    private Text merchandiserOrderIdText;
    
    // Consumption FXML
    @FXML
    private ComboBox<?> consumptionCategoryBox;
    @FXML
    private ComboBox<?> consumptionOrderIdBox;
    @FXML
    private DatePicker consumptionDatePicker;
    @FXML
    private TextField consumptionSizeQuantityField;
    @FXML
    private TextField consumptionOrderQuantity;
    @FXML
    private TextField consumptionbuyerNameField;
    @FXML
    private ComboBox<?> consumptionSizeBox;
    @FXML
    private TableView<?> consumptionFabricComponentsTableView;
    @FXML
    private TableColumn<?, ?> consumptionFabricComponentTableColumn;
    @FXML
    private TableColumn<?, ?> consumptionFabricSewingAllowanceTableColumn;
    @FXML
    private ComboBox<?> consumptionFabricComponentBox;
    @FXML
    private TextField consumptionFabricPerPieceField;
    @FXML
    private TextField consumptionFabricPerDozenField;
    @FXML
    private TextField consumptionFabricAllowanceField;
    @FXML
    private TextField consumptionFabricWastageField;
    @FXML
    private TextField consumptionFabricGsmField;
    @FXML
    private TableView<?> consumptionThreadOperationsTableView;
    @FXML
    private TableColumn<?, ?> consumptionThreadOperationNameTableColumn;
    @FXML
    private TableColumn<?, ?> consumptionThreadSeamTableColumn;
    @FXML
    private TableColumn<?, ?> consumptionThreadStitchTypeTableColumn;
    @FXML
    private TableColumn<?, ?> consumptionThreadRatioTableColumn;
    @FXML
    private TableColumn<?, ?> consumptionThreadEstimatedTbleColumn;
    @FXML
    private ComboBox<?> consumptionThreadStitchTypeBox;
    @FXML
    private ComboBox<?> consumptionThreadOperationNameBox;
    @FXML
    private TextField consumptionThreadField;
    @FXML
    private TextField consumptionThreadEstimatedField;
    @FXML
    private TextField consumptionThreadInitialField;
    @FXML
    private TextField consumptionThreadRatioField;
    @FXML
    private TextField consumptionThreadSeamLengthField;
    @FXML
    private TextField consumptionThreadWastageField;
    @FXML
    private Text merchandiserConsumptionIdText;
    
    // Costing FXML
    @FXML
    private TextField costingOtherUnitPriceField;
    @FXML
    private TextField costingDyeingUnitPriceField;
    @FXML
    private TextField costingKnittingUnitPriceField;
    @FXML
    private TextField costingYarnUnitPriceField;
    @FXML
    private TextField costingOtherAmountField;
    @FXML
    private TextField costingDyeingAmountField;
    @FXML
    private TextField costingKnittingAmountField;
    @FXML
    private TextField costingYarnAmountField;
    @FXML
    private TextField costingOtherConsumptionField;
    @FXML
    private TextField costingDyeingConsumptionField;
    @FXML
    private TextField costingKnittingConsumptionField;
    @FXML
    private TextField costingYarnConsumptionField;
    @FXML
    private TextField costingFabAndProcPerDozentField;
    @FXML
    private TextArea costingFabricationArea;
    @FXML
    private TextField costingThreadUnitPriceField;
    @FXML
    private TextField costingThreadConsumptionField;
    @FXML
    private TextField costingThreadAmountField;
    @FXML
    private TextField costingAccessoriesAmountField;
    @FXML
    private ComboBox<?> costingAccessoriesItemBox;
    @FXML
    private TableView<?> costingAccessoriesItemsTableView;
    @FXML
    private TableColumn<?, ?> costingAccessoriesItemTableColumn;
    @FXML
    private TableColumn<?, ?> costingAccessoriesAmountTableColumn;
    @FXML
    private TextField costingFobPricePerDozenField;
    @FXML
    private TextField costingTotalPricePerDozenField;
    @FXML
    private TextField costingCommercialCostField;
    @FXML
    private TextField costingCmPerDozenField;
    @FXML
    private TextField costingTotalCostPerDozenField;
    @FXML
    private TextField costingLabTestCostField;
    @FXML
    private TextField costingTotalAccessoriesCostField;
    @FXML
    private ComboBox<?> costingCategoryField;
    @FXML
    private ComboBox<?> costingOrderIdBox;
    @FXML
    private DatePicker costingDatePicker;
    @FXML
    private TextField costingSizeQuantityField;
    @FXML
    private TextField costingOrderQuantityField;
    @FXML
    private TextField costingbuyerNameField;
    @FXML
    private ComboBox<?> costingSizeBox;
    @FXML
    private TextField costingDescriptionField;
    @FXML
    private Text merchandiserCostingIdText;
    @FXML
    private TextField costingFabricGsmField;
    
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
    private Text merchandiserChangePasswordMessageText;
    @FXML
    private Text merchandiserProfileIdText;
    
    // Required Lists
    private List<Buyer> buyers;
    private List<Order> orders;
    private List<Employee> employees;
    private List<User> users;
    
    // Required ObservableLists
    private ObservableList<Buyer> buyersView;
    private ObservableList<String> buyerNames;
    private ObservableList<Order> ordersView;
    
    // Required Global Variables
    private String merchandizerId;
    private Buyer buyer;
    private Order order;
    private Employee employee;
    private User user;
    
    // Required Variable Handle Batabase Actions
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set ComboBox Values
        /* Order Information */
        orderCategoryBox.getItems().addAll(OrderCategory.values());
        orderFloorNoBox.getItems().addAll(Floors.values());
        orderLineNoBox.getItems().addAll(Lines.values());
        orderCurrencyBox.getItems().addAll(Currency.values());
        
        // Instantiate Lists
        buyers = new ArrayList<>();
        orders = new ArrayList<>();
        users = new ArrayList<>();
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            buyers = session.createCriteria(Buyer.class).list();
            orders = session.createCriteria(Order.class).list();
            users = session.createCriteria(User.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        // Instantiate Observable Lists
        buyersView = FXCollections.observableArrayList();
        buyerNames = FXCollections.observableArrayList();
        
        // Set ObservableLists Values Related To Buyer
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getIsDeleted() == 0){
                buyersView.add(buyers.get(i));
                buyerNames.add(buyers.get(i).getBuyerName());
            }
        }
        orderBuyerNameBox.setItems(buyerNames);
        
        // Set Buyers To Table View
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
        // Set ObservableLists Values Related To Order
        ordersView = FXCollections.observableArrayList();
        for (int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderIsDeleted() == 0){
                ordersView.add(orders.get(i));
            }
        }
        
        // Set Orders To Table View
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderLastUpdatedBy()));
        
        buyerNameMatchingText.setText("");
        orderIdSearchMessageText.setText("");
    }    

    @FXML
    private void handleSearchBuyerNameAction(ActionEvent event) {
        buyerNameMatchingText.setText("");
        
        String buyerName = buyerNameField.getText();
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getBuyerName().equals(buyerName)){
                buyer = buyers.get(i);
                
                buyerNameField.setText(buyer.getBuyerName());
                buyerOfficeSiteNameField.setText(buyer.getOfficeSiteName());
                buyerCompanyBrandNameField.setText(buyer.getCompanyBrandName());
                buyerPhoneField.setText(buyer.getPhone());
                buyerEmailField.setText(buyer.getEmail());
                buyerAddressArea.setText(buyer.getAddress());
                buyerCityField.setText(buyer.getCity());
                buyerStateField.setText(buyer.getState());
                buyerZipCodeField.setText(buyer.getZipCode());
                buyerAreaCodeField.setText(buyer.getAreaCode());
                break;
            }
            else{
                buyerNameMatchingText.setText("Buyer Not Found. You Can Add This As New Buyer Name.");
            }
        }
    }

    @FXML
    private void handleAddBuyerAction(ActionEvent event) {
        buyerNameMatchingText.setText("");
        
        // Get Data From FXML
        String buyerName = buyerNameField.getText();
        String officeSiteName = buyerOfficeSiteNameField.getText();
        String companyBrandName = buyerCompanyBrandNameField.getText();
        String phone = buyerPhoneField.getText();
        String email = buyerEmailField.getText();
        String address = buyerAddressArea.getText();
        String city = buyerCityField.getText();
        String state = buyerStateField.getText();
        String zipCode = buyerZipCodeField.getText();
        String areaCode = buyerAreaCodeField.getText();
        
        // Get User ID
        String getIdText = merchandiserOrderIdText.getText();
        String idTokens[] = getIdText.split(" ");
        String user = idTokens[2];
        String addedBy = user;
        String lastUpdatedBy = user;
        
        // Instantiate Buyer Object
        Buyer buyer = new Buyer(buyerName, officeSiteName, companyBrandName, phone, email, address, city, state, zipCode, areaCode, addedBy, lastUpdatedBy);
        buyers.removeAll(buyers);
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            session.save(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        // Refresh Buyers Observable List
        buyersView.remove(0, buyersView.size());
        buyerNames.remove(0, buyerNames.size());
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getIsDeleted() == 0){
                buyersView.add(buyers.get(i));
                buyerNames.add(buyers.get(i).getBuyerName());
            }
        }
        orderBuyerNameBox.setItems(buyerNames);
        
        // Set Buyers To Table View
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
        // Refresh FXML
        buyerNameField.setText("");
        buyerOfficeSiteNameField.setText("");
        buyerCompanyBrandNameField.setText("");
        buyerPhoneField.setText("");
        buyerEmailField.setText("");
        buyerAddressArea.setText("");
        buyerCityField.setText("");
        buyerStateField.setText("");
        buyerZipCodeField.setText("");
        buyerAreaCodeField.setText("");
    }

    @FXML
    private void handleUpdateBuyerAction(ActionEvent event) {
        buyerNameMatchingText.setText("");
        
        // Get Data From FXML
        String buyerName = "";
        String officeSiteName = buyerOfficeSiteNameField.getText();
        String companyBrandName = buyerCompanyBrandNameField.getText();
        String phone = buyerPhoneField.getText();
        String email = buyerEmailField.getText();
        String address = buyerAddressArea.getText();
        String city = buyerCityField.getText();
        String state = buyerStateField.getText();
        String zipCode = buyerZipCodeField.getText();
        String areaCode = buyerAreaCodeField.getText();
        String addedBy = "";
        
        // Get User ID
        String getIdText = merchandiserOrderIdText.getText();
        String idTokens[] = getIdText.split(" ");
        String user = idTokens[2];
        String lastUpdatedBy = user;
        
        // Instantiate Buyer
        Buyer buyer = new Buyer(buyerName, officeSiteName, companyBrandName, phone, email, address, city, state, zipCode, areaCode, addedBy, lastUpdatedBy);
        buyer.setBuyerName(this.buyer.getBuyerName());
        buyer.setAddedBy(this.buyer.getAddedBy());
        buyers.removeAll(buyers);
        
        //Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            session.update(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        // Refresh Buyer ObservableLists
        buyersView.remove(0, buyersView.size());
        buyerNames.remove(0, buyerNames.size());
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getIsDeleted() == 0){
                buyersView.add(buyers.get(i));
                buyerNames.add(buyers.get(i).getBuyerName());
            }
        }
        orderBuyerNameBox.setItems(buyerNames);
        
        // Set Buyer To Table View
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
        // Refresh FXML
        buyerNameField.setText("");
        buyerOfficeSiteNameField.setText("");
        buyerCompanyBrandNameField.setText("");
        buyerPhoneField.setText("");
        buyerEmailField.setText("");
        buyerAddressArea.setText("");
        buyerCityField.setText("");
        buyerStateField.setText("");
        buyerZipCodeField.setText("");
        buyerAreaCodeField.setText("");
    }

    @FXML
    private void handleRemoveBuyerAction(ActionEvent event) {
        buyerNameMatchingText.setText("");
        
        // Get Data From FXML
        String buyerName = "";
        String officeSiteName = buyerOfficeSiteNameField.getText();
        String companyBrandName = buyerCompanyBrandNameField.getText();
        String phone = buyerPhoneField.getText();
        String email = buyerEmailField.getText();
        String address = buyerAddressArea.getText();
        String city = buyerCityField.getText();
        String state = buyerStateField.getText();
        String zipCode = buyerZipCodeField.getText();
        String areaCode = buyerAreaCodeField.getText();
        String addedBy = "";
        
        // Get User ID
        String getIdText = merchandiserOrderIdText.getText();
        String idTokens[] = getIdText.split(" ");
        String user = idTokens[2];
        String lastUpdatedBy = user;
        
        // Instantiate Buyer
        Buyer buyer = new Buyer(buyerName, officeSiteName, companyBrandName, phone, email, address, city, state, zipCode, areaCode, addedBy, lastUpdatedBy);
        buyer.setBuyerName(this.buyer.getBuyerName());
        buyer.setAddedBy(this.buyer.getAddedBy());
        buyer.setIsDeleted(1);
        buyers.removeAll(buyers);
        
        // Prepare Hibernate 
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            session.update(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        // Refresh Buyer ObservableLists
        buyersView.remove(0, buyersView.size());
        buyerNames.remove(0, buyerNames.size());
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getIsDeleted() == 0){
                buyersView.add(buyers.get(i));
                buyerNames.add(buyers.get(i).getBuyerName());
            }
        }
        orderBuyerNameBox.setItems(buyerNames);
        
        // Set Buyers To Table View
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
        // Refresh FXML
        buyerNameField.setText("");
        buyerOfficeSiteNameField.setText("");
        buyerCompanyBrandNameField.setText("");
        buyerPhoneField.setText("");
        buyerEmailField.setText("");
        buyerAddressArea.setText("");
        buyerCityField.setText("");
        buyerStateField.setText("");
        buyerZipCodeField.setText("");
        buyerAreaCodeField.setText("");
    }

    @FXML
    private void handleRefreshBuyerAction(ActionEvent event) {
        buyerNameMatchingText.setText("");
        
        buyerNameField.setText("");
        buyerOfficeSiteNameField.setText("");
        buyerCompanyBrandNameField.setText("");
        buyerPhoneField.setText("");
        buyerEmailField.setText("");
        buyerAddressArea.setText("");
        buyerCityField.setText("");
        buyerStateField.setText("");
        buyerZipCodeField.setText("");
        buyerAreaCodeField.setText("");
    }

    @FXML
    private void handleSelectBuyerAcion(MouseEvent event) {
        buyerNameMatchingText.setText("");
        
        // Get Selected Buyer
        buyer = buyersTableView.getSelectionModel().getSelectedItem();
        
        // Set Buyer Information To FXML
        buyerNameField.setText(buyer.getBuyerName());
        buyerOfficeSiteNameField.setText(buyer.getOfficeSiteName());
        buyerCompanyBrandNameField.setText(buyer.getCompanyBrandName());
        buyerPhoneField.setText(buyer.getPhone());
        buyerEmailField.setText(buyer.getEmail());
        buyerAddressArea.setText(buyer.getAddress());
        buyerCityField.setText(buyer.getCity());
        buyerStateField.setText(buyer.getState());
        buyerZipCodeField.setText(buyer.getZipCode());
        buyerAreaCodeField.setText(buyer.getAreaCode());
    }

    @FXML
    private void handleBuyerNameMathcingAction(KeyEvent event) {
        if(event.getCode() != KeyCode.ENTER){
            buyerNameMatchingText.setText("");

            String buyerName = buyerNameField.getText();

            for (int i = 0; i < buyers.size(); i++){
                if(buyers.get(i).getBuyerName().equals(buyerName)){
                    buyerNameMatchingText.setText("Buyer Name Already Taken. Press Enter to View Information.");
                    break;
                }
            }
        }
    }

    @FXML
    private void handleSignOutBuyerAction(ActionEvent event) {
        try {
            merchandizerId = "";
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
    private void handleSignOutOrderAction(ActionEvent event) {
        try {
            merchandizerId = "";
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
    private void handleSearchOrderIdAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        // Get Order ID From FXML
        int orderId = Integer.parseInt(orderIdField.getText());
        
        // Match Order ID And Perform Actions
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getOrderId() == orderId){
                order = orders.get(i);
                
                orderIdField.setText(order.getOrderId() + "");
                orderNameField.setText(order.getOrderName());
                orderBuyerNameBox.getSelectionModel().select(order.getBuyerName());
                orderBuyerReqirementsField.setText(order.getBuyerRequirements());
                orderDescriptionArea.setText(order.getOrderDescription());
                orderPriorityField.setText(order.getOrderPriority());
                orderQuantityField.setText(order.getOrderQuantity() + "");
                orderCategoryBox.getSelectionModel().select(OrderCategory.valueOf(order.getOrderCategory()));
                orderSmvField.setText(order.getOrderSmv() + "");
                orderDeliveryDatePicker.getEditor().setText(order.getOrderDeliveryDate());
                orderCostField.setText(order.getOrderCost() + "");
                orderCurrencyBox.getSelectionModel().select(Currency.valueOf(order.getOrderCurrency()));
                orderInternalCommentsField.setText(order.getOrderInternalComments());
                break;
            }
            else{
                orderIdSearchMessageText.setText("Order Not Found. Please Try With Different ID");
            }
        }
    }

    @FXML
    private void handleSelectOrderAction(MouseEvent event) {
        orderIdSearchMessageText.setText("");
        
        // Get Selected Order
        order = ordersTableView.getSelectionModel().getSelectedItem();
        
        // Set Order Information To FXML
        orderIdField.setText(order.getOrderId() + "");
        orderNameField.setText(order.getOrderName());
        orderBuyerNameBox.getSelectionModel().select(order.getBuyerName());
        orderBuyerReqirementsField.setText(order.getBuyerRequirements());
        orderDescriptionArea.setText(order.getOrderDescription());
        orderPriorityField.setText(order.getOrderPriority());
        orderFloorNoBox.getSelectionModel().select(Floors.valueOf(order.getOrderFloorNo()));
        orderLineNoBox.getSelectionModel().select(Lines.valueOf(order.getOrderLineNo()));
        orderQuantityField.setText(order.getOrderQuantity() + "");
        orderCategoryBox.getSelectionModel().select(OrderCategory.valueOf(order.getOrderCategory()));
        orderSmvField.setText(order.getOrderSmv() + "");
        orderDeliveryDatePicker.getEditor().setText(order.getOrderDeliveryDate());
        orderCostField.setText(order.getOrderCost() + "");
        orderCurrencyBox.getSelectionModel().select(Currency.valueOf(order.getOrderCurrency()));
        orderInternalCommentsField.setText(order.getOrderInternalComments());
    }

    @FXML
    private void handleOrderAddAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        // Get Data From FXML
        int orderId = 0;
        String orderName = orderNameField.getText();
        String buyerName = orderBuyerNameBox.getSelectionModel().getSelectedItem();
        String buyerRequirements = orderBuyerReqirementsField.getText();
        String orderDescription = orderDescriptionArea.getText();
        String orderPriority = orderPriorityField.getText();
        int orderQuantity = Integer.parseInt(orderQuantityField.getText());
        String orderFloorNo = orderFloorNoBox.getSelectionModel().getSelectedItem() + "";
        String orderLineNo = orderLineNoBox.getSelectionModel().getSelectedItem() + "";
        String orderCategory = orderCategoryBox.getSelectionModel().getSelectedItem() + "";
        double orderSmv = Double.parseDouble(orderSmvField.getText());
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate= new Date();
        String orderDate = format.format(currentDate);
        String orderDeliveryDate = orderDeliveryDatePicker.getEditor().getText();
        double orderCost = Double.parseDouble(orderCostField.getText());
        String orderCurrency = orderCurrencyBox.getSelectionModel().getSelectedItem() + "";
        String orderInternalComments = orderInternalCommentsField.getText();
        
        // Get User ID
        String getIdText = merchandiserOrderIdText.getText();
        String idTokens[] = getIdText.split(" ");
        String user = idTokens[2];
        String orderAddedBy = user;
        String orderLastUpdatedBy = user;
        
        // Instantiate Order
        Order addOrder = new Order(orderId, orderName, buyerName, buyerRequirements, orderDescription, orderPriority, orderQuantity, orderFloorNo, orderLineNo, orderCategory, orderSmv, orderDate, orderDeliveryDate, orderCost, orderCurrency, orderInternalComments, orderAddedBy, orderLastUpdatedBy);
        orders.removeAll(orders);
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            session.save(addOrder);
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
            System.out.println("Transaction Roll Backed");
        }
        session.close();
        
        // Refresh Order ObservableLists
        ordersView.remove(0, ordersView.size());
        for (int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderIsDeleted() == 0){
                ordersView.add(orders.get(i));
            }
        }
        
        // Set Order To TableView
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderLastUpdatedBy()));
        
        // Refresh FXML
        orderIdField.setText("");
        orderNameField.setText("");
        orderBuyerNameBox.getSelectionModel().clearSelection();
        orderBuyerReqirementsField.setText("");
        orderDescriptionArea.setText("");
        orderPriorityField.setText("");
        orderFloorNoBox.getSelectionModel().clearSelection();
        orderLineNoBox.getSelectionModel().clearSelection();
        orderQuantityField.setText("");
        orderCategoryBox.getSelectionModel().clearSelection();
        orderSmvField.setText("");
        orderDeliveryDatePicker.getEditor().setText("");
        orderCostField.setText("");
        orderCurrencyBox.getSelectionModel().clearSelection();
        orderInternalCommentsField.setText("");
    }

    @FXML
    private void handleUpdateOrderAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        // Get Data From FXML
        int orderId = 0; 
        String orderName = orderNameField.getText();
        String buyerName = orderBuyerNameBox.getSelectionModel().getSelectedItem();
        String buyerRequirements = orderBuyerReqirementsField.getText();
        String description = orderDescriptionArea.getText();
        String priority = orderPriorityField.getText();
        int quantity = Integer.parseInt(orderQuantityField.getText());
        String orderFloorNo = orderFloorNoBox.getSelectionModel().getSelectedItem() + "";
        String orderLineNo = orderLineNoBox.getSelectionModel().getSelectedItem() + "";
        String category = orderCategoryBox.getSelectionModel().getSelectedItem() + "";
        double smv = Double.parseDouble(orderSmvField.getText());
        String orderDate = "";
        String deliveryDate = orderDeliveryDatePicker.getEditor().getText();
        double cost = Double.parseDouble(orderCostField.getText());
        String currency = orderCurrencyBox.getSelectionModel().getSelectedItem() + "";
        String internalComments = orderInternalCommentsField.getText();
        String addedBy = "";
        
        // Get User ID
        String getIdText = merchandiserOrderIdText.getText();
        String idTokens[] = getIdText.split(" ");
        String user = idTokens[2];
        String lastUpdatedBy = user;
        
        // Instantiate Order
        Order order = new Order(orderId, orderName, buyerName, buyerRequirements, description, priority, quantity, orderFloorNo, orderLineNo, category, smv, orderDate, deliveryDate, cost, currency, internalComments, addedBy, lastUpdatedBy);
        order.setOrderId(this.order.getOrderId());
        order.setOrderDate(this.order.getOrderDate());
        order.setOrderAddedBy(this.order.getOrderAddedBy());
        orders.removeAll(orders);
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            session.update(order);
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        // Refresh Order ObservableLists
        ordersView.remove(0, ordersView.size());
        for (int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderIsDeleted() == 0){
                ordersView.add(orders.get(i));
            }
        }
        
        // Set Order To TableView
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderLastUpdatedBy()));
        
        // Refresh FXML
        orderIdField.setText("");
        orderNameField.setText("");
        orderBuyerNameBox.getSelectionModel().clearSelection();
        orderBuyerReqirementsField.setText("");
        orderDescriptionArea.setText("");
        orderPriorityField.setText("");
        orderFloorNoBox.getSelectionModel().clearSelection();
        orderLineNoBox.getSelectionModel().clearSelection();
        orderQuantityField.setText("");
        orderCategoryBox.getSelectionModel().clearSelection();
        orderSmvField.setText("");
        orderDeliveryDatePicker.getEditor().setText("");
        orderCostField.setText("");
        orderCurrencyBox.getSelectionModel().clearSelection();
        orderInternalCommentsField.setText("");
    }

    @FXML
    private void handleRemoveOrderAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        // Get Data From FXML
        int orderId = Integer.parseInt(orderIdField.getText());
        String orderName = orderNameField.getText();
        String buyerName = orderBuyerNameBox.getSelectionModel().getSelectedItem();
        String buyerRequirements = orderBuyerReqirementsField.getText();
        String description = orderDescriptionArea.getText();
        String priority = orderPriorityField.getText();
        int quantity = Integer.parseInt(orderQuantityField.getText());
        String orderFloorNo = orderFloorNoBox.getSelectionModel().getSelectedItem() + "";
        String orderLineNo = orderLineNoBox.getSelectionModel().getSelectedItem() + "";
        String category = orderCategoryBox.getSelectionModel().getSelectedItem() + "";
        double smv = Double.parseDouble(orderSmvField.getText());
        String orderDate = "";
        String deliveryDate = orderDeliveryDatePicker.getEditor().getText();
        double cost = Double.parseDouble(orderCostField.getText());
        String currency = orderCurrencyBox.getSelectionModel().getSelectedItem() + "";
        String internalComments = orderInternalCommentsField.getText();
        String addedBy = "";
        
        // Get User ID
        String getIdText = merchandiserOrderIdText.getText();
        String idTokens[] = getIdText.split(" ");
        String user = idTokens[2];
        String lastUpdatedBy = user;
        
        // Instantiate Order
        Order order = new Order(orderId, orderName, buyerName, buyerRequirements, description, priority, quantity, orderFloorNo, orderLineNo, category, smv, orderDate, deliveryDate, cost, currency, internalComments, addedBy, lastUpdatedBy);
        order.setOrderId(this.order.getOrderId());
        order.setOrderDate(this.order.getOrderDate());
        order.setOrderAddedBy(this.order.getOrderAddedBy());
        order.setOrderIsDeleted(1);
        orders.removeAll(orders);
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            session.update(order);
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        // Refresh Order ObservableLists
        ordersView.remove(0, ordersView.size());
        for (int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderIsDeleted() == 0){
                ordersView.add(orders.get(i));
            }
        }
        
        // Set Order To TableView
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderLastUpdatedBy()));
        
        // Refresh FXML
        orderIdField.setText("");
        orderNameField.setText("");
        orderBuyerNameBox.getSelectionModel().clearSelection();
        orderBuyerReqirementsField.setText("");
        orderDescriptionArea.setText("");
        orderPriorityField.setText("");
        orderFloorNoBox.getSelectionModel().clearSelection();
        orderLineNoBox.getSelectionModel().clearSelection();
        orderQuantityField.setText("");
        orderCategoryBox.getSelectionModel().clearSelection();
        orderSmvField.setText("");
        orderDeliveryDatePicker.getEditor().setText("");
        orderCostField.setText("");
        orderCurrencyBox.getSelectionModel().clearSelection();
        orderInternalCommentsField.setText("");
    }

    @FXML
    private void handleRefreshOrderAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        orderIdField.setText("");
        orderNameField.setText("");
        orderBuyerNameBox.getSelectionModel().clearSelection();
        orderBuyerReqirementsField.setText("");
        orderDescriptionArea.setText("");
        orderPriorityField.setText("");
        orderQuantityField.setText("");
        orderCategoryBox.getSelectionModel().clearSelection();
        orderSmvField.setText("");
        orderDeliveryDatePicker.getEditor().setText("");
        orderCostField.setText("");
        orderCurrencyBox.getSelectionModel().clearSelection();
        orderInternalCommentsField.setText("");
    }
    
    public void setMerchandiserId(String username){
        this.merchandizerId = username;
        merchandiserBuyerIdText.setText("Merchandizer ID: " + username);
        merchandiserOrderIdText.setText("Merchandizer ID: " + username);
        merchandiserProfileIdText.setText("Merchandizer ID: " + username);
        merchandiserConsumptionIdText.setText("Merchandizer ID: " + username);
        
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
        merchandiserChangePasswordMessageText.setText("");
        String password = profileNewPasswordField.getText();
        String reTypePassword = profileRetypeNewPasswordField.getText();
        
        int isMatched = 0;
        if(!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)){
            isMatched = 1;
        }
        else if(!password.equals("") && !reTypePassword.equals("") && !password.equals(reTypePassword) && password != null && reTypePassword != null){
            merchandiserChangePasswordMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }

    @FXML
    private void handleChangePasswordMatchAction(KeyEvent event) {
        merchandiserChangePasswordMessageText.setText("");
        String password = profileNewPasswordField.getText();
        String reTypePassword = profileRetypeNewPasswordField.getText();
        
        int isMatched = 0;
        if(!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)){
            isMatched = 1;
        }
        else if(!password.equals("") && !reTypePassword.equals("") && !password.equals(reTypePassword) && password != null && reTypePassword != null){
            merchandiserChangePasswordMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }

    @FXML
    private void handleMerchandiserChangePasswordAction(ActionEvent event) {
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
            merchandiserChangePasswordMessageText.setText(e + "");
            transaction.rollback();
        }
        session.close();
        
        // Refresh FXML
        profileOldPasswordField.setText("");
        profileNewPasswordField.setText("");
        profileRetypeNewPasswordField.setText("");
    }

    @FXML
    private void handleMerchandiserProfileSignOutAction(ActionEvent event) {
        try {
            merchandizerId = "";
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
    private void handleConsumptionOrderIdAction(ActionEvent event) {
    }

    @FXML
    private void handleSelectFabricConsumptionComponentAction(MouseEvent event) {
    }

    @FXML
    private void handleFabricConsumptionComponentRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleFabricConsumptionComponentAddAction(ActionEvent event) {
    }

    @FXML
    private void handleSelectThreadConsumptionOperationAction(MouseEvent event) {
    }

    @FXML
    private void handleThreadConsumptionOperationRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleThreadConsumptionOperationAddAction(ActionEvent event) {
    }

    @FXML
    private void handleSignOutConsumptionAction(ActionEvent event) {
    }

    @FXML
    private void handleConsumptionSaveAction(ActionEvent event) {
    }

    @FXML
    private void handleConsumptionPrintAction(ActionEvent event) {
    }

    @FXML
    private void handleConsumptionRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleConsumptionRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleSignOutCostingAction(ActionEvent event) {
    }

    @FXML
    private void handleSaveCostingAction(ActionEvent event) {
    }

    @FXML
    private void handleRemoveCostingAction(ActionEvent event) {
    }

    @FXML
    private void handleRefreshCostingAction(ActionEvent event) {
    }

    @FXML
    private void handleCostingAccessoriesItemRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleCostingAccessoriesItemAddAction(ActionEvent event) {
    }

    @FXML
    private void handleSelectCostingAccessoriesItemAction(MouseEvent event) {
    }

    @FXML
    private void handleCostingOrderIdAction(ActionEvent event) {
    }
}
