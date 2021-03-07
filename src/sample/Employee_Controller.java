package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee_Controller {

    static TableView<Employee> workers;
    static AnchorPane pane1 = new AnchorPane();

    public static void table() {
        //Employee_id column

        TableColumn<Employee, Integer> Employee_id = new TableColumn<>("Employee_id");
        Employee_id.setMinWidth(50);
        Employee_id.setCellValueFactory(new PropertyValueFactory<>("Employee_id"));

        //First Name column

        TableColumn<Employee, String> FirstName = new TableColumn<>("First Name");
        FirstName.setMinWidth(200);
        FirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));

        // Last Name column

        TableColumn<Employee, String> LastName = new TableColumn<>("Last Name");
        LastName.setMinWidth(200);
        LastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));

        //Address column

        TableColumn<Employee, String> Address = new TableColumn<>("Address");
        Address.setMinWidth(100);
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));

        //Price column

        TableColumn<Employee, Double> Salary = new TableColumn<>("Salary");
        Salary.setMinWidth(100);
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        workers = new TableView<>();
        workers.getColumns().addAll(Employee_id, FirstName, LastName, Address, Salary);
        workers.getItems().addAll(getEmployee());
        workers.setLayoutY(40);
        workers.setPrefSize(695, 300);

        Label lb1 = new Label("EMPLOYEE LIST:");
        lb1.setFont(Font.font(20));
        lb1.setStyle("bold");
        lb1.setLayoutX(280);
        lb1.setLayoutY(10);


        Button btn = new Button("ADD EMPLOYEE");
        btn.setPrefHeight(40);
        btn.setPrefWidth(120);
        btn.setLayoutX(544);
        btn.setLayoutY(355);

        pane1.getChildren().addAll(lb1, workers, btn);
        Main.primaryStage.setScene(new Scene(pane1, 695, 400));
        Main.primaryStage.show();


    }

    public static ObservableList<Employee> getEmployee() {
        ObservableList<Employee> worker = FXCollections.observableArrayList();
        Connection connection = databaseconnection.getConnection();
        String read = ("select * from employee");
        if (connection != null) {
            try{
                PreparedStatement statement = connection.prepareStatement(read);
                ResultSet resultset = statement.executeQuery();

                while(resultset.next()){
                    worker.add(new Employee(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getDouble(5)));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


           // workers.add(new Employee(1, "Sami", "Yesuf", "AASTU", 40000.00));
          //  workers.add(new Employee(2, "Shalom", "Million", "AASTU", 40000.00));
          //  workers.add(new Employee(3, "Muse", "Teshome", "AASTU", 40000.00));
        }
        return worker;

    }
}