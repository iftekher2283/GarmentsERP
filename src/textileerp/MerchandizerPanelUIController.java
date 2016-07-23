/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileerp;

import enums.Currency;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Buyer;
import model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author iftekher
 */
public class MerchandizerPanelUIController implements Initializable {
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
    private Text merchandizerBuyerIdText;
    @FXML
    private Text merchandizerOrderIdText;
    @FXML
    private TextField orderIdField;
    @FXML
    private TextField orderNameField;
    @FXML
    private TextField orderBuyerReqirementsField;
    @FXML
    private TextField orderPriorityField;
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
    
    private String merchandizerId;
    
    private List<Buyer> buyers;
    private List<Order> orders;
    
    private ObservableList<Buyer> buyersView;
    private ObservableList<String> buyerNames;
    private ObservableList<Order> ordersView;
    
    private Buyer buyer;
    private Order order;
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    @FXML
    private Text orderIdSearchMessageText;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        orderCategoryBox.getItems().addAll(OrderCategory.values());
        orderCurrencyBox.getItems().addAll(Currency.values());
        
        buyers = new ArrayList<>();
        orders = new ArrayList<>();
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        try{
            buyers = session.createCriteria(Buyer.class).list();
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        buyersView = FXCollections.observableArrayList();
        buyerNames = FXCollections.observableArrayList();
        for (int i = 0; i < buyers.size(); i++){
            buyerNames.add(buyers.get(i).getBuyerName());
            buyersView.add(buyers.get(i));
        }
        orderBuyerNameBox.setItems(buyerNames);
        
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
        ordersView = FXCollections.observableArrayList();
        for (int i = 0; i < orders.size(); i++){
            ordersView.add(orders.get(i));
        }
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getLastUpdatedBy()));
        
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
        String addedBy = merchandizerBuyerIdText.getText();
        String lastUpdatedBy = merchandizerBuyerIdText.getText();
        
        Buyer buyer = new Buyer(buyerName, officeSiteName, companyBrandName, phone, email, address, city, state, zipCode, areaCode, addedBy, lastUpdatedBy);
        buyers.removeAll(buyers);
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        try{
            session.save(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        buyersView.remove(0, buyersView.size());
        for (int i = 0; i < buyers.size(); i++){
            buyersView.add(buyers.get(i));
        }
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
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
        String lastUpdatedBy = merchandizerBuyerIdText.getText();
        
        Buyer buyer = new Buyer(buyerName, officeSiteName, companyBrandName, phone, email, address, city, state, zipCode, areaCode, addedBy, lastUpdatedBy);
        buyer.setBuyerName(this.buyer.getBuyerName());
        buyer.setAddedBy(this.buyer.getAddedBy());
        buyers.removeAll(buyers);
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        try{
            session.update(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        buyersView.remove(0, buyersView.size());
        for (int i = 0; i < buyers.size(); i++){
            buyersView.add(buyers.get(i));
        }
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
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
        String lastUpdatedBy = merchandizerBuyerIdText.getText();
        
        Buyer buyer = new Buyer(buyerName, officeSiteName, companyBrandName, phone, email, address, city, state, zipCode, areaCode, addedBy, lastUpdatedBy);
        buyer.setBuyerName(this.buyer.getBuyerName());
        buyer.setAddedBy(this.buyer.getAddedBy());
        buyers.removeAll(buyers);
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        
        try{
            session.delete(buyer);
            buyers = session.createCriteria(Buyer.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        buyersView.remove(0, buyersView.size());
        for (int i = 0; i < buyers.size(); i++){
            buyersView.add(buyers.get(i));
        }
        buyersTableView.setItems(buyersView);
        buyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        buyerSiteNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOfficeSiteName()));
        buyerBrandNameTableColummn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCompanyBrandName()));
        buyerPhoneTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        buyerEmailTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        buyerAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        buyerLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUpdatedBy()));
        
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
    
    public void setMerchandizerId(String username){
        this.merchandizerId = username;
        merchandizerBuyerIdText.setText(username);
        merchandizerOrderIdText.setText(username);
    }

    @FXML
    private void handleSelectBuyerAcion(MouseEvent event) {
        buyerNameMatchingText.setText("");
        
        buyer = buyersTableView.getSelectionModel().getSelectedItem();
        
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
        
        int orderId = Integer.parseInt(orderIdField.getText());
        
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getOrderId() == orderId){
                order = orders.get(i);
                
                orderIdField.setText(order.getOrderId() + "");
                orderNameField.setText(order.getOrderName());
                orderBuyerNameBox.getSelectionModel().select(order.getBuyerName());
                orderBuyerReqirementsField.setText(order.getBuyerRequirements());
                orderDescriptionArea.setText(order.getDescription());
                orderPriorityField.setText(order.getPriority());
                orderQuantityField.setText(order.getQuantity() + "");
                orderCategoryBox.getSelectionModel().select(OrderCategory.valueOf(order.getCategory()));
                orderSmvField.setText(order.getSmv() + "");
                orderDeliveryDatePicker.getEditor().setText(order.getDeliveryDate());
                orderCostField.setText(order.getCost() + "");
                orderCurrencyBox.getSelectionModel().select(Currency.valueOf(order.getCurrency()));
                orderInternalCommentsField.setText(order.getInternalComments());
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
        
        order = ordersTableView.getSelectionModel().getSelectedItem();
        
        orderIdField.setText(order.getOrderId() + "");
        orderNameField.setText(order.getOrderName());
        orderBuyerNameBox.getSelectionModel().select(order.getBuyerName());
        orderBuyerReqirementsField.setText(order.getBuyerRequirements());
        orderDescriptionArea.setText(order.getDescription());
        orderPriorityField.setText(order.getPriority());
        orderQuantityField.setText(order.getQuantity() + "");
        orderCategoryBox.getSelectionModel().select(OrderCategory.valueOf(order.getCategory()));
        orderSmvField.setText(order.getSmv() + "");
        orderDeliveryDatePicker.getEditor().setText(order.getDeliveryDate());
        orderCostField.setText(order.getCost() + "");
        orderCurrencyBox.getSelectionModel().select(Currency.valueOf(order.getCurrency()));
        orderInternalCommentsField.setText(order.getInternalComments());
    }

    @FXML
    private void handleOrderAddAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        int orderId = Integer.parseInt(orderIdField.getText());
        String orderName = orderNameField.getText();
        String buyerName = orderBuyerNameBox.getSelectionModel().getSelectedItem();
        String buyerRequirements = orderBuyerReqirementsField.getText();
        String description = orderDescriptionArea.getText();
        String priority = orderPriorityField.getText();
        int quantity = Integer.parseInt(orderQuantityField.getText());
        String category = orderCategoryBox.getSelectionModel().getSelectedItem() + "";
        double smv = Double.parseDouble(orderSmvField.getText());
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date currentDate= new Date();
        String orderDate = format.format(currentDate);
      //  System.out.println(orderDate);
        String deliveryDate = orderDeliveryDatePicker.getEditor().getText();
        double cost = Double.parseDouble(orderCostField.getText());
        String currency = orderCurrencyBox.getSelectionModel().getSelectedItem() + "";
        String internalComments = orderInternalCommentsField.getText();
        String addedBy = merchandizerOrderIdText.getText();
        String lastUpdatedBy = merchandizerOrderIdText.getText();
        
        Order addOrder = new Order(orderName, buyerName, buyerRequirements, description, priority, quantity, category, smv, orderDate, deliveryDate, cost, currency, internalComments, addedBy, lastUpdatedBy);
        orders.removeAll(orders);
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(addOrder);
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        ordersView.remove(0, ordersView.size());
        for (int i = 0; i < orders.size(); i++){
            ordersView.add(orders.get(i));
        }
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getLastUpdatedBy()));
        
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

    @FXML
    private void handleUpdateOrderAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        int orderId = Integer.parseInt(orderIdField.getText()); 
        String orderName = orderNameField.getText();
        String buyerName = orderBuyerNameBox.getSelectionModel().getSelectedItem();
        String requirements = orderBuyerReqirementsField.getText();
        String description = orderDescriptionArea.getText();
        String priority = orderPriorityField.getText();
        int quantity = Integer.parseInt(orderQuantityField.getText());
        String category = orderCategoryBox.getSelectionModel().getSelectedItem() + "";
        double smv = Double.parseDouble(orderSmvField.getText());
        String orderDate = new SimpleDateFormat("dd-mm-yyyy") + "";
        String deliveryDate = orderDeliveryDatePicker.getEditor().getText();
        double cost = Double.parseDouble(orderCostField.getText());
        String currency = orderCurrencyBox.getSelectionModel().getSelectedItem() + "";
        String internalComments = orderInternalCommentsField.getText();
        String addedBy = "";
        String lastUpdatedBy = merchandizerOrderIdText.getText();
        
        Order order = new Order(orderName, buyerName, requirements, description, priority, quantity, category, smv, orderDate, deliveryDate, cost, currency, internalComments, addedBy, lastUpdatedBy);
        order.setOrderId(this.order.getOrderId());
        order.setAddedBy(this.order.getAddedBy());
        orders.removeAll(orders);
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(order);
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        ordersView.remove(0, ordersView.size());
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getLastUpdatedBy()));
        
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

    @FXML
    private void handleRemoveOrderAction(ActionEvent event) {
        orderIdSearchMessageText.setText("");
        
        int orderId = Integer.parseInt(orderIdField.getText());
        String orderName = orderNameField.getText();
        String buyerName = orderBuyerNameBox.getSelectionModel().getSelectedItem();
        String requirements = orderBuyerReqirementsField.getText();
        String description = orderDescriptionArea.getText();
        String priority = orderPriorityField.getText();
        int quantity = Integer.parseInt(orderQuantityField.getText());
        String category = orderCategoryBox.getSelectionModel().getSelectedItem() + "";
        double smv = Double.parseDouble(orderSmvField.getText());
        String orderDate = new SimpleDateFormat("dd-mm-yyyy") + "";
        String deliveryDate = orderDeliveryDatePicker.getEditor().getText();
        double cost = Double.parseDouble(orderCostField.getText());
        String currency = orderCurrencyBox.getSelectionModel().getSelectedItem() + "";
        String internalComments = orderInternalCommentsField.getText();
        String addedBy = "";
        String lastUpdatedBy = merchandizerOrderIdText.getText();
        
        Order order = new Order(orderName, buyerName, requirements, description, priority, quantity, category, smv, orderDate, deliveryDate, cost, currency, internalComments, addedBy, lastUpdatedBy);
        order.setOrderId(this.order.getOrderId());
        order.setAddedBy(this.order.getAddedBy());
        orders.removeAll(orders);
        
        factory = HibernateSingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(order);
            orders = session.createCriteria(Order.class).list();
            transaction.commit();
        }catch(Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        session.close();
        
        ordersView.remove(0, ordersView.size());
        ordersTableView.setItems(ordersView);
        orderIdTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getOrderId()));
        orderNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderName()));
        orderBuyerNameTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBuyerName()));
        orderQuantityTableColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getQuantity()));
        orderCategoryTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCategory()));
        orderDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getOrderDate()));
        orderDeliveryDateTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDeliveryDate()));
        orderAddedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAddedBy()));
        orderLastUpdatedByTableColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getLastUpdatedBy()));
        
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
    
}
