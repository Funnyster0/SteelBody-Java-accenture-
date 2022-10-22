package com.accenture.steelbody.controller;

import com.accenture.steelbody.DatabaseWorker;
import com.accenture.steelbody.Status;
import com.accenture.steelbody.TableContainer;
import com.accenture.steelbody.container.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainController {
    @FXML
    private Button buttonLogin;
    @FXML
    private Label WelcomeLabel;
    @FXML
    private Button buttonManufacturer;
    @FXML
    private Button buttonAddress;
    @FXML
    private Button buttonAvailability;
    @FXML
    private Button buttonEnter;
    @FXML
    private Button buttonProduct;
    @FXML
    private Button buttonShop;
    @FXML
    private Button buttonUser;
    @FXML
    private Button buttonUserOrder;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> column1;
    @FXML
    private TableColumn<?, ?> column2;
    @FXML
    private TableColumn<?, ?> column3;
    @FXML
    private TableColumn<?, ?> column4;
    @FXML
    private TableColumn<?, ?> column5;
    @FXML
    private Label Label2;
    @FXML
    private Label Label3;
    @FXML
    private Label Label4;
    @FXML
    private Label Label5;
    @FXML
    private TextField Edit2;
    @FXML
    private TextField Edit3;
    @FXML
    private TextField Edit4;
    @FXML
    private TextField Edit5;

    private String currentTable = null;

    @FXML
    private void initialize() {
        if (Status.NAME != null)
        {
            WelcomeLabel.setText("Welcome, " + Status.NAME + "!");
            buttonEnter.setVisible(false);
            buttonLogin.setVisible(false);
        }
        else
        {
            WelcomeLabel.setText("Sports equipment store for workout");
            buttonEnter.setVisible(true);
            buttonLogin.setVisible(true);
        }
        currentTable = "Product";
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column3.setCellValueFactory(new PropertyValueFactory<>("idManufacturer"));
        column4.setCellValueFactory(new PropertyValueFactory<>("description"));
        column5.setCellValueFactory(new PropertyValueFactory<>("price"));

        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(true);
        Label5.setVisible(true);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit4.setVisible(true);
        Edit5.setVisible(true);
        Label2.setText("Товар");
        Label3.setText("Производитель");
        Label4.setText("Описание");
        Label5.setText("Цена");
        onButtonClean();

        databaseReader("Product");
    }

    @FXML
    void onAddressAction() {
        currentTable = "Address";
        column2.setPrefWidth(250.);
        column3.setPrefWidth(250.);
        column4.setPrefWidth(250.);
        column5.setPrefWidth(250.);
        buttonProduct.setDisable(false);
        buttonShop.setDisable(false);
        buttonAddress.setDisable(true);
        buttonAvailability.setDisable(false);
        buttonUser.setDisable(false);
        buttonUserOrder.setDisable(false);
        buttonManufacturer.setDisable(false);
        table.getItems().clear();
        column2.setText("Страна");
        column3.setText("Город");
        column4.setText("Улица");
        column5.setText("Дом");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("country"));
        column3.setCellValueFactory(new PropertyValueFactory<>("town"));
        column4.setCellValueFactory(new PropertyValueFactory<>("street"));
        column5.setCellValueFactory(new PropertyValueFactory<>("house"));

        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(true);
        Label5.setVisible(true);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit4.setVisible(true);
        Edit5.setVisible(true);
        Label2.setText("Страна");
        Label3.setText("Город");
        Label4.setText("Улица");
        Label5.setText("Дом");
        onButtonClean();
        databaseReader("Address");
    }

    @FXML
    void onAvailabilityAction() {
        currentTable = "Availability";
        column2.setPrefWidth(250.);
        column3.setPrefWidth(250.);
        column4.setPrefWidth(250.);
        column5.setPrefWidth(0.);
        buttonProduct.setDisable(false);
        buttonShop.setDisable(false);
        buttonAddress.setDisable(false);
        buttonAvailability.setDisable(true);
        buttonUser.setDisable(false);
        buttonUserOrder.setDisable(false);
        buttonManufacturer.setDisable(false);
        table.getItems().clear();
        column2.setText("Магазин");
        column3.setText("Продукт");
        column4.setText("Количество");
        column5.setText("");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("idShop"));
        column3.setCellValueFactory(new PropertyValueFactory<>("idProduct"));
        column4.setCellValueFactory(new PropertyValueFactory<>("numOf"));
        column5.setCellValueFactory(new PropertyValueFactory<>(null));

        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(true);
        Label5.setVisible(false);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit4.setVisible(true);
        Edit5.setVisible(false);
        Label2.setText("Магазин");
        Label3.setText("Продукт");
        Label4.setText("Количество");
        Label5.setText("");
        onButtonClean();
        databaseReader("Availability");
    }

    @FXML
    void onProductAction()
    {
        currentTable = "Product";
        column2.setPrefWidth(250.);
        column3.setPrefWidth(250.);
        column4.setPrefWidth(250.);
        column5.setPrefWidth(250.);
        buttonProduct.setDisable(true);
        buttonShop.setDisable(false);
        buttonAddress.setDisable(false);
        buttonAvailability.setDisable(false);
        buttonUser.setDisable(false);
        buttonUserOrder.setDisable(false);
        buttonManufacturer.setDisable(false);
        table.getItems().clear();
        column2.setText("Товар");
        column3.setText("Производитель");
        column4.setText("Цвет");
        column5.setText("Цена");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column3.setCellValueFactory(new PropertyValueFactory<>("idManufacturer"));
        column4.setCellValueFactory(new PropertyValueFactory<>("description"));
        column5.setCellValueFactory(new PropertyValueFactory<>("price"));

        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(true);
        Label5.setVisible(true);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit4.setVisible(true);
        Edit5.setVisible(true);
        Label2.setText("Товар");
        Label3.setText("Производитель");
        Label4.setText("Описание");
        Label5.setText("Цена");
        onButtonClean();
        databaseReader("Product");
    }

    @FXML
    void onShopAction() {
        currentTable = "Shop";
        column2.setPrefWidth(250.);
        column3.setPrefWidth(250.);
        column4.setPrefWidth(0.);
        column5.setPrefWidth(0.);
        buttonProduct.setDisable(false);
        buttonShop.setDisable(true);
        buttonAddress.setDisable(false);
        buttonAvailability.setDisable(false);
        buttonUser.setDisable(false);
        buttonUserOrder.setDisable(false);
        buttonManufacturer.setDisable(false);
        table.getItems().clear();
        column2.setText("Название");
        column3.setText("Адрес");
        column4.setText("");
        column5.setText("");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column3.setCellValueFactory(new PropertyValueFactory<>("idAddress"));
        column4.setCellValueFactory(new PropertyValueFactory<>(null));
        column5.setCellValueFactory(new PropertyValueFactory<>(null));

        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(false);
        Label5.setVisible(false);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit4.setVisible(false);
        Edit5.setVisible(false);
        Label2.setText("Название");
        Label3.setText("Адрес");
        Label4.setText("");
        Label5.setText("");
        onButtonClean();
        databaseReader("Shop");
    }

    @FXML
    void onUserAction() {
        currentTable = "User";
        column2.setPrefWidth(250.);
        column3.setPrefWidth(250.);
        column4.setPrefWidth(250.);
        column5.setPrefWidth(250.);
        buttonProduct.setDisable(false);
        buttonShop.setDisable(false);
        buttonAddress.setDisable(false);
        buttonAvailability.setDisable(false);
        buttonUser.setDisable(true);
        buttonUserOrder.setDisable(false);
        buttonManufacturer.setDisable(false);
        table.getItems().clear();
        column2.setText("Статус");
        column3.setText("Никнейм");
        column4.setText("E-mail");
        column5.setText("Пароль");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("status"));
        column3.setCellValueFactory(new PropertyValueFactory<>("name"));
        column4.setCellValueFactory(new PropertyValueFactory<>("email"));
        column5.setCellValueFactory(new PropertyValueFactory<>("password"));

        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(true);
        Label5.setVisible(true);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit4.setVisible(true);
        Edit5.setVisible(true);
        Label2.setText("Статус");
        Label3.setText("Никнейм");
        Label4.setText("E-mail");
        Label5.setText("Пароль");
        onButtonClean();
        databaseReader("User");
    }

    @FXML
    void onUserOrderAction() {
        currentTable = "UserOrder";
        column2.setPrefWidth(250.);
        column3.setPrefWidth(250.);
        column4.setPrefWidth(250.);
        column5.setPrefWidth(250.);
        buttonProduct.setDisable(false);
        buttonShop.setDisable(false);
        buttonAddress.setDisable(false);
        buttonAvailability.setDisable(false);
        buttonUser.setDisable(false);
        buttonUserOrder.setDisable(true);
        buttonManufacturer.setDisable(false);
        table.getItems().clear();
        column2.setText("Пользователь");
        column3.setText("Наличие");
        column4.setText("Количество");
        column5.setText("");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        column3.setCellValueFactory(new PropertyValueFactory<>("idAvailability"));
        column4.setCellValueFactory(new PropertyValueFactory<>("numOf"));
        column5.setCellValueFactory(new PropertyValueFactory<>(null));

        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(true);
        Label5.setVisible(false);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit4.setVisible(true);
        Edit5.setVisible(false);
        Label2.setText("Пользователь");
        Label3.setText("Наличие");
        Label4.setText("Количество");
        Label5.setText("");
        onButtonClean();
        databaseReader("UserOrder");
    }

    @FXML
    void onManufacturerAction() {
        currentTable = "Manufacturer";
        column2.setPrefWidth(250.);
        column3.setPrefWidth(0.);
        column4.setPrefWidth(0.);
        column5.setPrefWidth(0.);
        buttonProduct.setDisable(false);
        buttonShop.setDisable(false);
        buttonAddress.setDisable(false);
        buttonAvailability.setDisable(false);
        buttonUser.setDisable(false);
        buttonUserOrder.setDisable(false);
        buttonManufacturer.setDisable(true);
        table.getItems().clear();
        column2.setText("Название");
        column3.setText("");
        column4.setText("");
        column5.setText("");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column3.setCellValueFactory(new PropertyValueFactory<>(null));
        column4.setCellValueFactory(new PropertyValueFactory<>(null));
        column5.setCellValueFactory(new PropertyValueFactory<>(null));

        Label2.setVisible(true);
        Label3.setVisible(false);
        Label4.setVisible(false);
        Label5.setVisible(false);
        Edit2.setVisible(true);
        Edit3.setVisible(false);
        Edit4.setVisible(false);
        Edit5.setVisible(false);
        Label2.setText("Название");
        Label3.setText("");
        Label4.setText("");
        Label5.setText("");
        onButtonClean();
        databaseReader("Manufacturer");
    }

    void databaseReader(String theTable) {
        DatabaseWorker dbw = new DatabaseWorker();
        if (dbw.open()) {
            ObservableList data = dbw.select(theTable);
            dbw.close();
            table.setItems(data);
        }
    }

    @FXML
    void onExit() {
        System.exit(0);
    }

    @FXML
    void onEnterAction(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/enter.fxml");
    }

    @FXML
    void onAbout(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/about.fxml");
    }

    @FXML
    void onLoginAction(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/login.fxml");
    }

    @FXML
    void selectRow(MouseEvent mouseEvent) {
        if (currentTable.equals("Product"))
        {
            Product selectedRow = (Product) table.getSelectionModel().getSelectedItem();
            Edit2.setText(selectedRow.getName());
            Edit3.setText(Integer.toString(selectedRow.getIdManufacturer()));
            Edit4.setText(selectedRow.getDescription());
            Edit5.setText(Integer.toString(selectedRow.getPrice()));
            // TODO Сохранять id (новое приватное поле currentId?), чтобы удобнее менять его в таблице и в БД
        }
        else if (currentTable.equals("Address"))
        {
            Address selectedRow = (Address) table.getSelectionModel().getSelectedItem();
            Edit2.setText(selectedRow.getCountry());
            Edit3.setText(selectedRow.getTown());
            Edit4.setText(selectedRow.getStreet());
            Edit5.setText(Integer.toString(selectedRow.getHouse()));
        }
        else if (currentTable.equals("Availability"))
        {
            Availability selectedRow = (Availability) table.getSelectionModel().getSelectedItem();
            Edit2.setText(Integer.toString(selectedRow.getIdProduct()));
            Edit3.setText(Integer.toString(selectedRow.getIdShop()));
            Edit4.setText(Integer.toString(selectedRow.getNumOf()));
        }
        else if (currentTable.equals("Manufacturer"))
        {
            Manufacturer selectedRow = (Manufacturer) table.getSelectionModel().getSelectedItem();
            Edit2.setText(selectedRow.getName());
        }
        else if (currentTable.equals("Shop"))
        {
            Shop selectedRow = (Shop) table.getSelectionModel().getSelectedItem();
            Edit2.setText(selectedRow.getName());
            Edit3.setText(Integer.toString(selectedRow.getIdAddress()));
        }
        else if (currentTable.equals("User"))
        {
            User selectedRow = (User) table.getSelectionModel().getSelectedItem();
            Edit2.setText(Integer.toString(selectedRow.getStatus()));
            Edit3.setText(selectedRow.getName());
            Edit4.setText(selectedRow.getEmail());
            Edit5.setText(selectedRow.getPassword());
        }
        else if (currentTable.equals("UserOrder"))
        {
            UserOrder selectedRow = (UserOrder) table.getSelectionModel().getSelectedItem();
            Edit2.setText(Integer.toString(selectedRow.getIdUser()));
            Edit3.setText(Integer.toString(selectedRow.getIdAvailability()));
            Edit4.setText(Integer.toString(selectedRow.getNumOf()));
        }
    }

    @FXML
    void onButtonUpdate(ActionEvent actionEvent) {
        if (currentTable.equals("Product"))
        {

        }
        else if (currentTable.equals("Address"))
        {

        }
        else if (currentTable.equals("Availability"))
        {

        }
        else if (currentTable.equals("Manufacturer"))
        {

        }
        else if (currentTable.equals("Shop"))
        {

        }
        else if (currentTable.equals("User"))
        {

        }
        else if (currentTable.equals("UserOrder"))
        {

        }
    }

    @FXML
    void onButtonAdd(ActionEvent actionEvent) {
        DatabaseWorker dbw = new DatabaseWorker();
        if (currentTable.equals("Product"))
        {
            Product o = new Product();
            o.setId(table.getItems().size() + 1);
            o.setName(Edit2.getText());
            o.setIdManufacturer(Integer.parseInt(Edit3.getText()));
            o.setDescription(Edit4.getText());
            o.setPrice(Integer.parseInt(Edit5.getText()));
            if (dbw.open())
            {
                dbw.insert(o);
                dbw.close();
            }
            onProductAction();
        }
        else if (currentTable.equals("Address"))
        {
            Address o = new Address();
            o.setId(table.getItems().size() + 1);
            o.setCountry(Edit2.getText());
            o.setTown(Edit3.getText());
            o.setStreet(Edit4.getText());
            o.setHouse(Integer.parseInt(Edit5.getText()));
            if (dbw.open())
            {
                dbw.insert(o);

                dbw.close();
            }
            onAddressAction();
        }
        else if (currentTable.equals("Availability"))
        {
            Availability o = new Availability();
            o.setId(table.getItems().size() + 1);
            o.setIdProduct(Integer.parseInt(Edit2.getText()));
            o.setIdShop(Integer.parseInt(Edit3.getText()));
            o.setNumOf(Integer.parseInt(Edit4.getText()));
            if (dbw.open())
            {
                dbw.insert(o);

                dbw.close();
            }
            onAvailabilityAction();
        }
        else if (currentTable.equals("Manufacturer"))
        {
            Manufacturer o = new Manufacturer();
            o.setId(table.getItems().size() + 1);
            o.setName(Edit2.getText());
            if (dbw.open())
            {
                dbw.insert(o);

                dbw.close();
            }
            onManufacturerAction();
        }
        else if (currentTable.equals("Shop"))
        {
            Shop o = new Shop();
            o.setId(table.getItems().size() + 1);
            o.setName(Edit2.getText());
            o.setIdAddress(Integer.parseInt(Edit3.getText()));
            if (dbw.open())
            {
                dbw.insert(o);

                dbw.close();
            }
            onShopAction();
        }
        else if (currentTable.equals("User"))
        {
            User o = new User();
            o.setId(table.getItems().size() + 1);
            o.setStatus(Integer.parseInt(Edit2.getText()));
            o.setName(Edit3.getText());
            o.setEmail(Edit4.getText());
            o.setPassword(Edit5.getText());
            if (dbw.open())
            {
                dbw.insert(o);

                dbw.close();
            }
            onUserAction();
        }
        else if (currentTable.equals("UserOrder"))
        {
            UserOrder o = new UserOrder();
            o.setId(table.getItems().size() + 1);
            o.setIdUser(Integer.parseInt(Edit2.getText()));
            o.setIdAvailability(Integer.parseInt(Edit3.getText()));
            o.setNumOf(Integer.parseInt(Edit4.getText()));
            if (dbw.open())
            {
                dbw.insert(o);

                dbw.close();
            }
            onUserOrderAction();
        }
        onButtonClean();

    }

    @FXML
    void onButtonDelete(ActionEvent actionEvent) {
        DatabaseWorker dbw = new DatabaseWorker();
        if (currentTable.equals("Product"))
        {
            Product o = new Product();
            o.setId(table.getItems().size());
            o.setName(Edit2.getText());
            o.setIdManufacturer(Integer.parseInt(Edit3.getText()));
            o.setDescription(Edit4.getText());
            o.setPrice(Integer.parseInt(Edit5.getText()));
            if (dbw.open())
            {
                dbw.delete(o, o.getId());
                dbw.close();
            }
            onProductAction();
        }
        else if (currentTable.equals("Address"))
        {
            Address o = new Address();
            o.setId(table.getItems().size());
            o.setCountry(Edit2.getText());
            o.setTown(Edit3.getText());
            o.setStreet(Edit4.getText());
            o.setHouse(Integer.parseInt(Edit5.getText()));
            if (dbw.open())
            {
                dbw.delete(o, o.getId());

                dbw.close();
            }
            onAddressAction();
        }
        else if (currentTable.equals("Availability"))
        {
            Availability o = new Availability();
            o.setId(table.getItems().size());
            o.setIdProduct(Integer.parseInt(Edit2.getText()));
            o.setIdShop(Integer.parseInt(Edit3.getText()));
            o.setNumOf(Integer.parseInt(Edit4.getText()));
            if (dbw.open())
            {
                dbw.delete(o, o.getId());

                dbw.close();
            }
            onAvailabilityAction();
        }
        else if (currentTable.equals("Manufacturer"))
        {
            Manufacturer o = new Manufacturer();
            o.setId(table.getItems().size());
            o.setName(Edit2.getText());
            if (dbw.open())
            {
                dbw.delete(o, o.getId());

                dbw.close();
            }
            onManufacturerAction();
        }
        else if (currentTable.equals("Shop"))
        {
            Shop o = new Shop();
            o.setId(table.getItems().size());
            o.setName(Edit2.getText());
            o.setIdAddress(Integer.parseInt(Edit3.getText()));
            if (dbw.open())
            {
                dbw.delete(o, o.getId());

                dbw.close();
            }
            onShopAction();
        }
        else if (currentTable.equals("User"))
        {
            User o = new User();
            o.setId(table.getItems().size());
            o.setStatus(Integer.parseInt(Edit2.getText()));
            o.setName(Edit3.getText());
            o.setEmail(Edit4.getText());
            o.setPassword(Edit5.getText());
            if (dbw.open())
            {
                dbw.delete(o, o.getId());

                dbw.close();
            }
            onUserAction();
        }
        else if (currentTable.equals("UserOrder"))
        {
            UserOrder o = new UserOrder();
            o.setId(table.getItems().size());
            o.setIdUser(Integer.parseInt(Edit2.getText()));
            o.setIdAvailability(Integer.parseInt(Edit3.getText()));
            o.setNumOf(Integer.parseInt(Edit4.getText()));
            if (dbw.open())
            {
                dbw.delete(o, o.getId());

                dbw.close();
            }
            onUserOrderAction();
        }
        onButtonClean();

    }

    @FXML
    void onButtonClean() {
        Edit2.setText("");
        Edit3.setText("");
        Edit4.setText("");
        Edit5.setText("");
    }
}
