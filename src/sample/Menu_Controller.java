package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;



    public class Menu_Controller {
        @FXML
        public Button Back;
        @FXML
        public Button btn4;
        public void BackOnAction (ActionEvent event) throws IOException {
            Main.primaryStage.setWidth(938);
            Main.primaryStage.setHeight(591);
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
            Main.primaryStage.getScene().getRoot().getStylesheets().add("/styles/main.css");

        }
        public void xbutton4OnAction (ActionEvent event){

            Stage stage=(Stage) btn4.getScene().getWindow();
            stage.close();
        }
    }


