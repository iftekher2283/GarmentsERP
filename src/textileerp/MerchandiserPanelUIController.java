/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import enums.AccessoriesItems;
import enums.ConsumptionComponent;
import enums.ConsumptionOperationName;
import enums.ConsumptionStitchType;
import enums.Currency;
import enums.Floors;
import enums.Lines;
import enums.OrderCategory;
import enums.Size;
import hibernatesingleton.HibernateSingleton;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
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
import model.Consumption;
import model.Costing;
import model.CostingAccessories;
import model.CostingAccessoriesItem;
import model.CostingDyeing;
import model.CostingKnitting;
import model.CostingOthers;
import model.CostingThread;
import model.CostingYarn;
import model.Employee;
import model.FabricConsumption;
import model.FabricConsumptionComponents;
import model.Order;
import model.ThreadConsumption;
import model.ThreadConsumptionOperation;
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
    private ComboBox<OrderCategory> consumptionCategoryBox;
    @FXML
    private ComboBox<String> consumptionOrderIdBox;
    @FXML
    private DatePicker consumptionDatePicker;
    @FXML
    private TextField consumptionSizeQuantityField;
    @FXML
    private TextField consumptionOrderQuantity;
    @FXML
    private TextField consumptionbuyerNameField;
    @FXML
    private ComboBox<Size> consumptionSizeBox;
    @FXML
    private TableView<FabricConsumptionComponents> consumptionFabricComponentsTableView;
    @FXML
    private TableColumn<FabricConsumptionComponents, String> consumptionFabricComponentTableColumn;
    @FXML
    private TableColumn<FabricConsumptionComponents, Number> consumptionFabricValueTableColumn;
    @FXML
    private TableColumn<FabricConsumptionComponents, Number> consumptionFabricSewingAllowanceTableColumn;
    @FXML
    private ComboBox<ConsumptionComponent> consumptionFabricComponentBox;
    @FXML
    private TextField consumptionFabricComponentValueField;
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
    private TableView<ThreadConsumptionOperation> consumptionThreadOperationsTableView;
    @FXML
    private TableColumn<ThreadConsumptionOperation, String> consumptionThreadOperationNameTableColumn;
    @FXML
    private TableColumn<ThreadConsumptionOperation, Number> consumptionThreadSeamTableColumn;
    @FXML
    private TableColumn<ThreadConsumptionOperation, String> consumptionThreadStitchTypeTableColumn;
    @FXML
    private TableColumn<ThreadConsumptionOperation, Number> consumptionThreadRatioTableColumn;
    @FXML
    private TableColumn<ThreadConsumptionOperation, Number> consumptionThreadEstimatedTbleColumn;
    @FXML
    private ComboBox<ConsumptionStitchType> consumptionThreadStitchTypeBox;
    @FXML
    private ComboBox<ConsumptionOperationName> consumptionThreadOperationNameBox;
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
    private ComboBox<AccessoriesItems> costingAccessoriesItemBox;
    @FXML
    private TableView<CostingAccessoriesItem> costingAccessoriesItemsTableView;
    @FXML
    private TableColumn<CostingAccessoriesItem, String> costingAccessoriesItemTableColumn;
    @FXML
    private TableColumn<CostingAccessoriesItem, Number> costingAccessoriesAmountTableColumn;
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
    private ComboBox<OrderCategory> costingCategoryBox;
    @FXML
    private ComboBox<String> costingOrderIdBox;
    @FXML
    private DatePicker costingDatePicker;
    @FXML
    private TextField costingSizeQuantityField;
    @FXML
    private TextField costingOrderQuantityField;
    @FXML
    private TextField costingbuyerNameField;
    @FXML
    private ComboBox<Size> costingSizeBox;
    @FXML
    private TextField costingDescriptionField;
    @FXML
    private Text merchandiserCostingIdText;
    @FXML
    private TextField costingFabricGsmField;
    @FXML
    private Text costingHandleActionDoneMessageText;
    @FXML
    private Text costingHandleActionNotDoneMessageText;

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
    private List<Consumption> consumptions;
    private List<FabricConsumption> fabricConsumptions;
    private List<ThreadConsumption> threadConsumptions;
    private List<FabricConsumptionComponents> fabricConsumptionComponents;
    private List<ThreadConsumptionOperation> threadConsumptionOperations;
    private List<Costing> costings;
    private List<CostingYarn> costingYarns;
    private List<CostingKnitting> costingKnittings;
    private List<CostingDyeing> costingDyeings;
    private List<CostingThread> costingThreads;
    private List<CostingOthers> costingOthers;
    private List<CostingAccessories> costingAccessorieses;
    private List<CostingAccessoriesItem> costingAccessoriesItems;

    // Required ObservableLists
    private ObservableList<Buyer> buyersView;
    private ObservableList<String> buyerNames;
    private ObservableList<Order> ordersView;
    private ObservableList<String> orderIds;
    private ObservableList<FabricConsumptionComponents> fabricConsumptionComponentsView;
    private ObservableList<ThreadConsumptionOperation> threadConsumptionOperationsView;
    private ObservableList<CostingAccessoriesItem> costingAccessoriesItemsView;

    // Required Global Variables
    private String merchandizerId;
    private Buyer buyer;
    private Order order;
    private Employee employee;
    private User user;
    private Consumption consumption;
    private FabricConsumption fabricConsumption;
    private FabricConsumptionComponents fabricConsumptionComponent;
    private ThreadConsumption threadConsumption;
    private ThreadConsumptionOperation threadConsumptionOperation;
    private Costing costing;
    private CostingYarn costingYarn;
    private CostingKnitting costingKnitting;
    private CostingDyeing costingDyeing;
    private CostingThread costingThread;
    private CostingOthers costingOther;
    private CostingAccessories costingAccessories;
    private CostingAccessoriesItem costingAccessoriesItem;

    // Required Variable Handle Batabase Actions
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    @FXML
    private Text consumptionActionNotDoneMessageText;
    @FXML
    private Text consumptionActionDoneMessageText;
    @FXML
    private Text changePasswordActionDoneMessageText;
    @FXML
    private Text orderActionNotDoneMessageText;
    @FXML
    private Text orderActionDoneMessageText;
    @FXML
    private Text buyerActionNotDoneMessageText;
    @FXML
    private Text buyerActionDoneMessageText;

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
        consumptions = new ArrayList<>();
        fabricConsumptions = new ArrayList<>();
        threadConsumptions = new ArrayList<>();
        fabricConsumptionComponents = new ArrayList<>();
        threadConsumptionOperations = new ArrayList<>();
        costings = new ArrayList<>();
        costingYarns = new ArrayList<>();
        costingKnittings = new ArrayList<>();
        costingDyeings = new ArrayList<>();
        costingThreads = new ArrayList<>();
        costingOthers = new ArrayList<>();
        costingAccessorieses = new ArrayList<>();
        costingAccessoriesItems = new ArrayList<>();
    
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        // Database Actions
        try {
            buyers = session.createCriteria(Buyer.class).list();
            orders = session.createCriteria(Order.class).list();
            users = session.createCriteria(User.class).list();
            fabricConsumptionComponents = session.createCriteria(FabricConsumptionComponents.class).list();
            threadConsumptionOperations = session.createCriteria(ThreadConsumptionOperation.class).list();
            fabricConsumptions = session.createCriteria(FabricConsumption.class).list();
            threadConsumptions = session.createCriteria(ThreadConsumption.class).list();
            consumptions = session.createCriteria(Consumption.class).list();
            costingAccessoriesItems = session.createCriteria(CostingAccessoriesItem.class).list();
            costingAccessorieses = session.createCriteria(CostingAccessories.class).list();
            costingYarns = session.createCriteria(CostingYarn.class).list();
            costingKnittings = session.createCriteria(CostingKnitting.class).list();
            costingDyeings = session.createCriteria(CostingDyeing.class).list();
            costingThreads = session.createCriteria(CostingThread.class).list();
            costingOthers = session.createCriteria(CostingOthers.class).list();
            costings = session.createCriteria(Costing.class).list();
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
        }
        session.close();

        // Instantiate Observable Lists
        buyersView = FXCollections.observableArrayList();
        buyerNames = FXCollections.observableArrayList();
        ordersView = FXCollections.observableArrayList();
        orderIds = FXCollections.observableArrayList();
        fabricConsumptionComponentsView = FXCollections.observableArrayList();
        threadConsumptionOperationsView = FXCollections.observableArrayList();

        // Set ObservableLists Values Related To Buyer
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getIsDeleted() == 0) {
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
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderIsDeleted() == 0) {
                ordersView.add(orders.get(i));
                orderIds.add(orders.get(i).getOrderId() + "");
            }
        }

        // Set OrderIds to Combo Box
        consumptionOrderIdBox.setItems(orderIds);
        costingOrderIdBox.setItems(orderIds);

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
        buyerActionDoneMessageText.setText("");
        buyerActionNotDoneMessageText.setText("");

        String buyerName = buyerNameField.getText();
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getBuyerName().equals(buyerName)) {
                buyer = buyers.get(i);
                
                buyerActionDoneMessageText.setText("Buyer Found");
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
            } else {
                buyerNameMatchingText.setText("Buyer Not Found. You Can Add This As New Buyer Name.");
            }
        }
    }
    
    @FXML
    private void handleSaveBuyerAction(ActionEvent event) {
        buyerNameMatchingText.setText("");
        buyerActionDoneMessageText.setText("");
        buyerActionNotDoneMessageText.setText("");

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
        String addedBy = "";

        // Get User ID
        String getIdText = merchandiserOrderIdText.getText();
        String idTokens[] = getIdText.split(" ");
        String user = idTokens[2];
        String lastUpdatedBy = user;

        // Instantiate Buyer
        Buyer buyer = new Buyer(buyerName, officeSiteName, companyBrandName, phone, email, address, city, state, zipCode, areaCode, addedBy, lastUpdatedBy);
        
        // Check if employee is already in database
        int isAddedBefore = 0;
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getBuyerName().equals(buyer.getBuyerName())){
                isAddedBefore = 1;
                break;
            }
        }
        buyers.removeAll(buyers);

        //Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        // Database Actions
        try {
            if(isAddedBefore == 0){
                session.save(buyer);
            }else if(isAddedBefore == 1){
                buyer.setBuyerName(this.buyer.getBuyerName());
                buyer.setAddedBy(this.buyer.getAddedBy());
                session.update(buyer);
            }
            session.update(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
            
            buyerActionDoneMessageText.setText("Buyer Saved To Database Successfully");
        } catch (Exception e) {
            buyerActionNotDoneMessageText.setText("Buyer Couldn't Be Saved");
            transaction.rollback();
        }
        session.close();

        // Refresh Buyer ObservableLists
        buyersView.remove(0, buyersView.size());
        buyerNames.remove(0, buyerNames.size());
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getIsDeleted() == 0) {
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
        this.buyer = new Buyer();
    }
    
    @FXML
    private void handleRemoveBuyerAction(ActionEvent event) {
        buyerNameMatchingText.setText("");
        buyerActionDoneMessageText.setText("");
        buyerActionNotDoneMessageText.setText("");

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
        try {
            session.update(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
            buyerActionDoneMessageText.setText("Buyer Removed Successfully");
        } catch (Exception e) {
            buyerActionNotDoneMessageText.setText("Buyer Coludn't Be Removed");
            transaction.rollback();
        }
        session.close();

        // Refresh Buyer ObservableLists
        buyersView.remove(0, buyersView.size());
        buyerNames.remove(0, buyerNames.size());
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getIsDeleted() == 0) {
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
        this.buyer = new Buyer();
    }
    
    @FXML
    private void handlePrintBuyerAction(ActionEvent event) {
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
        this.buyer = new Buyer();
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
        String buyerName = buyerNameField.getText();
        if (buyerName != null) {
            buyerNameMatchingText.setText("");

            for (int i = 0; i < buyers.size(); i++) {
                if (buyers.get(i).getBuyerName().equals(buyerName)) {
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
        orderActionDoneMessageText.setText("");
        orderActionNotDoneMessageText.setText("");
        
        // Get Order ID From FXML
        int orderId = Integer.parseInt(orderIdField.getText());

        // Match Order ID And Perform Actions
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == orderId) {
                order = orders.get(i);
                
                orderActionDoneMessageText.setText("Order Found");
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
            } else {
                orderIdSearchMessageText.setText("Order Not Found. Please Try With Different ID");
            }
        }
    }

    @FXML
    private void handleSelectOrderAction(MouseEvent event) {
        orderIdSearchMessageText.setText("");
        orderActionDoneMessageText.setText("");
        orderActionNotDoneMessageText.setText("");

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
    private void handleOrderSaveAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        orderActionDoneMessageText.setText("");
        orderActionNotDoneMessageText.setText("");
        
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
        Date currentDate = new Date();
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
        
        // Check if employee is already in database
        int isAddedBefore = 0;
        for (int i = 0; i < orders.size(); i++){
            if(order != null){
                if(orders.get(i).getOrderId() == order.getOrderId()){
                    isAddedBefore = 1;
                    break;
                }
            }
        }
        orders.removeAll(orders);
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        // Database Actions
        try {
            if(isAddedBefore == 0){
                session.save(addOrder);
            }else if(isAddedBefore == 1){
                addOrder.setOrderId(this.order.getOrderId());
                addOrder.setOrderAddedBy(this.order.getOrderAddedBy());
                session.update(addOrder);
            }
            orders = session.createCriteria(Order.class).list();
            orderActionDoneMessageText.setText("Order Saved To Database Successfully");
            transaction.commit();
        } catch (Exception e) {
            orderActionNotDoneMessageText.setText("Order Couldn't Be Saved");
            transaction.rollback();
        }
        session.close();

        // Refresh Order ObservableLists
        ordersView.remove(0, ordersView.size());
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderIsDeleted() == 0) {
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
        this.order = new Order();
    }
    
    @FXML
    private void handlePrintOrderAction(ActionEvent event) {
    }
    
    @FXML
    private void handleRemoveOrderAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        orderActionDoneMessageText.setText("");
        orderActionNotDoneMessageText.setText("");

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
        try {
            session.update(order);
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
            
            orderActionDoneMessageText.setText("Order Removed Successfully");
        } catch (Exception e) {
            orderActionNotDoneMessageText.setText("Order Couldn't Be Removed");
            transaction.rollback();
        }
        session.close();

        // Refresh Order ObservableLists
        ordersView.remove(0, ordersView.size());
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderIsDeleted() == 0) {
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
        this.order = new Order();
    }

    @FXML
    private void handleRefreshOrderAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        order = new Order();
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

    public void setMerchandiserId(String username) {
        this.merchandizerId = username;
        merchandiserBuyerIdText.setText("Merchandizer ID: " + username);
        merchandiserOrderIdText.setText("Merchandizer ID: " + username);
        merchandiserProfileIdText.setText("Merchandizer ID: " + username);
        merchandiserConsumptionIdText.setText("Merchandizer ID: " + username);
        merchandiserCostingIdText.setText("Merchandizer ID: " + username);

        employees = new ArrayList<>();

        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        // Database Actions
        try {
            employees = session.createCriteria(Employee.class).list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
        session.close();

        // Get Employee Information Using ID
        for (int i = 0; i < employees.size(); i++) {
            if (username.equals(employees.get(i).getId())) {
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
        if (!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)) {
            isMatched = 1;
        } else if (!password.equals("") && !reTypePassword.equals("") && !password.equals(reTypePassword) && password != null && reTypePassword != null) {
            merchandiserChangePasswordMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }

    @FXML
    private void handleChangePasswordMatchAction(KeyEvent event) {
        merchandiserChangePasswordMessageText.setText("");
        String password = profileNewPasswordField.getText();
        String reTypePassword = profileRetypeNewPasswordField.getText();

        int isMatched = 0;
        if (!password.equals("") && !reTypePassword.equals("") && password.equals(reTypePassword)) {
            isMatched = 1;
        } else if (!password.equals("") && !reTypePassword.equals("") && !password.equals(reTypePassword) && password != null && reTypePassword != null) {
            merchandiserChangePasswordMessageText.setText("Please Enter Same Password in Both Fields");
        }
    }

    @FXML
    private void handleMerchandiserChangePasswordAction(ActionEvent event) {
        merchandiserChangePasswordMessageText.setText("");
        changePasswordActionDoneMessageText.setText("");
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
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmployeeId().equals(username) && users.get(i).getPassword().equals(password)) {
                user = users.get(i);
                break;
            }
        }

        // Set User's New Password
        if (getNewPass.equals(getNewRePass)) {
            user.setPassword(newPassword);
        }

        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        // Database Actions
        try {
            session.update(user);
            transaction.commit();
            changePasswordActionDoneMessageText.setText("Password Changed");
        } catch (Exception e) {
            merchandiserChangePasswordMessageText.setText("Password Couldn't Changed");
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
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("Please Select Size To Manage Consumption");
        
        // Get Order Id From FXML
        int orderId = Integer.parseInt(consumptionOrderIdBox.getSelectionModel().getSelectedItem());
        
        // Refresh Combo Box Values
        consumptionSizeBox.getItems().removeAll(Size.values());
        consumptionCategoryBox.getItems().removeAll(OrderCategory.values());
        consumptionFabricComponentBox.getItems().removeAll(ConsumptionComponent.values());
        consumptionThreadOperationNameBox.getItems().removeAll(ConsumptionOperationName.values());
        consumptionThreadStitchTypeBox.getItems().removeAll(ConsumptionStitchType.values());
        consumptionSizeBox.getItems().addAll(Size.values());
        consumptionCategoryBox.getItems().addAll(OrderCategory.values());
        consumptionFabricComponentBox.getItems().addAll(ConsumptionComponent.values());
        consumptionThreadOperationNameBox.getItems().addAll(ConsumptionOperationName.values());
        consumptionThreadStitchTypeBox.getItems().addAll(ConsumptionStitchType.values());
        
        // Get Order Using Id
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == orderId) {
                order = orders.get(i);
                consumptionbuyerNameField.setText("");
                consumptionCategoryBox.getSelectionModel().clearSelection();
                consumptionOrderQuantity.setText("");
                consumptionbuyerNameField.setText(order.getBuyerName());
                consumptionCategoryBox.getSelectionModel().select(OrderCategory.valueOf(order.getOrderCategory()));
                consumptionOrderQuantity.setText(order.getOrderQuantity() + "");
                consumptionDatePicker.getEditor().setText("");
                consumptionSizeBox.getSelectionModel().clearSelection();
                consumptionSizeQuantityField.setText("0");
                consumptionFabricGsmField.setText("0");
                consumptionFabricWastageField.setText("0");
                consumptionFabricPerDozenField.setText("0");
                consumptionFabricPerPieceField.setText("0");
                consumptionThreadWastageField.setText("0");
                consumptionThreadField.setText("0");

                fabricConsumptionComponentsView = FXCollections.observableArrayList();
                threadConsumptionOperationsView = FXCollections.observableArrayList();

                consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
                consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);
                
                this.consumption = new Consumption();
                break;
            }
        }
    }

    @FXML
    private void handleConsumptionSelectSizeAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        
        // Get Order Id and Size From FXML
        int orderId = Integer.parseInt(consumptionOrderIdBox.getSelectionModel().getSelectedItem());
        String size = consumptionSizeBox.getSelectionModel().getSelectedItem() + "";

        // Check If Consumption Is Already In Database
        int consumptionFound = 0;

        for (int i = 0; i < consumptions.size(); i++) {
            if (consumptions.get(i).getOrderId() == orderId && consumptions.get(i).getSize().equals(size) && consumptions.get(i).getIsDeleted() == 0) {
                consumption = consumptions.get(i);
                consumptionFound = 1;
                consumptionActionDoneMessageText.setText("Consumption Found");
                break;
            }
        }

        // Set Consumption To FXML if Found
        if (consumptionFound == 1) {
            consumptionDatePicker.getEditor().setText(consumption.getDate());
            consumptionSizeQuantityField.setText(consumption.getSizeQuantity() + "");
            
            // Set Fabric Consumption Values To FXML
            fabricConsumption = consumption.getFabricConsumption();
            consumptionFabricGsmField.setText(fabricConsumption.getFabricGsm() + "");
            consumptionFabricWastageField.setText(fabricConsumption.getWastage() + "");
            List<FabricConsumptionComponents> fabricConsumptionComponents = new ArrayList<>();
            fabricConsumptionComponents = fabricConsumption.getComponents();
            consumption.getFabricConsumption().setComponents(fabricConsumptionComponents);
            fabricConsumptionComponentsView = FXCollections.observableArrayList();
            for (int i = 0; i < fabricConsumptionComponents.size(); i++) {
                fabricConsumptionComponentsView.add(fabricConsumptionComponents.get(i));
            }
            consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
            consumptionFabricComponentTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getComponent()));
            consumptionFabricValueTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getValue()));
            consumptionFabricSewingAllowanceTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getAllowance()));
            DecimalFormat df = new DecimalFormat(".##");
            consumptionFabricPerDozenField.setText(df.format(consumption.getFabricConsumption().getConsumptionPerDozen()) + "");
            consumptionFabricPerPieceField.setText(df.format(consumption.getFabricConsumption().getConsumptionPerPiece()) + "");
            
            // Set Thread Consumption Values To FXML
            threadConsumption = consumption.getThreadConsumption();
            consumptionThreadWastageField.setText(threadConsumption.getWastage() + "");
            List<ThreadConsumptionOperation> threadConsumptionOperations = threadConsumption.getOperations();
            threadConsumptionOperationsView = FXCollections.observableArrayList();
            for (int i = 0; i < threadConsumptionOperations.size(); i++) {
                threadConsumptionOperationsView.add(threadConsumptionOperations.get(i));
            }
            consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);
            consumptionThreadOperationNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOperationName()));
            consumptionThreadSeamTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getSeamLength()));
            consumptionThreadStitchTypeTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getStitchType()));
            consumptionThreadRatioTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getRatio()));
            consumptionThreadEstimatedTbleColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getEstimatedThreadConsumption()));
            consumptionThreadField.setText(df.format(threadConsumption.getThreadConsumption()) + "");
        } // Instantiate New Consumption And Get Ready To Be Managed If Not Found
        else {
            consumptionActionDoneMessageText.setText("You Are Ready To Manage The Consumption");
            consumption = new Consumption();
            consumption.setSl(0);
            consumption.setOrderId(order.getOrderId());
            consumption.setSize(size);
            fabricConsumption = new FabricConsumption();
            consumption.setFabricConsumption(fabricConsumption);
            threadConsumption = new ThreadConsumption();
            consumption.setThreadConsumption(threadConsumption);

            // Get User ID
            String getIdText = merchandiserConsumptionIdText.getText();
            String idTokens[] = getIdText.split(" ");
            String user = idTokens[2];
            String consumptionCalculatedBy = user;
            String consumptionLastUpdatedBy = user;

            consumption.setCalculatedBy(consumptionCalculatedBy);
            consumption.setLastUpdatedBy(consumptionLastUpdatedBy);
            
            consumptionDatePicker.getEditor().setText("");
            consumptionSizeQuantityField.setText("0");
            consumptionFabricGsmField.setText("0");
            consumptionFabricWastageField.setText("0");
            consumptionFabricPerDozenField.setText("0");
            consumptionFabricPerPieceField.setText("0");
            consumptionThreadWastageField.setText("0");
            consumptionThreadField.setText("0");
            
            fabricConsumptionComponentsView = FXCollections.observableArrayList();
            threadConsumptionOperationsView = FXCollections.observableArrayList();
            
            consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
            consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);
        }
    }

    @FXML
    private void handleSelectFabricConsumptionComponentAction(MouseEvent event) {
        // Set FabricConsumptionComponent To FXML
        fabricConsumptionComponent = consumptionFabricComponentsTableView.getSelectionModel().getSelectedItem();
        consumptionFabricComponentBox.getSelectionModel().select(ConsumptionComponent.valueOf(fabricConsumptionComponent.getComponent()));
        consumptionFabricComponentValueField.setText(fabricConsumptionComponent.getValue() + "");
        consumptionFabricAllowanceField.setText(fabricConsumptionComponent.getAllowance() + "");
    }

    @FXML
    private void handleFabricConsumptionComponentRemoveAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        // Remove Fabric Consumption Component
        if (fabricConsumptionComponent != null) {
            consumption.getFabricConsumption().removeConsumptionComponent(fabricConsumptionComponent);
        }

        // Get All Fabric Consumption Components And Add To Observable List
        fabricConsumptionComponents = new ArrayList<>();
        fabricConsumptionComponents = consumption.getFabricConsumption().getComponents();
        fabricConsumptionComponentsView.remove(0, fabricConsumptionComponentsView.size());
        for (int i = 0; i < fabricConsumptionComponents.size(); i++) {
            fabricConsumptionComponentsView.add(fabricConsumptionComponents.get(i));
        }

        // Set Fabric Consumption Components To Table View
        consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
        consumptionFabricComponentTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getComponent()));
        consumptionFabricValueTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getValue()));
        consumptionFabricSewingAllowanceTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getAllowance()));
        
        consumptionActionDoneMessageText.setText("Fabric Consumption Component Removed");
        
        // Refresh FXML
        consumptionFabricComponentBox.getSelectionModel().clearSelection();
        consumptionFabricComponentValueField.setText("0");
        consumptionFabricAllowanceField.setText("0");

        // Set Fabric Comsumptions
        DecimalFormat df = new DecimalFormat(".##");
        consumptionFabricPerDozenField.setText(df.format(consumption.getFabricConsumption().getConsumptionPerDozen()) + "");
        consumptionFabricPerPieceField.setText(df.format(consumption.getFabricConsumption().getConsumptionPerPiece()) + "");
    }

    @FXML
    private void handleFabricConsumptionComponentAddAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        
        // Get Data From FXML
        double fabricGsm = Double.parseDouble(consumptionFabricGsmField.getText());
        double wastage = Double.parseDouble(consumptionFabricWastageField.getText());

        // Set Fabric GSM
        if (fabricGsm > 0) {
            consumption.getFabricConsumption().setFabricGsm(fabricGsm);
        }

        // Set Wastage
        if (wastage > 0) {
            consumption.getFabricConsumption().setWastage(wastage);
        }

        // Get Data From FXML
        int sl = 0;
        String component = consumptionFabricComponentBox.getSelectionModel().getSelectedItem() + "";
        double value = Double.parseDouble(consumptionFabricComponentValueField.getText());
        double allowance = Double.parseDouble(consumptionFabricAllowanceField.getText());

        // Instantiate Fabric Consumption Component And Add To Fabric Consumption List
        if (!component.equals("") && value > 0 && allowance > 0) {
            fabricConsumptionComponent = new FabricConsumptionComponents(sl, component, value, allowance);
            consumption.getFabricConsumption().addConsumptionComponent(fabricConsumptionComponent);
        }

        // Get All Fabric Consumption Components And Add To Observable List
        fabricConsumptionComponents = consumption.getFabricConsumption().getComponents();
        fabricConsumptionComponentsView.remove(0, fabricConsumptionComponentsView.size());
        for (int i = 0; i < fabricConsumptionComponents.size(); i++) {
            fabricConsumptionComponentsView.add(fabricConsumptionComponents.get(i));
        }

        // Set Fabric Consumption Components To Table View
        consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
        consumptionFabricComponentTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getComponent()));
        consumptionFabricValueTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getValue()));
        consumptionFabricSewingAllowanceTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getAllowance()));
        
        consumptionActionDoneMessageText.setText("Fabric Consumption Component Added");
        
        // Refresh FXML
        consumptionFabricComponentBox.getSelectionModel().clearSelection();
        consumptionFabricComponentValueField.setText("0");
        consumptionFabricAllowanceField.setText("0");

        // Set Fabric Comsumptions
        DecimalFormat df = new DecimalFormat(".##");
        consumptionFabricPerDozenField.setText(df.format(consumption.getFabricConsumption().getConsumptionPerDozen()) + "");
        consumptionFabricPerPieceField.setText(df.format(consumption.getFabricConsumption().getConsumptionPerPiece()) + "");
    }

    @FXML
    private void handleSelectThreadConsumptionOperationAction(MouseEvent event) {
        threadConsumptionOperation = consumptionThreadOperationsTableView.getSelectionModel().getSelectedItem();
        consumptionThreadOperationNameBox.getSelectionModel().select(ConsumptionOperationName.valueOf(threadConsumptionOperation.getOperationName()));
        consumptionThreadSeamLengthField.setText(threadConsumptionOperation.getSeamLength() + "");
        consumptionThreadStitchTypeBox.getSelectionModel().select(ConsumptionStitchType.valueOf(threadConsumptionOperation.getStitchType()));
        consumptionThreadRatioField.setText(threadConsumptionOperation.getRatio() + "");
        consumptionThreadInitialField.setText(threadConsumptionOperation.getInitialConsumption() + "");
        consumptionThreadEstimatedField.setText(threadConsumptionOperation.getEstimatedThreadConsumption() + "");
    }

    @FXML
    private void handleThreadConsumptionOperationRemoveAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        // Remove Threa Consumption Operation
        if (threadConsumptionOperation != null) {
            consumption.getThreadConsumption().removeConsumptionOperation(threadConsumptionOperation);
        }
        
        // Get All Thread Consumption Operations And Add To Observable List
        threadConsumptionOperations = new ArrayList<>();
        threadConsumptionOperations = consumption.getThreadConsumption().getOperations();
        threadConsumptionOperationsView.remove(0, threadConsumptionOperationsView.size());
        for (int i = 0; i < threadConsumptionOperations.size(); i++) {
            threadConsumptionOperationsView.add(threadConsumptionOperations.get(i));
        }
        
        // Set Thread Consumption Operations To Table View
        consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);
        consumptionThreadOperationNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOperationName()));
        consumptionThreadSeamTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getSeamLength()));
        consumptionThreadStitchTypeTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getStitchType()));
        consumptionThreadRatioTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getRatio()));
        consumptionThreadEstimatedTbleColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getEstimatedThreadConsumption()));
        
        consumptionActionDoneMessageText.setText("Thread Consumption Operation Removed");
        
        // Refresh FXML
        consumptionThreadOperationNameBox.getSelectionModel().clearSelection();
        consumptionThreadSeamLengthField.setText("0");
        consumptionThreadStitchTypeBox.getSelectionModel().clearSelection();
        consumptionThreadRatioField.setText("0");
        consumptionThreadInitialField.setText("0");
        consumptionThreadEstimatedField.setText("0");
        
        // Set Thread Consumption
        DecimalFormat df = new DecimalFormat(".##");
        consumptionThreadField.setText(df.format(consumption.getThreadConsumption().getThreadConsumption()) + "");
    }

    @FXML
    private void handleThreadConsumptionOperationAddAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        // Get Data From FXML
        double wastage = Double.parseDouble(consumptionThreadWastageField.getText());
        
        // Set Wastage
        if (wastage > 0){
            consumption.getThreadConsumption().setWastage(wastage);
        }
        
        // Get Data From FXML
        int sl = 0;
        String operationName = consumptionThreadOperationNameBox.getSelectionModel().getSelectedItem() + "";
        double seamLength = Double.parseDouble(consumptionThreadSeamLengthField.getText());
        String stitchType = consumptionThreadStitchTypeBox.getSelectionModel().getSelectedItem() + "";
        double ratio = Double.parseDouble(consumptionThreadRatioField.getText());
        double initialConsumption = Double.parseDouble(consumptionThreadInitialField.getText());
        double estimatedConsumption = Double.parseDouble(consumptionThreadEstimatedField.getText());
        
        // Instantiate Thread Consumption Operation And Add To Thread Consumption List
        if(!operationName.equals("") && !stitchType.equals("") && seamLength > 0 && ratio > 0 && initialConsumption > 0 && estimatedConsumption > 0){
            threadConsumptionOperation = new ThreadConsumptionOperation(sl, operationName, seamLength, stitchType, ratio, initialConsumption, estimatedConsumption);
            consumption.getThreadConsumption().addConsumptionOperation(threadConsumptionOperation);
        }
        
        // Get All Thread Consumption Operation And Add To Observable List
        threadConsumptionOperations = consumption.getThreadConsumption().getOperations();
        threadConsumptionOperationsView.remove(0, threadConsumptionOperationsView.size());
        for (int i = 0; i < threadConsumptionOperations.size(); i++) {
            threadConsumptionOperationsView.add(threadConsumptionOperations.get(i));
        }
        
        // Set Thread Consumption Operations To Table View
        consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);
        consumptionThreadOperationNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOperationName()));
        consumptionThreadSeamTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getSeamLength()));
        consumptionThreadStitchTypeTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getStitchType()));
        consumptionThreadRatioTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getRatio()));
        consumptionThreadEstimatedTbleColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getEstimatedThreadConsumption()));
        
        consumptionActionDoneMessageText.setText("Thread Consumption Operation Added");
        
        // Refresh FXML
        consumptionThreadOperationNameBox.getSelectionModel().clearSelection();
        consumptionThreadSeamLengthField.setText("0");
        consumptionThreadStitchTypeBox.getSelectionModel().clearSelection();
        consumptionThreadRatioField.setText("0");
        consumptionThreadInitialField.setText("0");
        consumptionThreadEstimatedField.setText("0");
        
        // Set Thread Consumption
        DecimalFormat df = new DecimalFormat(".##");
        consumptionThreadField.setText(df.format(consumption.getThreadConsumption().getThreadConsumption()) + "");
    }

    @FXML
    private void handleSetThreadConsumptionWastageAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        double wastage = Double.parseDouble(consumptionThreadWastageField.getText());
        
        if(wastage > 0){
            consumption.getThreadConsumption().setWastage(wastage);
            consumptionActionDoneMessageText.setText("Wastage Percantage Set To Thread Consumption");
        }
        else{
            consumptionActionNotDoneMessageText.setText("Please Enter A Valid Input");
        }
    }
    
    @FXML
    private void handleCalculateOperationConsumptionAction(KeyEvent event) {
        double seamLength = Double.parseDouble(consumptionThreadSeamLengthField.getText());
        double ratio = Double.parseDouble(consumptionThreadRatioField.getText());
        
        if(seamLength > 0 && ratio > 0){
            double initialConsumption = seamLength * ratio;
            double estimatedConsumption = initialConsumption + ((initialConsumption * consumption.getThreadConsumption().getWastage()) / 100);
            
            DecimalFormat df = new DecimalFormat(".##");
            consumptionThreadInitialField.setText(df.format(initialConsumption) + "");
            consumptionThreadEstimatedField.setText(df.format(estimatedConsumption) + "");
        }
    }
    
    @FXML
    private void handleSignOutConsumptionAction(ActionEvent event) {
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
    private void handleConsumptionSaveAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        
        // Check If Consumption Is Already In Database
        int isFound = 0;

        for (int i = 0; i < consumptions.size(); i++) {
            if (consumptions.get(i).getSl() == consumption.getSl() && consumptions.get(i).getSize().equals(consumption.getSize()) && consumptions.get(i).getIsDeleted() == 0) {
                isFound = 1;
                break;
            }
        }
        
        if(isFound == 1){
            String getIdText = merchandiserConsumptionIdText.getText();
            String idTokens[] = getIdText.split(" ");
            String user = idTokens[2];
            String consumptionLastUpdatedBy = user;

            consumption.setLastUpdatedBy(consumptionLastUpdatedBy);
        }
        String date = consumptionDatePicker.getEditor().getText();
        String size = consumptionSizeBox.getSelectionModel().getSelectedItem() + "";
        int sizeQantity = Integer.parseInt(consumptionSizeQuantityField.getText());
        
        consumption.setDate(date);
        consumption.setSize(size);
        consumption.setSizeQuantity(sizeQantity);
        
        consumptions = new ArrayList<>();
        fabricConsumptions = new ArrayList<>();
        threadConsumptions = new ArrayList<>();
        fabricConsumptionComponents = new ArrayList<>();
        threadConsumptionOperations = new ArrayList<>();
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Action
        try{
            for(int i = 0; i < consumption.getFabricConsumption().getComponents().size(); i++){
                session.saveOrUpdate(consumption.getFabricConsumption().getComponents().get(i));
            }
            for(int i = 0; i < consumption.getThreadConsumption().getOperations().size(); i++){
                session.saveOrUpdate(consumption.getThreadConsumption().getOperations().get(i));
            }
            session.saveOrUpdate(consumption.getFabricConsumption());
            session.saveOrUpdate(consumption.getThreadConsumption());
            session.saveOrUpdate(consumption);
            
            fabricConsumptionComponents = session.createCriteria(FabricConsumptionComponents.class).list();
            threadConsumptionOperations = session.createCriteria(ThreadConsumptionOperation.class).list();
            fabricConsumptions = session.createCriteria(FabricConsumption.class).list();
            threadConsumptions = session.createCriteria(ThreadConsumption.class).list();
            consumptions = session.createCriteria(Consumption.class).list();
            
            transaction.commit();
            
            consumptionActionDoneMessageText.setText("Consumption Updated To Database Successfully");
        }catch(Exception e){
            transaction.rollback();
            consumptionActionNotDoneMessageText.setText("Consumption Couldn't Be Saved");
        }
        session.close();
        
        consumptionSizeBox.getItems().removeAll(Size.values());
        consumptionCategoryBox.getItems().removeAll(OrderCategory.values());
        consumptionFabricComponentBox.getItems().removeAll(ConsumptionComponent.values());
        consumptionThreadOperationNameBox.getItems().removeAll(ConsumptionOperationName.values());
        consumptionThreadStitchTypeBox.getItems().removeAll(ConsumptionStitchType.values());
        
        consumptionOrderIdBox.getSelectionModel().clearSelection();
        consumptionbuyerNameField.setText("");
        consumptionCategoryBox.getSelectionModel().clearSelection();
        consumptionOrderQuantity.setText("");
        consumptionDatePicker.getEditor().setText("");
        consumptionSizeBox.getSelectionModel().clearSelection();
        consumptionSizeQuantityField.setText("0");
        consumptionFabricGsmField.setText("0");
        consumptionFabricWastageField.setText("0");
        consumptionFabricPerDozenField.setText("0");
        consumptionFabricPerPieceField.setText("0");
        consumptionThreadWastageField.setText("0");
        consumptionThreadField.setText("0");

        fabricConsumptionComponentsView = FXCollections.observableArrayList();
        threadConsumptionOperationsView = FXCollections.observableArrayList();

        consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
        consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);
        
        this.consumption = new Consumption();
    }

    @FXML
    private void handleConsumptionPrintAction(ActionEvent event) {
    }

    @FXML
    private void handleConsumptionRemoveAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        
        if(consumption != null){
            consumption.setIsDeleted(1);
            
            consumptions = new ArrayList<>();
            fabricConsumptions = new ArrayList<>();
            threadConsumptions = new ArrayList<>();
            fabricConsumptionComponents = new ArrayList<>();
            threadConsumptionOperations = new ArrayList<>();
        
            // Prepare Hibernate
            factory = HibernateSingleton.getSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();

            // Database Action
            try{
                session.update(consumption);
                
                fabricConsumptionComponents = session.createCriteria(FabricConsumptionComponents.class).list();
                threadConsumptionOperations = session.createCriteria(ThreadConsumptionOperation.class).list();
                fabricConsumptions = session.createCriteria(FabricConsumption.class).list();
                threadConsumptions = session.createCriteria(ThreadConsumption.class).list();
                consumptions = session.createCriteria(Consumption.class).list();
                transaction.commit();
                
                consumptionActionDoneMessageText.setText("Consumption Deleted Successfully");
            }catch(Exception e){
                transaction.rollback();
                consumptionActionNotDoneMessageText.setText("Consumption Couldn't Be Deleted");
            }
            session.close();

            consumptionSizeBox.getItems().removeAll(Size.values());
            consumptionCategoryBox.getItems().removeAll(OrderCategory.values());
            consumptionFabricComponentBox.getItems().removeAll(ConsumptionComponent.values());
            consumptionThreadOperationNameBox.getItems().removeAll(ConsumptionOperationName.values());
            consumptionThreadStitchTypeBox.getItems().removeAll(ConsumptionStitchType.values());

            consumptionOrderIdBox.getSelectionModel().clearSelection();
            consumptionbuyerNameField.setText("");
            consumptionCategoryBox.getSelectionModel().clearSelection();
            consumptionOrderQuantity.setText("");
            consumptionDatePicker.getEditor().setText("");
            consumptionSizeBox.getSelectionModel().clearSelection();
            consumptionSizeQuantityField.setText("0");
            consumptionFabricGsmField.setText("0");
            consumptionFabricWastageField.setText("0");
            consumptionFabricPerDozenField.setText("0");
            consumptionFabricPerPieceField.setText("0");
            consumptionThreadWastageField.setText("0");
            consumptionThreadField.setText("0");

            fabricConsumptionComponentsView = FXCollections.observableArrayList();
            threadConsumptionOperationsView = FXCollections.observableArrayList();

            consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
            consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);

            this.consumption = new Consumption();
        }
    }

    @FXML
    private void handleConsumptionRefreshAction(ActionEvent event) {
        consumptionActionNotDoneMessageText.setText("");
        consumptionActionDoneMessageText.setText("");
        
        consumptionSizeBox.getItems().removeAll(Size.values());
        consumptionCategoryBox.getItems().removeAll(OrderCategory.values());
        consumptionFabricComponentBox.getItems().removeAll(ConsumptionComponent.values());
        consumptionThreadOperationNameBox.getItems().removeAll(ConsumptionOperationName.values());
        consumptionThreadStitchTypeBox.getItems().removeAll(ConsumptionStitchType.values());
        
        consumptionOrderIdBox.getSelectionModel().clearSelection();
        consumptionbuyerNameField.setText("");
        consumptionCategoryBox.getSelectionModel().clearSelection();
        consumptionOrderQuantity.setText("");
        consumptionDatePicker.getEditor().setText("");
        consumptionSizeBox.getSelectionModel().clearSelection();
        consumptionSizeQuantityField.setText("0");
        consumptionFabricGsmField.setText("0");
        consumptionFabricWastageField.setText("0");
        consumptionFabricPerDozenField.setText("0");
        consumptionFabricPerPieceField.setText("0");
        consumptionThreadWastageField.setText("0");
        consumptionThreadField.setText("0");

        fabricConsumptionComponentsView = FXCollections.observableArrayList();
        threadConsumptionOperationsView = FXCollections.observableArrayList();

        consumptionFabricComponentsTableView.setItems(fabricConsumptionComponentsView);
        consumptionThreadOperationsTableView.setItems(threadConsumptionOperationsView);
        
        this.consumption = new Consumption();
    }

    @FXML
    private void handleSignOutCostingAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
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
    private void handleSaveCostingAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        // Get Data From FXML
        String date = costingDatePicker.getEditor().getText();
        int sizeQuantity = Integer.parseInt(costingSizeQuantityField.getText());
        double fabricGsm = Double.parseDouble(costingFabricGsmField.getText());
        String fabrication = costingFabricationArea.getText();
        
        // Set Data To Costing
        costing.setDate(date);
        costing.setSizeQuantity(sizeQuantity);
        costing.setFabricGsm(fabricGsm);
        costing.setFabrication(fabrication);
        
        int sl = 0;
        
        // Get CostingYarn Data From FXML
        double costingYarnConsumption = Double.parseDouble(costingYarnConsumptionField.getText());
        double costingYarnUnitPrice = Double.parseDouble(costingYarnUnitPriceField.getText());
        double costingYarnAmount = Double.parseDouble(costingYarnAmountField.getText());
        
        // Set CostingYarn Values To Costing
        costing.getCostingYarn().setSl(sl);
        costing.getCostingYarn().setConsumption(costingYarnConsumption);
        costing.getCostingYarn().setUnitPrice(costingYarnUnitPrice);
        costing.getCostingYarn().setCost(costingYarnAmount);
        
        // Get CostingKnitting Data From FXML
        double costingKnittingConsumption = Double.parseDouble(costingKnittingConsumptionField.getText());
        double costingKnittingUnitPrice = Double.parseDouble(costingKnittingUnitPriceField.getText());
        double costingKnittingAmount = Double.parseDouble(costingKnittingAmountField.getText());
        
        // Set CostingYarn Values To Costing
        costing.getCostingKnitting().setSl(sl);
        costing.getCostingKnitting().setConsumption(costingKnittingConsumption);
        costing.getCostingKnitting().setUnitPrice(costingKnittingUnitPrice);
        costing.getCostingKnitting().setCost(costingKnittingAmount);
        
        // Get CostingDyeing Data From FXML
        double costingDyeingConsumption = Double.parseDouble(costingDyeingConsumptionField.getText());
        double costingDyeingUnitPrice = Double.parseDouble(costingDyeingUnitPriceField.getText());
        double costingDyeingAmount = Double.parseDouble(costingDyeingAmountField.getText());
        
        // Set CostingYarn Values To Costing
        costing.getCostingDyeing().setSl(sl);
        costing.getCostingDyeing().setConsumption(costingDyeingConsumption);
        costing.getCostingDyeing().setUnitPrice(costingDyeingUnitPrice);
        costing.getCostingDyeing().setCost(costingDyeingAmount);
        
        // Get CostingThread Data From FXML
        double costingThreadConsumption = Double.parseDouble(costingThreadConsumptionField.getText());
        double costingThreadUnitPrice = Double.parseDouble(costingThreadUnitPriceField.getText());
        double costingThreadAmount = Double.parseDouble(costingThreadAmountField.getText());
        
        // Set CostingThread Values To Costing
        costing.getCostingThread().setSl(sl);
        costing.getCostingThread().setConsumption(costingThreadConsumption);
        costing.getCostingThread().setUnitPrice(costingThreadUnitPrice);
        costing.getCostingThread().setCost(costingThreadAmount);
        
        // Get CostingOther Data From FXML
        double costingOtherConsumption = Double.parseDouble(costingOtherConsumptionField.getText());
        double costingOtherUnitPrice = Double.parseDouble(costingOtherUnitPriceField.getText());
        double costingOtherAmount = Double.parseDouble(costingOtherAmountField.getText());
        
        // Set CostingThread Values To Costing
        costing.getCostingOther().setSl(sl);
        costing.getCostingOther().setConsumption(costingOtherConsumption);
        costing.getCostingOther().setUnitPrice(costingOtherUnitPrice);
        costing.getCostingOther().setCost(costingOtherAmount);
        
        // Get Costs From FXML
        double accessoriesCost = Double.parseDouble(costingTotalAccessoriesCostField.getText());
        double labTestCost = Double.parseDouble(costingLabTestCostField.getText());
        double totalCostPerDozen = Double.parseDouble(costingTotalCostPerDozenField.getText());
        double costOfMakingIncProfitPerDozen = Double.parseDouble(costingCmPerDozenField.getText());
        double commercialCostPerDozen = Double.parseDouble(costingCommercialCostField.getText());
        double totalPricePerDozen = Double.parseDouble(costingTotalPricePerDozenField.getText());
        double fobPricePerDozen = Double.parseDouble(costingFobPricePerDozenField.getText());
        
        // Set Costs To Costing
        costing.setAccessoriesCost(accessoriesCost);
        costing.setLabTestCost(labTestCost);
        costing.setTotalCostPerDozen(totalCostPerDozen);
        costing.setCostOfMakingIncProfitPerDozen(costOfMakingIncProfitPerDozen);
        costing.setCommercialCostPerDozen(commercialCostPerDozen);
        costing.setTotalPricePerDozen(totalPricePerDozen);
        costing.setFobPricePerDozen(fobPricePerDozen);
        
        // Check If The Costing Is Already In The Database
        int isFound = 0;
        for(int i = 0; i < costings.size(); i++){
            if(costings.get(i).getSl() == costing.getSl() && costings.get(i).getOrderId() == costing.getOrderId() && costings.get(i).getSize().equals(costing.getSize()) && costings.get(i).getIsDeleted() == 0){
                isFound = 1;
                break;
            }
        }
        
        // Set LastUpdatedBy To Costing If Found
        if(isFound == 1){
            String getIdText = merchandiserCostingIdText.getText();
            String idTokens[] = getIdText.split(" ");
            String user = idTokens[2];
            String costingLastUpdatedBy = user;

            costing.setLastUpdatedBy(costingLastUpdatedBy);
        }
        
        costings = new ArrayList<>();
        costingYarns = new ArrayList<>();
        costingKnittings = new ArrayList<>();
        costingDyeings = new ArrayList<>();
        costingThreads = new ArrayList<>();
        costingOthers = new ArrayList<>();
        costingAccessorieses = new ArrayList<>();
        costingAccessoriesItems = new ArrayList<>();
        
        // Prepare Hibernate
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        // Database Actions
        try{
            for(int i = 0; i < costing.getCostingAccessories().getAccessoriesItems().size(); i++){
                session.saveOrUpdate(costing.getCostingAccessories().getAccessoriesItems().get(i));
            }
            session.saveOrUpdate(costing.getCostingAccessories());
            session.saveOrUpdate(costing.getCostingYarn());
            session.saveOrUpdate(costing.getCostingKnitting());
            session.saveOrUpdate(costing.getCostingDyeing());
            session.saveOrUpdate(costing.getCostingThread());
            session.saveOrUpdate(costing.getCostingOther());
            session.saveOrUpdate(costing);
            
            costingAccessoriesItems = session.createCriteria(CostingAccessoriesItem.class).list();
            costingAccessorieses = session.createCriteria(CostingAccessories.class).list();
            costingYarns = session.createCriteria(CostingYarn.class).list();
            costingKnittings = session.createCriteria(CostingKnitting.class).list();
            costingDyeings = session.createCriteria(CostingDyeing.class).list();
            costingThreads = session.createCriteria(CostingThread.class).list();
            costingOthers = session.createCriteria(CostingOthers.class).list();
            costings = session.createCriteria(Costing.class).list();
            
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            costingHandleActionNotDoneMessageText.setText("Sorry! Costing Couldn't Be Updated");
        }
        session.close();
        costingHandleActionDoneMessageText.setText("Costing Updated To Database Successfully");
        
        // Refresh FXML
        costing = new Costing();
        costingOrderIdBox.getSelectionModel().clearSelection();
        costingbuyerNameField.setText("");
        costingCategoryBox.getSelectionModel().clearSelection();
        costingOrderQuantityField.setText("0");
        costingDescriptionField.setText("");
        
        costingDatePicker.getEditor().setText("");
        costingSizeBox.getItems().removeAll(Size.values());
        costingCategoryBox.getItems().removeAll(OrderCategory.values());
        costingSizeQuantityField.setText("0");
        
        costingAccessoriesItemBox.getItems().removeAll(AccessoriesItems.values());
        costingFabricationArea.setText("");
        costingOtherUnitPriceField.setText("0");
        costingDyeingUnitPriceField.setText("0");
        costingKnittingUnitPriceField.setText("0");
        costingYarnUnitPriceField.setText("0");
        costingOtherAmountField.setText("0");
        costingDyeingAmountField.setText("0");
        costingKnittingAmountField.setText("0");
        costingYarnAmountField.setText("0");
        costingOtherConsumptionField.setText("0");
        costingDyeingConsumptionField.setText("0");
        costingKnittingConsumptionField.setText("0");
        costingYarnConsumptionField.setText("0");
        costingFabAndProcPerDozentField.setText("0");
        costingThreadUnitPriceField.setText("0");
        costingThreadConsumptionField.setText("0");
        costingThreadAmountField.setText("0");
        costingAccessoriesAmountField.setText("0");
        costingAccessoriesItemBox.getSelectionModel().clearSelection();
        costingFobPricePerDozenField.setText("0");
        costingTotalPricePerDozenField.setText("0");
        costingCommercialCostField.setText("0");
        costingCmPerDozenField.setText("0");
        costingTotalCostPerDozenField.setText("0");
        costingLabTestCostField.setText("0");
        costingTotalAccessoriesCostField.setText("0");
        costingFabricGsmField.setText("0");
                
        costingAccessoriesItemsView = FXCollections.observableArrayList();    
        costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
    }

    @FXML
    private void handleRemoveCostingAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        if(costing != null){
            costing.setIsDeleted(1);
            costings = new ArrayList<>();
            costingYarns = new ArrayList<>();
            costingKnittings = new ArrayList<>();
            costingDyeings = new ArrayList<>();
            costingThreads = new ArrayList<>();
            costingOthers = new ArrayList<>();
            costingAccessorieses = new ArrayList<>();
            costingAccessoriesItems = new ArrayList<>();

            // Prepare Hibernate
            factory = HibernateSingleton.getSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();

            // Database Actions
            try{
                session.update(costing);

                costingAccessoriesItems = session.createCriteria(CostingAccessoriesItem.class).list();
                costingAccessorieses = session.createCriteria(CostingAccessories.class).list();
                costingYarns = session.createCriteria(CostingYarn.class).list();
                costingKnittings = session.createCriteria(CostingKnitting.class).list();
                costingDyeings = session.createCriteria(CostingDyeing.class).list();
                costingThreads = session.createCriteria(CostingThread.class).list();
                costingOthers = session.createCriteria(CostingOthers.class).list();
                costings = session.createCriteria(Costing.class).list();

                transaction.commit();
            }catch(Exception e){
                transaction.rollback();
                costingHandleActionNotDoneMessageText.setText("Sorry! Costing Couldn't Be Deleted");
            }
            session.close();
            costingHandleActionDoneMessageText.setText("Costing Deleted Successfully");
            
            // Refresh FXML
            costing = new Costing();
            costingOrderIdBox.getSelectionModel().clearSelection();
            costingbuyerNameField.setText("");
            costingCategoryBox.getSelectionModel().clearSelection();
            costingOrderQuantityField.setText("0");
            costingDescriptionField.setText("");

            costingDatePicker.getEditor().setText("");
            costingSizeBox.getItems().removeAll(Size.values());
            costingCategoryBox.getItems().removeAll(OrderCategory.values());
            costingSizeQuantityField.setText("0");

            costingAccessoriesItemBox.getItems().removeAll(AccessoriesItems.values());
            costingFabricationArea.setText("");
            costingOtherUnitPriceField.setText("0");
            costingDyeingUnitPriceField.setText("0");
            costingKnittingUnitPriceField.setText("0");
            costingYarnUnitPriceField.setText("0");
            costingOtherAmountField.setText("0");
            costingDyeingAmountField.setText("0");
            costingKnittingAmountField.setText("0");
            costingYarnAmountField.setText("0");
            costingOtherConsumptionField.setText("0");
            costingDyeingConsumptionField.setText("0");
            costingKnittingConsumptionField.setText("0");
            costingYarnConsumptionField.setText("0");
            costingFabAndProcPerDozentField.setText("0");
            costingThreadUnitPriceField.setText("0");
            costingThreadConsumptionField.setText("0");
            costingThreadAmountField.setText("0");
            costingAccessoriesAmountField.setText("0");
            costingAccessoriesItemBox.getSelectionModel().clearSelection();
            costingFobPricePerDozenField.setText("0");
            costingTotalPricePerDozenField.setText("0");
            costingCommercialCostField.setText("0");
            costingCmPerDozenField.setText("0");
            costingTotalCostPerDozenField.setText("0");
            costingLabTestCostField.setText("0");
            costingTotalAccessoriesCostField.setText("0");
            costingFabricGsmField.setText("0");

            costingAccessoriesItemsView = FXCollections.observableArrayList();    
            costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
        }
    }

    @FXML
    private void handleRefreshCostingAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        // Refresh FXML
        costing = new Costing();
        costingOrderIdBox.getSelectionModel().clearSelection();
        costingbuyerNameField.setText("");
        costingCategoryBox.getSelectionModel().clearSelection();
        costingOrderQuantityField.setText("0");
        costingDescriptionField.setText("");

        costingDatePicker.getEditor().setText("");
        costingSizeBox.getItems().removeAll(Size.values());
        costingCategoryBox.getItems().removeAll(OrderCategory.values());
        costingSizeQuantityField.setText("0");

        costingAccessoriesItemBox.getItems().removeAll(AccessoriesItems.values());
        costingFabricationArea.setText("");
        costingOtherUnitPriceField.setText("0");
        costingDyeingUnitPriceField.setText("0");
        costingKnittingUnitPriceField.setText("0");
        costingYarnUnitPriceField.setText("0");
        costingOtherAmountField.setText("0");
        costingDyeingAmountField.setText("0");
        costingKnittingAmountField.setText("0");
        costingYarnAmountField.setText("0");
        costingOtherConsumptionField.setText("0");
        costingDyeingConsumptionField.setText("0");
        costingKnittingConsumptionField.setText("0");
        costingYarnConsumptionField.setText("0");
        costingFabAndProcPerDozentField.setText("0");
        costingThreadUnitPriceField.setText("0");
        costingThreadConsumptionField.setText("0");
        costingThreadAmountField.setText("0");
        costingAccessoriesAmountField.setText("0");
        costingAccessoriesItemBox.getSelectionModel().clearSelection();
        costingFobPricePerDozenField.setText("0");
        costingTotalPricePerDozenField.setText("0");
        costingCommercialCostField.setText("0");
        costingCmPerDozenField.setText("0");
        costingTotalCostPerDozenField.setText("0");
        costingLabTestCostField.setText("0");
        costingTotalAccessoriesCostField.setText("0");
        costingFabricGsmField.setText("0");

        costingAccessoriesItemsView = FXCollections.observableArrayList();    
        costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
    }

    @FXML
    private void handleCostingAccessoriesItemRemoveAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        // Remove Selected Costing Accessories Item From Particular Costing
        costing.getCostingAccessories().removeCostingAccessoriesItem(costingAccessoriesItem);
        
        // Refresh Costing Accessories Items List
        costingAccessoriesItems = new ArrayList<>();
        costingAccessoriesItems = costing.getCostingAccessories().getAccessoriesItems();
        
        // Refresh Costing Accessories Items Observable List
        costingAccessoriesItemsView = FXCollections.observableArrayList();
        for(int i = 0; i < costingAccessoriesItems.size(); i++){
            costingAccessoriesItemsView.add(costingAccessoriesItems.get(i));
        }
        
        // Set Costing Accesories Items To Table View
        costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
        costingAccessoriesItemTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getItemName()));
        costingAccessoriesAmountTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getItemCost()));
        
        // Recalculate Costing And Set To FXML
        DecimalFormat df = new DecimalFormat(".##");
        costingTotalAccessoriesCostField.setText(df.format(costing.getCostingAccessories().getCost()) + "");
        costingAccessoriesItemBox.getSelectionModel().clearSelection();
        costingAccessoriesAmountField.setText("0");
        
        costingTotalCostPerDozenField.setText(costing.getTotalCostPerDozen() + "");
        costingCmPerDozenField.setText(costing.getCostOfMakingIncProfitPerDozen() + "");
        costingCommercialCostField.setText(costing.getCommercialCostPerDozen() + "");
        costingTotalPricePerDozenField.setText(costing.getTotalPricePerDozen() + "");
        costingFobPricePerDozenField.setText(costing.getFobPricePerDozen() + "");
    }

    @FXML
    private void handleCostingAccessoriesItemAddAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        // Get Data From FXML
        int sl = 0;
        String itemName = costingAccessoriesItemBox.getSelectionModel().getSelectedItem() + "";
        double itemCost = Double.parseDouble(costingAccessoriesAmountField.getText());
        
        // Instantiate New Costing Accessories Item And Add It To The Particular Costing
        costingAccessoriesItem = new CostingAccessoriesItem(sl, itemName, itemCost);
        costing.getCostingAccessories().addCostingAccessoriesItem(costingAccessoriesItem);
        
        // Refresh Costing Accessories Items List
        costingAccessoriesItems = new ArrayList<>();
        costingAccessoriesItems = costing.getCostingAccessories().getAccessoriesItems();
        
        // Refresh Costing Accessories Items Observable List
        costingAccessoriesItemsView = FXCollections.observableArrayList();
        for(int i = 0; i < costingAccessoriesItems.size(); i++){
            costingAccessoriesItemsView.add(costingAccessoriesItems.get(i));
        }
        
        // Set Costing Accesories Items To Table View
        costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
        costingAccessoriesItemTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getItemName()));
        costingAccessoriesAmountTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getItemCost()));
        
        // Recalculate Costing And Set To FXML
        DecimalFormat df = new DecimalFormat(".##");
        costingTotalAccessoriesCostField.setText(df.format(costing.getCostingAccessories().getCost()) + "");
        costingAccessoriesItemBox.getSelectionModel().clearSelection();
        costingAccessoriesAmountField.setText("0");
        
        costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
        costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
        costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
        costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
        costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
    }

    @FXML
    private void handleSelectCostingAccessoriesItemAction(MouseEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        // Get Selected Costing Accessories Item
        costingAccessoriesItem = costingAccessoriesItemsTableView.getSelectionModel().getSelectedItem();
        
        // Set Data To FXML
        costingAccessoriesItemBox.getSelectionModel().select(AccessoriesItems.valueOf(costingAccessoriesItem.getItemName()));
        costingAccessoriesAmountField.setText(costingAccessoriesItem.getItemCost() + "");
    }

    @FXML
    private void handleCostingOrderIdAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        // Get Order Id From FXML
        int orderId = Integer.parseInt(costingOrderIdBox.getSelectionModel().getSelectedItem());
        
        // Refresh Combo Box Values
        costingSizeBox.getItems().removeAll(Size.values());
        costingCategoryBox.getItems().removeAll(OrderCategory.values());
        costingAccessoriesItemBox.getItems().removeAll(AccessoriesItems.values());
        costingSizeBox.getItems().addAll(Size.values());
        costingCategoryBox.getItems().addAll(OrderCategory.values());
        costingAccessoriesItemBox.getItems().addAll(AccessoriesItems.values());
        
        // Get Order Using Id
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == orderId) {
                order = orders.get(i);
                
                // Set Order Basic Data To FXML
                costingbuyerNameField.setText("");
                costingCategoryBox.getSelectionModel().clearSelection();
                costingOrderQuantityField.setText("0");
                costingDescriptionField.setText("");
                costingbuyerNameField.setText(order.getBuyerName());
                costingCategoryBox.getSelectionModel().select(OrderCategory.valueOf(order.getOrderCategory()));
                costingOrderQuantityField.setText(order.getOrderQuantity() + "");
                costingDescriptionField.setText(order.getOrderDescription());
                
                // Refresh Other FXML Elements
                costingDatePicker.getEditor().setText("");
                costingSizeBox.getSelectionModel().getSelectedItem();
                costingSizeQuantityField.setText("0");
                costingFabricationArea.setText("");
                costingOtherUnitPriceField.setText("0");
                costingDyeingUnitPriceField.setText("0");
                costingKnittingUnitPriceField.setText("0");
                costingYarnUnitPriceField.setText("0");
                costingOtherAmountField.setText("0");
                costingDyeingAmountField.setText("0");
                costingKnittingAmountField.setText("0");
                costingYarnAmountField.setText("0");
                costingOtherConsumptionField.setText("0");
                costingDyeingConsumptionField.setText("0");
                costingKnittingConsumptionField.setText("0");
                costingYarnConsumptionField.setText("0");
                costingFabAndProcPerDozentField.setText("0");
                costingThreadUnitPriceField.setText("0");
                costingThreadConsumptionField.setText("0");
                costingThreadAmountField.setText("0");
                costingAccessoriesAmountField.setText("0");
                costingAccessoriesItemBox.getSelectionModel().clearSelection();
                costingFobPricePerDozenField.setText("0");
                costingTotalPricePerDozenField.setText("0");
                costingCommercialCostField.setText("0");
                costingCmPerDozenField.setText("0");
                costingTotalCostPerDozenField.setText("0");
                costingLabTestCostField.setText("0");
                costingTotalAccessoriesCostField.setText("0");
                costingFabricGsmField.setText("0");
                
                costingAccessoriesItemsView = FXCollections.observableArrayList();    
                costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
                break;
            }
        }
    }

    @FXML
    private void handleCostingSelectSizeAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        // Get Order Id and Size From FXML
        int orderId = Integer.parseInt(costingOrderIdBox.getSelectionModel().getSelectedItem());
        String size = costingSizeBox.getSelectionModel().getSelectedItem() + "";
        
        // Check If Consumption Is Already In Database
        int consumptionFound = 0;
        
        for (int i = 0; i < consumptions.size(); i++) {
            if (consumptions.get(i).getOrderId() == orderId && consumptions.get(i).getSize().equals(size) && consumptions.get(i).getIsDeleted() == 0) {
                consumption = consumptions.get(i);
                consumptionFound = 1;
                break;
            }
        }
        
        // Give Message To Calculate Consumption For The Particular If Not Found
        if(consumptionFound == 0){
            costingHandleActionNotDoneMessageText.setText("Please Calculate Consumption First For This To Calculate Costing");
        }
        else{
            // Check If Costing Is Already In Database
            int costingFound = 0;

            for (int i = 0; i < costings.size(); i++) {
                if (costings.get(i).getOrderId() == orderId && costings.get(i).getSize().equals(size) && costings.get(i).getIsDeleted() == 0) {
                    costing = costings.get(i);
                    costingFound = 1;
                    break;
                }
            }

            // Set Costing To FXML if Found
            if (costingFound == 1) {
                costingDatePicker.getEditor().setText(costing.getDate());
                costingSizeQuantityField.setText(costing.getSizeQuantity() + "");
                costingFabricGsmField.setText(costing.getFabricGsm() + "");
                
                DecimalFormat df = new DecimalFormat(".##");
                costingFabricationArea.setText(costing.getFabrication());
                costingOtherUnitPriceField.setText(df.format(costing.getCostingOther().getUnitPrice()) + "");
                costingDyeingUnitPriceField.setText(df.format(costing.getCostingDyeing().getUnitPrice()) + "");
                costingKnittingUnitPriceField.setText(df.format(costing.getCostingKnitting().getUnitPrice()) + "");
                costingYarnUnitPriceField.setText(df.format(costing.getCostingYarn().getUnitPrice()) + "");
                costingOtherAmountField.setText(df.format(costing.getCostingOther().getCost()) + "");
                costingDyeingAmountField.setText(df.format(costing.getCostingDyeing().getCost()) + "");
                costingKnittingAmountField.setText(df.format(costing.getCostingKnitting().getCost()) + "");
                costingYarnAmountField.setText(df.format(costing.getCostingYarn().getCost()) + "");
                costingOtherConsumptionField.setText(df.format(costing.getCostingOther().getConsumption()) + "");
                costingDyeingConsumptionField.setText(df.format(costing.getCostingDyeing().getConsumption()) + "");
                costingKnittingConsumptionField.setText(df.format(costing.getCostingYarn().getConsumption()) + "");
                costingYarnConsumptionField.setText(df.format(costing.getCostingYarn().getConsumption()) + "");
                costingFabAndProcPerDozentField.setText(df.format(costing.getTotalFabAndProcPerDozen()) + "");
                costingThreadUnitPriceField.setText(df.format(costing.getCostingThread().getUnitPrice()) + "");
                costingThreadConsumptionField.setText(df.format(costing.getCostingThread().getConsumption()) + "");
                costingThreadAmountField.setText(df.format(costing.getCostingThread().getCost()) + "");
                costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
                costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
                costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
                costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
                costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
                costingLabTestCostField.setText(df.format(costing.getLabTestCost()) + "");
                costingTotalAccessoriesCostField.setText(df.format(costing.getCostingAccessories().getCost()) + "");
                
                costingAccessoriesItems = new ArrayList<>();
                costingAccessoriesItems = costing.getCostingAccessories().getAccessoriesItems();
                costingAccessoriesItemsView = FXCollections.observableArrayList();
                for(int i = 0; i < costingAccessoriesItems.size(); i++){
                    costingAccessoriesItemsView.add(costingAccessoriesItems.get(i));
                }
                costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
                costingAccessoriesItemTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getItemName()));
                costingAccessoriesAmountTableColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getItemCost()));
                
                costingHandleActionDoneMessageText.setText("Costing Found");

            } // Instantiate New Costing And Get Ready To Be Managed If Not Found
            else {
                costing = new Costing();
                costing.setSl(0);
                costing.setOrderId(order.getOrderId());
                costing.setSize(size);
                
                costingYarn = new CostingYarn();
                costingYarn.setConsumption(consumption.getFabricConsumption().getConsumptionPerDozen());
                costingKnitting = new CostingKnitting();
                costingKnitting.setConsumption(consumption.getFabricConsumption().getConsumptionPerDozen());
                costingDyeing = new CostingDyeing();
                costingDyeing.setConsumption(consumption.getFabricConsumption().getConsumptionPerDozen());
                costingThread = new CostingThread();
                costingThread.setConsumption(consumption.getThreadConsumption().getThreadConsumption());
                costingOther = new CostingOthers();
                costingAccessories = new CostingAccessories();
                List<CostingAccessoriesItem> costingAccessoriesItems = new ArrayList<>();
                costingAccessories.setAccessoriesItems(costingAccessoriesItems);
                costing.setCostingYarn(costingYarn);
                costing.setCostingKnitting(costingKnitting);
                costing.setCostingDyeing(costingDyeing);
                costing.setCostingThread(costingThread);
                costing.setCostingOther(costingOther);
                costing.setCostingAccessories(costingAccessories);

                // Get User ID
                String getIdText = merchandiserCostingIdText.getText();
                String idTokens[] = getIdText.split(" ");
                String user = idTokens[2];
                String consumptionCalculatedBy = user;
                String consumptionLastUpdatedBy = user;

                costing.setCalculatedBy(consumptionCalculatedBy);
                costing.setLastUpdatedBy(consumptionLastUpdatedBy);
                      
                DecimalFormat df = new DecimalFormat(".##");
                // Refresh Other FXML Elements
                costingDatePicker.getEditor().setText("");
                costingSizeQuantityField.setText("0");
                costingFabricationArea.setText("");
                costingOtherUnitPriceField.setText("0");
                costingDyeingUnitPriceField.setText("0");
                costingKnittingUnitPriceField.setText("0");
                costingYarnUnitPriceField.setText("0");
                costingOtherAmountField.setText("0");
                costingDyeingAmountField.setText("0");
                costingKnittingAmountField.setText("0");
                costingYarnAmountField.setText("0");
                costingOtherConsumptionField.setText("0");
                costingDyeingConsumptionField.setText(df.format(costing.getCostingDyeing().getConsumption()) + "");
                costingKnittingConsumptionField.setText(df.format(costing.getCostingKnitting().getConsumption()) + "");
                costingYarnConsumptionField.setText(df.format(costing.getCostingYarn().getConsumption()) + "");
                costingFabAndProcPerDozentField.setText("0");
                costingThreadUnitPriceField.setText("0");
                costingThreadConsumptionField.setText(df.format(costing.getCostingThread().getConsumption()) + "");
                costingThreadAmountField.setText("0");
                costingAccessoriesAmountField.setText("0");
                costingAccessoriesItemBox.getSelectionModel().clearSelection();
                costingFobPricePerDozenField.setText("0");
                costingTotalPricePerDozenField.setText("0");
                costingCommercialCostField.setText("0");
                costingCmPerDozenField.setText("0");
                costingTotalCostPerDozenField.setText("0");
                costingLabTestCostField.setText("0");
                costingTotalAccessoriesCostField.setText("0");
                costingFabricGsmField.setText("0");
                
                costingAccessoriesItemsView = FXCollections.observableArrayList();    
                costingAccessoriesItemsTableView.setItems(costingAccessoriesItemsView);
                
                costingHandleActionDoneMessageText.setText("You Are Ready To Manage This Costing");
            }
        }
    }

    @FXML
    private void handleCalculateCostingOhersAmount(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        double otherConsumption = Double.parseDouble(costingOtherConsumptionField.getText());
        double unitPrice = Double.parseDouble(costingOtherUnitPriceField.getText());
        double cost = 0;
        if(costing != null){
            costing.getCostingOther().setConsumption(otherConsumption);
            costing.getCostingOther().setUnitPrice(unitPrice);
            cost = costing.getCostingOther().getCost();
        }
        DecimalFormat df = new DecimalFormat(".##");
        costingOtherAmountField.setText(df.format(cost) + "");
        costingFabAndProcPerDozentField.setText("0");
        costingFabAndProcPerDozentField.setText(df.format(costing.getTotalFabAndProcPerDozen()) + "");
        
        costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
        costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
        costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
        costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
        costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
    }

    @FXML
    private void handleCalculateCostingDyeingAmount(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        double dyeingConsumption = Double.parseDouble(costingDyeingConsumptionField.getText());
        double unitPrice = Double.parseDouble(costingDyeingUnitPriceField.getText());
        double cost = 0;
        if(costing != null){
            costing.getCostingDyeing().setConsumption(dyeingConsumption);
            costing.getCostingDyeing().setUnitPrice(unitPrice);
            cost = costing.getCostingDyeing().getCost();
        }
        DecimalFormat df = new DecimalFormat(".##");
        costingDyeingAmountField.setText(df.format(cost) + "");
        costingFabAndProcPerDozentField.setText("0");
        costingFabAndProcPerDozentField.setText(df.format(costing.getTotalFabAndProcPerDozen()) + "");
        
        costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
        costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
        costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
        costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
        costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
    }

    @FXML
    private void handleCalculateCostingKnittingAmount(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        double knittingConsumption = Double.parseDouble(costingKnittingConsumptionField.getText());
        double unitPrice = Double.parseDouble(costingKnittingUnitPriceField.getText());
        double cost = 0;
        if(costing != null){
            costing.getCostingKnitting().setConsumption(knittingConsumption);
            costing.getCostingKnitting().setUnitPrice(unitPrice);
            cost = costing.getCostingKnitting().getCost();
        }
        DecimalFormat df = new DecimalFormat(".##");
        costingKnittingAmountField.setText(df.format(cost) + "");
        costingFabAndProcPerDozentField.setText("0");
        costingFabAndProcPerDozentField.setText(df.format(costing.getTotalFabAndProcPerDozen()) + "");
        
        costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
        costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
        costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
        costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
        costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
    }

    @FXML
    private void handleCalculateCostingYarnAmount(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        double yarnConsumption = Double.parseDouble(costingYarnConsumptionField.getText());
        double unitPrice = Double.parseDouble(costingYarnUnitPriceField.getText());
        double cost = 0;
        if(costing != null){
            costing.getCostingYarn().setConsumption(yarnConsumption);
            costing.getCostingYarn().setUnitPrice(unitPrice);
            cost = costing.getCostingYarn().getCost();
        }
        DecimalFormat df = new DecimalFormat(".##");
        costingYarnAmountField.setText(df.format(cost) + "");
        costingFabAndProcPerDozentField.setText("0");
        costingFabAndProcPerDozentField.setText(df.format(costing.getTotalFabAndProcPerDozen()) + "");
        
        costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
        costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
        costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
        costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
        costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
    }

    @FXML
    private void handleCalculateCostingThreadAmount(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        double threadConsumption = Double.parseDouble(costingThreadConsumptionField.getText());
        double unitPrice = Double.parseDouble(costingThreadUnitPriceField.getText());
        double cost = 0;
        if(costing != null){
            costing.getCostingThread().setConsumption(threadConsumption);
            costing.getCostingThread().setUnitPrice(unitPrice);
            cost = costing.getCostingThread().getCost();
        }
        DecimalFormat df = new DecimalFormat(".##");
        costingThreadAmountField.setText(df.format(cost) + "");
        costingFabAndProcPerDozentField.setText("0");
        costingFabAndProcPerDozentField.setText(df.format(costing.getTotalFabAndProcPerDozen()) + "");
        
        costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
        costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
        costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
        costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
        costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
    }

    @FXML
    private void handleCostingSetLabTestCostAction(ActionEvent event) {
        // Set Message Texts Empty
        costingHandleActionDoneMessageText.setText("");
        costingHandleActionNotDoneMessageText.setText("");
        
        double labCost = Double.parseDouble(costingLabTestCostField.getText());
        
        costing.setLabTestCost(labCost);
        
        DecimalFormat df = new DecimalFormat(".##");
        costingTotalCostPerDozenField.setText(df.format(costing.getTotalCostPerDozen()) + "");
        costingCmPerDozenField.setText(df.format(costing.getCostOfMakingIncProfitPerDozen()) + "");
        costingCommercialCostField.setText(df.format(costing.getCommercialCostPerDozen()) + "");
        costingTotalPricePerDozenField.setText(df.format(costing.getTotalPricePerDozen()) + "");
        costingFobPricePerDozenField.setText(df.format(costing.getFobPricePerDozen()) + "");
        
        costingHandleActionDoneMessageText.setText("Lab Test Cost Has Been Set To Costing");
    }

}
