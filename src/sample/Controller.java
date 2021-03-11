package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.stage.StageStyle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static sample.Cashier_Controller.getCashier;

public class Controller {
     @FXML
     private Button xbutton;
    @FXML
    private Button utton;
     @FXML
     private Label loginmessege;
    @FXML
    private Button loginbutton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    public PieChart pi;
    @FXML
    public Label label;
    @FXML
    private Button menu;

    public void loginbuttonONAction (ActionEvent event) throws IOException, SQLException {

         if(username.getText().isBlank()==false &&password.getText().isBlank()==false){

             loginvalidate();
         }else
             loginmessege.setText("Please enter username and password");


     }
     public void xbuttonOnAction (ActionEvent event){
         
         Stage stage=(Stage) xbutton.getScene().getWindow();
         stage.close();
     }
     public void menuOnAction (ActionEvent event) throws IOException {
         Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("menu.fxml")));
         Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");

     }
    public void OrderOnAction (ActionEvent event) throws IOException {
        Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Order.fxml")));
        Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");
    }
     public void loginvalidate () throws IOException, SQLException {

         Connection connection = databaseconnection.databaseLink;

         String verifylogin ="SELECT count(1) from admins WHERE username='"+ username.getText()+"'And password='"+password.getText()+"'";

        try{
            Statement statement=connection.createStatement();
            ResultSet queryResult=statement.executeQuery(verifylogin);

            while ((queryResult.next())){
                if(queryResult.getInt(1)==1){


                    Main.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Main.fxml"))));
                    Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");
                    Main.primaryStage.show();

            }else{
                    loginmessege.setText("Invalid login, please try again");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

     }
}
