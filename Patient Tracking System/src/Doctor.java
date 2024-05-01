import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class Doctor extends User {

    private Prescription prescription;
    private Modle model;

    public Doctor(int id, String name, String email, String password, String phoneNumber, String gender, int age) {
        super(id, name, email, password, phoneNumber, gender, age);
        model = new Modle();
    }

    public Doctor(int id, String name, String phoneNumber, String gender, int age) {
        super(id, name, phoneNumber, gender, age);
        model = new Modle();
    }

    public Doctor() {
        model = new Modle();
    }

    public boolean login() {
        return super.login("doctor");
    }

    public ObservableList<Patient> viewPatient() {
        ObservableList<Patient> patients = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            preparedStatement = connection.prepareStatement("SELECT * FROM Patient");

          
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
              
               String email = resultSet.getString("Patient_Email");
                String name = resultSet.getString("Patient_Name");
                String phoneNumber = resultSet.getString("Patient_Phone_Number");
                String gender= resultSet.getString("Patient_Gender");
                LocalDate dob = resultSet.getDate("Patient_DOB").toLocalDate();
                

                Patient patient = new Patient(email, name, phoneNumber, gender, dob.toString());
                patients.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return patients;
    }

    // public void writePrescription(Prescription prescription, int patientId) {
    //     Connection connection = null;
    //     PreparedStatement preparedStatement = null;

    //     try {
    //         connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");

    //         String sql = "INSERT INTO prescription (patient_id, Medicine_Instructions) VALUES (?, ?)";
    //         preparedStatement = connection.prepareStatement(sql);
    //         preparedStatement.setInt(1, patientId);
    //         preparedStatement.setString(2, prescription.getPrescription());

    //         preparedStatement.executeUpdate();

    //         this.prescription = prescription;

    //         System.out.println("Prescription saved successfully.");

    //     } catch (SQLException e) {
    //         System.out.println("Error executing SQL statement: " + e.getMessage());
    //     } finally {
    //         try {
    //             if (preparedStatement != null) preparedStatement.close();
    //             if (connection != null) connection.close();
    //         } catch (SQLException e) {
    //             System.out.println("Error closing resources: " + e.getMessage());
    //         }
    //     }
    // }
}
