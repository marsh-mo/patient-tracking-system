import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewPrescriptionPatientController implements Initializable {
   Modle modle = new Modle();
    @FXML
    private Button btnHome;


    @FXML
    private TableColumn<Prescription, String> colPatientName;

    @FXML
    private TableColumn<Prescription, String> colMedicineName;

    @FXML
    private TableColumn<Prescription, String> colMedicineInstruction;

    @FXML
    private Label lblViewPrescription;

    @FXML
    private TableView<Prescription> tblViewPrescription;

    @FXML
    void onClickHome(ActionEvent event) {
        sceneController.changeScene(event, "MainPagePatient.fxml", "Home page");
    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colPatientName.setCellValueFactory(new PropertyValueFactory<Prescription, String>("patientName"));
        colMedicineName.setCellValueFactory(new PropertyValueFactory<Prescription, String>("medicineName"));
        colMedicineInstruction.setCellValueFactory(new PropertyValueFactory<Prescription, String>("medicineInstructions"));
       
        ObservableList<Prescription> list = getPrescriptionInformation();
        tblViewPrescription.setItems(list);
    }

    private ObservableList<Prescription> getPrescriptionInformation() {
        ObservableList<Prescription> getPrescription = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            preparedStatement = connection.prepareStatement("SELECT * FROM prescription WHERE Patient_Email = ?");
            preparedStatement.setString(1, getLoggedInPatientId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               
                getPrescription.add(new Prescription(resultSet.getString("Patient_Name"), resultSet.getString("Medicine_Name"),resultSet.getString("Medicine_Instructions")));   
                       
                        
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return getPrescription;
    }

    private String getLoggedInPatientId() {
       
        String loggedInPatientEmail = modle.getPatient().getEmail();

        return loggedInPatientEmail;
    }





}
