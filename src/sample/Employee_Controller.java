package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class Employee_Controller {

    static TableView<Employee> workers = new TableView<>();
    static AnchorPane pane1 = new AnchorPane();
    static Label lb1 = new Label("EMPLOYEE LIST:");
    static Button back=new Button("back");
    static Button back1=new Button("back");
    static Button add = new Button("ADD EMPLOYEE");
    static Button search_button = new Button("Search");
    static TextField search = new TextField();
    static Button btn6 = new Button("X");

    static Label lb2=new Label(" First Name:");
    static TextField ItemName= new TextField();

    static Label lb3=new Label("Last Name: ");
    static TextField x= new TextField();

    static Label lb4=new Label("Address:");
    static TextField y= new TextField();

    static Label lb5=new Label("Salary: ");
    static TextField z= new TextField();
    static Label msg=new Label(" ");
    static Button add1 = new Button("Add Employee");


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

        workers.getColumns().addAll(Employee_id, FirstName, LastName, Address, Salary);
        workers.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        workers.getItems().addAll(getEmployee());
        workers.setLayoutY(95);
        workers.setPrefSize(747, 360);


        lb1.setFont(Font.font(20));
        lb1.setLayoutX(350);
        lb1.setLayoutY(80);



        //set the back button
        back.setPrefHeight(10);
        back.setPrefWidth(100);
        back.setLayoutX(20);
        back.setLayoutY(10);

        //set the search textfield

        search.setPrefWidth(150);
        search.setPrefHeight(10);
        search.setLayoutY(70);
        search.setLayoutX(50);
        search.setPromptText("search employees here");

        search_button.setPrefWidth(80);
        search_button.setPrefHeight(5);
        search_button.setLayoutY(70);
        search_button.setLayoutX(205);
        search_button.setId("search");

        //set the add button

        add.setPrefWidth(160);
        add.setPrefHeight(10);
        add.setLayoutY(450);
        add.setLayoutX(300);


        //set the close button

        btn6.setPrefWidth(50);
        btn6.setPrefHeight(12);
        btn6.setLayoutY(10);
        btn6.setLayoutX(690);

        pane1.getChildren().addAll(back,lb1, workers, add,btn6,search,search_button);
        pane1.setId("pane");
        Main.primaryStage.setWidth(750);
        Main.primaryStage.setHeight(500);
        Main.primaryStage.setScene(new Scene(pane1, 750, 500));
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
                            pane1.getChildren().clear();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
        });
        add.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

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

                msg.setLayoutX(290);
                msg.setLayoutY(390);
                msg.setPrefWidth(350);
                msg.setId("label4");


                z.setLayoutX(265);
                z.setLayoutY(305);
                z.setPrefWidth(200);

                add1.setLayoutX(325);
                add1.setLayoutY(345);
                add1.setPrefWidth(200);

                pane1.getChildren().clear();
                pane1.getChildren().addAll(back1, btn6,add1,lb2,lb3,lb4,lb5,ItemName,x,y,z,msg);

            }
        });
        back1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                workers.getItems().clear();
                workers.getItems().addAll(getEmployee());
                pane1.getChildren().clear();
                pane1.getChildren().addAll(back,search,search_button, lb1, btn6, workers,add);

            }
        });
        add1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Connection connection= databaseconnection.databaseLink;
                String writeInventory = ("insert into  employee(First_name,Last_name,Address,Salary) values  (?, ?, ?, ?)");
                if (ItemName.getText().isEmpty()||x.getText().isEmpty()||y.getText().isEmpty()||z.getText().isEmpty())
                    msg.setText("please fill all the tabs");

                if (connection!=null){
                    try{
                        PreparedStatement statement = connection.prepareStatement(writeInventory);

                        statement.setString(1, ItemName.getText());
                        statement.setString(2, x.getText());
                        statement.setString(3, y.getText());
                        statement.setDouble(4, Double.parseDouble(z.getText()));

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
        btn6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage=(Stage) btn6.getScene().getWindow();
                stage.close();
            }
        });

        search.textProperty().addListener((observablevalue, oldValue, newValue) -> {
            ObservableList<Employee> list = FXCollections.observableArrayList();
            list = getEmployee();
            FilteredList<Employee> filteredList = new FilteredList<>(list, b -> true);
            filteredList.setPredicate(employee -> {
                if (newValue == null)
                    return true;

                String lowerNewValue = newValue.toLowerCase();

                if (String.valueOf(employee.getEmployee_id()).toLowerCase().contains(lowerNewValue))
                    return true;
                else if (employee.getFirstName().toLowerCase().contains(lowerNewValue))
                    return true;
                else
                    return false;
            });
            workers.setItems(filteredList);
        });

    }


    public static ObservableList<Employee> getEmployee() {
        ObservableList<Employee> worker = FXCollections.observableArrayList();
        Connection connection=databaseconnection.databaseLink;


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

        }
        return worker;

    }
}