import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainPageDoctorController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnViewPatientDetalis;

    @FXML
    private Button btnViewPatientDetalis1;

    @FXML
    private Button btnWritePrescription;

    @FXML
    private Button btnSignOut;

    @FXML
    private Label lblPatient;

    @FXML
    private Button btnWritePrescriptionSide;

    private sceneController sceneController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneController = new sceneController(); 

        btnWritePrescription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "WritePrescriptionDoctor.fxml", "Write Prescription");
            }
        });

        btnWritePrescriptionSide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "WritePrescriptionDoctor.fxml", "Write Prescription2");
            }
        });


        btnSignOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "LoginPage.fxml", "log in");
            }
        });



        btnHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "MainPageDoctor.fxml", "Home page");
            }
        });


        
        btnViewPatientDetalis1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewProfileDoctor.fxml", "view the patients detalis1");
            }
        });


        btnViewPatientDetalis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewProfileDoctor.fxml", "view the patients detalis");
            }
        });


    }
}

