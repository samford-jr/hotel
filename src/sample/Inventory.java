package sample;

//import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
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
     static Button back=new Button("back");
    static Button back1=new Button("back");
     static TextField search = new TextField();
     static Button search_button = new Button("search");
    static Button add = new Button("Add Items");

    // lables and buttons for the purchase Scene

    static Label lb2=new Label("Item Name:");
    static TextField ItemName= new TextField();

    static Label lb3=new Label("Price per Unit: ");
    static TextField x= new TextField();

    static Label lb4=new Label("Quantity:");
    static TextField y= new TextField();

    static Label lb5=new Label("Purchaser_id: ");
    static TextField z= new TextField();
    static Label msg=new Label(" ");
    static Button add1 = new Button("Add Items");



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
        inventory.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //inventory.setLayoutX(600);
        inventory.setLayoutY(95);
        inventory.setPrefSize(747,360);

        Label lb1=new Label("INVENTORY LIST:");
        lb1.setFont(Font.font(20));

        lb1.setLayoutX(350);
        lb1.setLayoutY(80);

        btn1.setPrefWidth(50);
        btn1.setPrefHeight(10);
        btn1.setLayoutY(10);
        btn1.setLayoutX(690);

        back.setPrefWidth(100);
        back.setPrefHeight(10);
        back.setLayoutY(10);
        back.setLayoutX(20);

        search.setPrefWidth(150);
        search.setPrefHeight(10);
        search.setLayoutY(70);
        search.setLayoutX(50);
        search.setPromptText("search items here");

        search_button.setPrefWidth(80);
        search_button.setPrefHeight(5);
        search_button.setLayoutY(70);
        search_button.setLayoutX(205);
        search_button.setId("search");

        add.setPrefWidth(160);
        add.setPrefHeight(10);
        add.setLayoutY(450);
        add.setLayoutX(300);

        back1.setPrefWidth(100);
        back1.setPrefHeight(10);
        back1.setLayoutY(10);
        back1.setLayoutX(20);


          //one.getChildren().addAll(inventory);
       // if(flag==0) {
            pane.getChildren().addAll(back,search,search_button, lb1, btn1, inventory,add);
            pane.setId("pane");

            pane.getStylesheets().add("/styles/main.css");

            // xbutton2.getScene().getWindow().getScene().setRoot(one);
            //  Main.primaryStage.getScene().setRoot(one);
        Main.primaryStage.setWidth(750);
        Main.primaryStage.setHeight(500);
          Main.primaryStage.setScene(new Scene(pane, 750, 500));

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
                //Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
               /* inventory.getItems().clear();
                inventory.getItems().addAll(getproduct());
                pane.getChildren().clear();
                pane.getChildren().addAll(back1,search,search_button, lb1, btn1, inventory,add);*/
                    Main.primaryStage.setWidth(980);
                    Main.primaryStage.setHeight(591);
                try {
                    Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");
                    //Main.primaryStage.setScene(new Scene(root, 938, 591));
                    pane.getChildren().clear();
                // pane.getChildren().removeAll(back,lb1,btn1,inventory);
                // flag=1;

                //Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
            }
        });
        back1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                //Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                inventory.getItems().clear();
                inventory.getItems().addAll(getproduct());
                pane.getChildren().clear();
                pane.getChildren().addAll(back,search,search_button, lb1, btn1, inventory,add);
                  /*  Main.primaryStage.setWidth(980);
                    Main.primaryStage.setHeight(591);
                    Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
                    Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");
                    //Main.primaryStage.setScene(new Scene(root, 938, 591));
                    pane.getChildren().clear();*/
                // pane.getChildren().removeAll(back,lb1,btn1,inventory);
                // flag=1;

                //Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
            }
        });
        add.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public  void handle(MouseEvent mouseEvent) {
                msg.setText(" ");

                lb2.setLayoutX(100);
                lb2.setLayoutY(130);
                lb2.setPrefWidth(250);
                lb2.setId("label4");

                ItemName.setLayoutX(250);
                ItemName.setLayoutY(140);
                ItemName.setPrefWidth(200);

                lb3.setLayoutX(100);
                lb3.setLayoutY(175);
                lb3.setPrefWidth(250);
                lb3.setId("label4");


                x.setLayoutX(265);
                x.setLayoutY(180);
                x.setPrefWidth(200);

                lb4.setLayoutX(100);
                lb4.setLayoutY(235);
                lb4.setPrefWidth(250);
                lb4.setId("label4");


                y.setLayoutX(265);
                y.setLayoutY(245);
                y.setPrefWidth(200);

                lb5.setLayoutX(100);
                lb5.setLayoutY(300);
                lb5.setPrefWidth(250);
                lb5.setId("label4");

                msg.setLayoutX(325);
                msg.setLayoutY(375);
                msg.setPrefWidth(350);
                msg.setId("label4");


                z.setLayoutX(265);
                z.setLayoutY(305);
                z.setPrefWidth(200);

                add1.setLayoutX(325);
                add1.setLayoutY(345);
                add1.setPrefWidth(100);

                pane.getChildren().clear();
                pane.getChildren().addAll(back1, btn1,add1,lb2,lb3,lb4,lb5,ItemName,x,y,z,msg);


                // pane.getChildren().removeAll(back,lb1,btn1,inventory);
                // flag=1;

                //Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("Main.fxml")));
            }
        });
        add1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Connection connection= databaseconnection.databaseLink;
                String writeInventory = ("insert into inventory(item_name,qauntity_kg,price_unit,purchaser_id) values (?, ?, ?, ?)");
                if (ItemName.getText().isEmpty()||x.getText().isEmpty()||y.getText().isEmpty()||z.getText().isEmpty())
                    msg.setText("please fill all the tabs");

                if (connection!=null){
                    try{
                        PreparedStatement statement = connection.prepareStatement(writeInventory);

                        statement.setString(1, ItemName.getText());
                        statement.setDouble(2, Double.parseDouble(x.getText()));
                        statement.setDouble(3, Double.parseDouble(y.getText()));
                        statement.setInt(4, Integer.parseInt(z.getText()));

                        int i = statement.executeUpdate();
                        msg.setText("successfully added a new item");

                        if (i <= 0){
                            System.out.println("the database is not working jhkjhkjhkjh");
                        }
                    }
                    catch(Exception e) {
                        System.out.println("the database is not working qqqqqq");
                    }
                }
                else
                    System.out.println("the database is not working cccccc");


            }

        });
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage=(Stage) btn1.getScene().getWindow();
                stage.close();
            }
        });
        search.textProperty().addListener((observablevalue, oldValue, newValue) -> {
            ObservableList<product> list = FXCollections.observableArrayList();
            list = getproduct();
            FilteredList<product> filteredList = new FilteredList<>(list, b -> true);
            filteredList.setPredicate(product -> {
                if (newValue == null)
                    return true;

                String lowerNewValue = newValue.toLowerCase();

                if (String.valueOf(product.getPurchaser_id()).toLowerCase().contains(lowerNewValue))
                    return true;
                else if (product.getName().toLowerCase().contains(lowerNewValue))
                    return true;
                else
                    return false;
            });
            inventory.setItems(filteredList);
        });
    }



   public void xbutton2OnAction(ActionEvent event){
   // table();
       Stage stage=(Stage) xbutton2.getScene().getWindow();
        stage.close();
    }
    public static ObservableList<product> getproduct(){
        ObservableList<product> items= FXCollections.observableArrayList();
        //Connection connection = databaseconnection.getConnection();
        Connection connection= databaseconnection.databaseLink;
        String read = ("select * from inventory");
        if (connection != null) {
            try{
                PreparedStatement statement = connection.prepareStatement(read);
                ResultSet resultset = statement.executeQuery();
                //System.out.println("this is  a demo");
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

