import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WritePrescriptionDoctorController implements Initializable {
    
    @FXML
    private Button btnViewPatientDetalis1;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSignOut;

    @FXML
    private Button btnWritePrescriptionSide;

    @FXML
    private Label lblMedicine;

    @FXML
    private Label lblPatientName;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblPatientEmail;

    @FXML
    private Label lblPrescription;

    @FXML
    private Label lblWritePrescription;

    @FXML
    private TextField txtPatientEmail;

    @FXML
    private TextArea txtPrescription;

    @FXML
    private TextField txtPatientName;

    @FXML
    private TextField txtMedicine;

    private Modle model = new Modle();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
                sceneController.changeScene(event, "ViewProfileDoctor.fxml", "view the patients detalis");
            }
        });
    }

    @FXML
    void onClickSave(ActionEvent event) {
        String patientEmail = txtPatientEmail.getText().trim();
        String prescription = txtPrescription.getText().trim();
        String patientName = txtPatientName.getText().trim();
        String medicineName = txtMedicine.getText().trim();

        if (patientEmail.isEmpty()) {
            showAlert("Please write patient's ID");
            return;
        } else if (prescription.isEmpty()) {
            showAlert("Please write prescription");
            return;
        }

        boolean patientExists = checkPatientExists(patientEmail);

        if (!patientExists) {
            showAlert("Patient does not exist!");
            return;
        } else {
            boolean success = storePrescription(patientEmail, prescription,patientName ,medicineName);
            if (success) {
                showAlert("Prescription written successfully.");
            } else {
                showAlert("Failed to store prescription.");
            }
        }




    }

    private boolean checkPatientExists(String patientEmail) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            String query = "SELECT COUNT(*) FROM patient WHERE Patient_Email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, patientEmail);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(resultSet, statement, connection);
        }

        return false;
    }

    private boolean storePrescription(String patientEmail, String medicineInstructions, String patientName , String medicineName) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            String insertQuery = "INSERT INTO prescription (Patient_Email, Medicine_Instructions, Patient_Name,Medicine_Name) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, patientEmail);
            statement.setString(2, medicineInstructions);
            statement.setString(3,patientName);
            statement.setString(4,medicineName);

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int prescriptionId = generatedKeys.getInt(1);
                    System.out.println("Generated Prescription_Id: " + prescriptionId);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, connection);
        }

        return false;
    }

    private void closeResources(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
        try {
        resultSet.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
        if (statement != null) {
        try {
        statement.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
        if (connection != null) {
        try {
        connection.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
    }



        private void showAlert(String message) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(message);
            alert.show();
        }
    }

