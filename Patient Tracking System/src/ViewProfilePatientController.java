import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;

public class ViewProfilePatientController implements Initializable {

Patient patient = new Patient();

    
    Modle modle = new Modle();
    @FXML
    private Button btnEdit;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblViewProfile;

    @FXML
    private PasswordField passPassword;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;




    @Override
    public void initialize(URL location, ResourceBundle resources) {



        txtName.setText(modle.getPatient().getName());
        // System.out.println(modle.getPatient().getPhoneNumber());
        // System.out.println(modle.getPatient().getGender());
        txtPhoneNumber.setText(modle.getPatient().getPhoneNumber());
        txtGender.setText(modle.getPatient().getGender());
        passPassword.setText(modle.getPatient().getPassword());
       
    }

        




        @FXML
        void onClickHome(ActionEvent event) {
            sceneController.changeScene(event, "MainPagePatient.fxml", "Home page");
        }



    
}


