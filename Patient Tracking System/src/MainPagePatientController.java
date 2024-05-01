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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;



public class MainPagePatientController implements Initializable {
    Modle modle = new Modle();
    private sceneController sceneCon;

    @FXML
    private Button btnBookAppointment;

    @FXML
    private Button btnViewAppointment;

    @FXML
    private Button btnViewPrescription;

    @FXML
    private Button btnViewPrescription1;

    @FXML
    private Button btnViewProfile;

    @FXML
    private Button btnBookAppointment1;

    @FXML
    private Button btnHome;

    @FXML
    private Label lblPatient;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button lblViewAppointment;

    @FXML
    private Button btnViewAppointment1;

    @FXML
    private Button btnViewProfile1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneCon = new sceneController();

        btnBookAppointment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "BookAppointmentPatient.fxml", "Book appointment");
            }
        });


        
        btnViewAppointment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewAppointmentPatient.fxml", "View appointment");
            }
        });

        btnViewPrescription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewPrescriptionPatient.fxml", "View Profile");
            }
        });


        btnViewProfile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewProfilePatient.fxml", "View Profile");
            }
        });




        btnHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "MainPatientHome", "Main page");
            }
        });


        btnBookAppointment1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "BookAppointmentPatient.fxml", "Book appointment");
            }
        });


        btnViewAppointment1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewAppointmentPatient.fxml", "View appointment");
            }
        });

        btnViewProfile1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewProfilePatient.fxml", "View Profile");
            }
        });

        btnViewPrescription1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewPrescriptionPatient.fxml", "View Prescription");
            }
        });




        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "LoginPage.fxml", "log in");
            }
        });






    }
}
