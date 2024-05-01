import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Statement;

public class BookAppointmentPatientController implements Initializable {
    private Modle model = new Modle();

    @FXML
    private Button btnBook;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<Appointment, String> colDate;

    @FXML
    private TableColumn<Appointment, String> colDoctorName;

    @FXML
    private TableColumn<Appointment, String> colTime;

    @FXML
    private TableColumn<Appointment, String> colDoctorSpecialist;

    @FXML
    private Label lblBookAppointment;

    @FXML
    private TableView<Appointment> tblBookAppointment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
            colDoctorName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctorName"));
            colDoctorSpecialist.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctorSpecialist"));
            colDate.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentDate"));
            colTime.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentTime"));
         
        
            ObservableList<Appointment> list = model.getPatient().selectAppointment();
            tblBookAppointment.setItems(list);
        
            tblBookAppointment.setEditable(true);
            colDoctorName.setCellFactory(TextFieldTableCell.forTableColumn());
        
            // tblBookAppointment.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            // tblBookAppointment.getSelectionModel().setCellSelectionEnabled(true);
        
            // colDoctorName.setCellFactory(TextFieldTableCell.forTableColumn());
            // colDoctorName.setOnEditCommit(event -> {
            //     TablePosition<Appointment, String> pos = event.getTablePosition();
            //     String newDoctorName = event.getNewValue();
            //     int row = pos.getRow();
            //     Appointment appointment = event.getTableView().getItems().get(row);
            //     appointment.setDoctorName(newDoctorName);
            //     model.getPatient().updateAppointment(appointment);
            // });
        }
        

    
        @FXML
        void onClickBook(ActionEvent event) {
            Appointment selectedAppointment = tblBookAppointment.getSelectionModel().getSelectedItem();
            if (selectedAppointment != null) {
                String doctorName = selectedAppointment.getDoctorName();
                String doctorSpecialist = selectedAppointment.getDoctorSpecialist();
                String date = selectedAppointment.getAppointmentDate();
                String time = selectedAppointment.getAppointmentTime();
                
               
                String patientEmail = model.getPatient().getEmail();
                String patientName = model.getPatient().getName();
                
                boolean success = bookedappointment(doctorName, patientEmail, patientName, date, time, doctorSpecialist);
                if (success) {
                    showAlert("Appointment booked successfully.");
                   model.getPatient().deleteAvailableAppointment(doctorName, date, time,doctorSpecialist);
                }
            }  else {
                showAlert("Failed to book the appointment.");
            }
        }


        private boolean bookedappointment(String doctorName, String patientEmail, String patientName, String appointmentDate, String appointmentTime, String doctorSpecialist) {
            Connection connection = null;
            PreparedStatement statement = null;
        
            try {
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
                String insertQuery = "INSERT INTO bookedappointment (Doctor_Name, Patient_Email, Patient_Name, Appointment_Date, Appointment_Time, Doctor_Specialist) VALUES (?, ?, ?, ?, ?, ?)";
                statement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        
                statement.setString(1, doctorName);
                statement.setString(2, patientEmail);
                statement.setString(3, patientName);
                statement.setString(4, appointmentDate);
                statement.setString(5, appointmentTime);
                statement.setString(6, doctorSpecialist);
        
                int affectedRows = statement.executeUpdate();
        
                if (affectedRows > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int appointmentId = generatedKeys.getInt(1);
                        System.out.println("Generated Appointment_Id: " + appointmentId);
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

   
    
        private void closeResources(ResultSet resultSet, PreparedStatement statement, Connection connection) {
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


        

    @FXML
    private void handleBackButton(ActionEvent event) {
        sceneController.changeScene(event, "MainPagePatient.fxml", "Main Page");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }
}
