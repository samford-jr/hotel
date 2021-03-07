package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
import java.sql.Statement;

public class Controller {
     @FXML
     private Button xbutton;
    @FXML
    private Button utton;
     @FXML
     private Label loginmessege;
   // @FXML
   // private Button loginbutton;
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
    Stage stage2=new Stage();


     public void loginbuttonONAction (ActionEvent event) throws IOException {

        // if(username.getText().isBlank()==false &&password.getText().isBlank()==false){

             loginvalidate();
         //}else
           //  loginmessege.setText("Please enter username and password");


     }
     public void xbuttonOnAction (ActionEvent event){
         
         Stage stage=(Stage) xbutton.getScene().getWindow();
         stage.close();
     }
     public void menuOnAction (ActionEvent event){}
     public void loginvalidate () throws IOException {
       //  databaseconnection connection=new databaseconnection();
         //Connection connectDB= connection.getConnection();

         //String verifylogin ="SELECT count(1) from admins WHERE username='"+ username.getText()+"'And password='"+password.getText()+"'";

       /* try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(verifylogin);

            while ((queryResult.next())){
                if(queryResult.getInt(1)==1){
          */
                    Parent root2 = FXMLLoader.load(getClass().getResource("Main.fxml"));

                   Main.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Main.fxml"))));
                    Main.primaryStage.show();
                  /* //stage2.initStyle(StageStyle.UNDECORATED);
                   /* HBox one=new HBox();
                    Button btn=new Button("this is a demo");
                    one.getChildren().add(btn);*/
                    //stage2.setScene(new Scene(root2, 938, 591));
                    //stage2.show();

                    //loginmessege.setText("congratulations!");
            /*    }else{
                    loginmessege.setText("Invalid login, please try again");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }*/

     }
}
