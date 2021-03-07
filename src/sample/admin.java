package sample;

//import javafx.embed.swing.JFXPanel;
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
import java.util.ResourceBundle;

//import java.awt.*;

public class admin implements Initializable {



    @FXML
    public TableView tableView;
    @FXML
    private Button xbutton1;
    @FXML
    public Button purchase;
    @FXML
    public Button Employees;

    @FXML
    public PieChart pi;
    @FXML
    public Label label1;
    VBox vbox= new VBox();
    Button btn=new Button("this is a demo");
    public void xbutton1OnAction (ActionEvent event){

        Stage stage=(Stage) xbutton1.getScene().getWindow();
        stage.close();
    }

    public void btn(ActionEvent event) {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("java", 50),
                new PieChart.Data("python", 25),
                new PieChart.Data("c++", 20),
                new PieChart.Data("c#", 5)
        );
        pi.setData(list);

        for (PieChart.Data data : pi.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    label1.setText(String.valueOf(data.getPieValue()) + "%");
                }

            });
        }

    }

    public void purchaseOnAction (ActionEvent event) throws IOException {
        //Pane p = new sample.Inventory();

        //vbox.getChildren().add(btn);
       // Stage stage=(Stage) purchase.getScene().getWindow();
       Inventory.table();
        /*Main.primaryStage.setScene(new Scene(*/
        //FXMLLoader.load(getClass().getResource("Inventory.fxml"));



        //Main.stage2.show();
        //Parent root3 = FXMLLoader.load(getClass().getResource("Inventory.fxml"));

        //stage.setScene(new Scene(root3, 938, 591));
    }
    public void EmployeesOnAction (ActionEvent event) throws IOException {

        sample.Employee_Controller.table();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
