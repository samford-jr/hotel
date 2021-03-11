package sample;

//import javafx.embed.swing.JFXPanel;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static sample.Cashier_Controller.getCashier;


//import java.awt.*;

public class admin implements Initializable {



    @FXML
    public  TableView tableView;
    @FXML
    private Button xbutton1;
    @FXML
    public Button purchase;
    @FXML
    public Button Employees;
    @FXML
    public Button Cashier;

    @FXML
    public PieChart pi;
    @FXML
    public Label label1;
    @FXML
    public Label label4;
    double status;
    VBox vbox= new VBox();
    Button btn=new Button("this is a demo");

    public void xbutton1OnAction (ActionEvent event){

        Stage stage=(Stage) xbutton1.getScene().getWindow();
        stage.close();
    }


    public void pie() {
        status=85;
        label4.setText(String.valueOf(status)+"%");

           ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                   new PieChart.Data("covered", status),
                   new PieChart.Data("empty", 15)


    );

        pi.setLegendVisible(false);
        pi.setData(list);


    }

    public void purchaseOnAction (ActionEvent event) throws IOException {

        Inventory.table();
    }
    public void EmployeesOnAction (ActionEvent event) throws IOException {

        sample.Employee_Controller.table();
    }

    public void CashierOnAction (ActionEvent event) throws IOException {

        sample.Cashier_Controller.table();
    }
    public void LogOutOnAction (ActionEvent event) throws IOException {
        Main.primaryStage.setWidth(980);
        Main.primaryStage.setHeight(591);
        Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
        Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pie();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getItems().addAll(getCashier());

    }
}
