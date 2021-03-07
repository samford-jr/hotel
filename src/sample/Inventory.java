package sample;

//import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.stage.StageStyle.UNDECORATED;

public class Inventory implements Initializable {
     static AnchorPane pane =new AnchorPane();
    static VBox one=new VBox();
   static Button btn1=new Button("x");
    static Button back=new Button("<=");
    static  int flag = 0;
@FXML
static
Button xbutton2;
@FXML
static
TableView<product> inventory;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public static void table() throws IOException {
//name column
        System.out.println(flag);
        TableColumn<product, String> Name= new TableColumn<>("item_name");
        Name.setMinWidth(200);
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));

        //quantity column
        TableColumn<product, Integer> Quantity = new TableColumn<>("quantity");
        Quantity.setMinWidth(100);
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        //quantity column
        TableColumn<product, Double> Price = new TableColumn<>("unit_price");
        Price.setMinWidth(100);
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        //purchaser_id column
        TableColumn<product, Integer> Purchaser_id = new TableColumn<>("purchaser_id");
        Purchaser_id.setMinWidth(100);

        Purchaser_id.setCellValueFactory(new PropertyValueFactory<>("Purchaser_id"));

        inventory = new TableView<>();
        inventory.getColumns().addAll(Name,Quantity,Price,Purchaser_id);

        inventory.getItems().addAll(getproduct());
        //inventory.setLayoutX(600);
        inventory.setLayoutY(40);
        inventory.setPrefSize(700,300);

        Label lb1=new Label("INVENTORY LIST:");
        lb1.setFont(Font.font(20));
        lb1.setStyle("bold");
        lb1.setLayoutX(280);
        lb1.setLayoutY(10);

        btn1.setPrefWidth(40);
        btn1.setPrefHeight(12);
        btn1.setLayoutY(0);
        btn1.setLayoutX(660);

        back.setPrefWidth(40);
        back.setPrefHeight(12);
        back.setLayoutY(13);
        back.setLayoutX(40);


          //one.getChildren().addAll(inventory);
       // if(flag==0) {
            pane.getChildren().addAll(back, lb1, btn1, inventory);

            // xbutton2.getScene().getWindow().getScene().setRoot(one);
            //  Main.primaryStage.getScene().setRoot(one);
        Main.primaryStage.setWidth(705);
        Main.primaryStage.setHeight(405);
            Main.primaryStage.setScene(new Scene(pane, 695, 400));
            // Main.primaryStage.initStyle(UNDECORATED);
            Main.primaryStage.show();
        //}
        //else if(flag==1){
          //  Main.primaryStage.setScene(new Scene(pane, 695, 400));
           // Main.primaryStage.getScene().setRoot(pane);
        //}
       // Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Inventory.fxml")));
            //sample.Main.stage2.show();
//          Stage stage=(Stage) xbutton2.getScene().getWindow().getScene().setRoot(one);
//            Stage st = new Stage();
//    st.setScene(new Scene(one, 938, 591));
//            st.show();
//          stage.setScene(new Scene(one, 938, 591));
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    //Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                    Main.primaryStage.setWidth(980);
                    Main.primaryStage.setHeight(591);
                    Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
                    //Main.primaryStage.setScene(new Scene(root, 938, 591));
                    pane.getChildren().clear();
                   // pane.getChildren().removeAll(back,lb1,btn1,inventory);
                     flag=1;

                    //Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }



   public void xbutton2OnAction(ActionEvent event){
   // table();
//        Stage stage=(Stage) xbutton2.getScene().getWindow();
  //      stage.close();
    }
    public static ObservableList<product> getproduct(){
        ObservableList<product> items= FXCollections.observableArrayList();
        Connection connection = databaseconnection.getConnection();
        String read = ("select * from inventory");
        if (connection != null) {
            try{
                PreparedStatement statement = connection.prepareStatement(read);
                ResultSet resultset = statement.executeQuery();
                System.out.println("this is  a demo");
                while(resultset.next()){
                    //items.add(new Employee(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getDouble(5)));
                    items.add(new product(resultset.getString(2),resultset.getInt(3),resultset.getDouble(4),resultset.getInt(5)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            // workers.add(new Employee(1, "Sami", "Yesuf", "AASTU", 40000.00));
            //  workers.add(new Employee(2, "Shallom", "Million", "AASTU", 40000.00));
            //  workers.add(new Employee(3, "Muse", "Teshome", "AASTU", 40000.00));
        }
        return items;

    }
        //items.add(new product("Onion",5,13.00,01));
        //items.add(new product("Potato",5,10.00,01));
        //items.add(new product("Tomato",5,9.00,01));
        //items.add(new product("Spice",5,3.00,01));
        //return items;

   public Inventory() throws IOException {
      table();
}

}

