import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;

public class ViewProfileDoctorController implements Initializable{
    Modle modle = new Modle();

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSignOut;

    @FXML
    private Button btnWritePrescriptionSide;

    @FXML
    private Button btnViewPatientDetalis1;


    @FXML
    private TableColumn<Patient,String> colPatientEmail;/////

    @FXML
    private TableColumn<Patient,String> colName;////

    @FXML
    private TableColumn<Patient, String> colPhoneNumber;////

    @FXML
    private TableColumn<Patient, String> colGender;////

    @FXML
    private TableColumn<Patient, String> colAge;

    @FXML
     private Label lblPatientDetalis;

     @FXML
    private TableView<Patient> tblPatientDetails;

 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colPatientEmail.setCellValueFactory(new PropertyValueFactory<Patient , String>("email"));
        colName.setCellValueFactory(new PropertyValueFactory<Patient , String>("name"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<Patient , String>("phoneNumber"));
        colGender.setCellValueFactory(new PropertyValueFactory<Patient , String>("gender"));
        colAge.setCellValueFactory(new PropertyValueFactory<Patient, String>("dateOfBirth"));

 
        
        ObservableList<Patient> list = modle.getDoctor().viewPatient();
        tblPatientDetails.setItems(list);

      
       


        btnViewPatientDetalis1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "ViewProfileDoctor.fxml", "view the patients detalis");
            }
        });

        btnWritePrescriptionSide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneController.changeScene(event, "WritePrescriptionDoctor.fxml", "Write Prescription");
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
        
    
    }


}
