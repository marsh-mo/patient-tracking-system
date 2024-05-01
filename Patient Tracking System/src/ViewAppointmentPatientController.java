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

public class ViewAppointmentPatientController implements Initializable {
     Modle modle = new Modle();
    @FXML
    private TableColumn<Appointment, String> colDate;

    @FXML
    private TableColumn<Appointment, String> colDoctorName;

    @FXML
    private TableColumn<Appointment, String> colTime;

    @FXML
    private TableColumn<Appointment, String> colDoctorSpecialist;

    @FXML
    private Label lblViewAppointment;

    @FXML
    private TableView<Appointment> tblViewAppointment;

    @FXML
    void handleBackButton(ActionEvent event) {
        sceneController.changeScene(event, "MainPagePatient.fxml", "Main Page");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colDoctorName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctorName"));
        colDoctorSpecialist.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctorSpecialist"));
        colDate.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentDate"));
        colTime.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentTime"));
        ObservableList<Appointment> list = getAvailableAppointments();
        tblViewAppointment.setItems(list);
    }

    private ObservableList<Appointment> getAvailableAppointments() {
        ObservableList<Appointment> bookedAppointments = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            preparedStatement = connection.prepareStatement("SELECT * FROM bookedappointment WHERE Patient_Email = ?");
            preparedStatement.setString(1, getLoggedInPatientId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bookedAppointments.add(new Appointment(resultSet.getInt("Appointment_Id"),
                        resultSet.getString("Doctor_Name"), resultSet.getString("Patient_Name"),
                        resultSet.getString("Appointment_Date"), resultSet.getString("Appointment_Time"),
                        resultSet.getString("Doctor_Specialist")));
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

        return bookedAppointments;
    }

    private String getLoggedInPatientId() {
       
        String loggedInPatientEmail = modle.getPatient().getEmail();

        return loggedInPatientEmail;
    }
}
