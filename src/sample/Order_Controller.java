package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Order_Controller implements Initializable {
    @FXML
    public Button Back;
    @FXML
    public Button x;
    @FXML
    public ComboBox foodanddrink;
    @FXML
    public ComboBox amountcombobox;
    @FXML
    public ComboBox drink;
    @FXML
    public ComboBox drinkamount;
    @FXML
    public TableView<Order_Controller> tableView;

    private final SimpleStringProperty OrderList = new SimpleStringProperty("");
    private final SimpleIntegerProperty amount = new SimpleIntegerProperty(0);

    public Order_Controller(){

    }
    public Order_Controller(String OrderList, Integer amount) {
        setOrderList(OrderList);
        setAmount(amount);
    }

    public void setOrderList(String foodType) {
        OrderList.set(foodType);
    }
    public void setAmount(Integer Amount1) {
        amount.set(Amount1);
    }
    public int getAmount() {
        return amount.get();
    }
    public String getOrderList() {
        return OrderList.get();
    }
    public void BackOnAction (ActionEvent event) throws IOException {
        Main.primaryStage.setWidth(938);
        Main.primaryStage.setHeight(591);
        Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
        Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");
    }
        public void orderfood(){

            System.out.println(foodanddrink.getValue()+"thus hgfd hf");
            Order_Controller newOrder = new Order_Controller( (String) foodanddrink.getValue(), (Integer) amountcombobox.getValue() );
            // tableView.getColumns().addAll(order,amount);
            tableView.getItems().add(newOrder);
        }
        public void orderdrink(){

            System.out.println(foodanddrink.getValue()+"thus hgfd hf");
            Order_Controller newOrder = new Order_Controller((String) drink.getValue(), (Integer) drinkamount.getValue());
            // tableView.getColumns().addAll(order,amount);
            tableView.getItems().add(newOrder);
        }



    public void xOnAction (ActionEvent event){

        Stage stage=(Stage) x.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
