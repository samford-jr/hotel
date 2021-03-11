package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cashier_Controller {
    static TableView<Cashier> income;
    static AnchorPane pane2 = new AnchorPane();
    static Label lb2 = new Label("EMPLOYEE LIST:");
    static Button back=new Button("back");
    static Button btn5=new Button("X");

    public static void table(){

        //order_id column

        TableColumn<Cashier, Integer> Order_id = new TableColumn<>("Order_id");
        Order_id.setMinWidth(50);
        Order_id.setCellValueFactory(new PropertyValueFactory<>("Order_id"));

        //date column

        TableColumn<Cashier, String> Date = new TableColumn<>("Date");
        Date.setMinWidth(100);
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));

        //Price column

        TableColumn<Cashier, Integer> Price = new TableColumn<>("Price");
        Price.setMinWidth(100);
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        income = new TableView<>();
        income.getColumns().addAll(Order_id,Date,Price);
        income.getItems().addAll(getCashier());
        income.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        income.setLayoutY(95);
        income.setPrefSize(747, 360);

        // set the label

        lb2.setFont(Font.font(20));
        lb2.setLayoutX(350);
        lb2.setLayoutY(80);

        //set the back button

        back.setPrefHeight(40);
        back.setPrefWidth(120);
        back.setLayoutX(20);
        back.setLayoutY(10);

        //set the close button

        btn5.setPrefWidth(50);
        btn5.setPrefHeight(12);
        btn5.setLayoutY(10);
        btn5.setLayoutX(690);


        pane2.getChildren().addAll(back,lb2, income,btn5);
        pane2.setId("pane");
        Main.primaryStage.setScene(new Scene(pane2, 750, 500));
        Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");
        Main.primaryStage.show();

        back.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Main.primaryStage.setWidth(980);
                    Main.primaryStage.setHeight(591);
                    Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
                    Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");
                    pane2.getChildren().clear();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage=(Stage) btn5.getScene().getWindow();
                stage.close();
            }
        });
    }


    public static ObservableList<Cashier> getCashier() {
        ObservableList<Cashier> sources = FXCollections.observableArrayList();
        Connection connection= databaseconnection.databaseLink;
        java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
        String read = "select * from income where IDate = ?";
        if (connection != null) {
            try{
                PreparedStatement statement = connection.prepareStatement(read);
                statement.setDate(1,today);
                ResultSet resultset = statement.executeQuery();

                while(resultset.next()){

                    sources.add(new Cashier(resultset.getInt(2),resultset.getDate(3),resultset.getDouble(4)));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sources;

    }
}
