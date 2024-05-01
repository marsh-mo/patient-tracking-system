import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Patient extends User {
    private Prescription prescription;
    private String dateOfBirth;
    private String date;
    private String time;
    private String doctorSpecilist;
 
    private List<Appointment> appointments;

         Modle modle = new Modle();
    public Patient(){
        
    }
  
    // public Patient(String name, String email, String password, String phoneNumber, String gender) {
    //     super(name, email, password, phoneNumber,gender);
       
    // }
    

    // public Patient(String name, String email, String password, String phoneNumber) {
    //     super(name, email, password, phoneNumber);
    // }

    public Patient(int id, String name, String phoneNumber, String gender, int age) {
        super(id, name, phoneNumber, gender, age);
    }

    public Patient(String name, String email, String password, String phoneNumber, String gender, String dateOfBirth) {
        super(name, email, password, phoneNumber,gender);
        
        this.dateOfBirth = dateOfBirth;
    }

    public Patient(String email ,String name ,String phoneNumber,String gender,String dob){
        this.dateOfBirth = dob;
        super.setEmail(email);
        super.setName(name);
        super.setPhoneNumber(phoneNumber);
        super.setGender(gender);
        
       
    }

    public Patient(String name,String date,String time,String doctorSpecilist){
        super.setName(name);
        this.date = date;
        this.time = time;
        this.doctorSpecilist = doctorSpecilist;
       

    }
   


    public String getDateOfBirth() {
        
        return dateOfBirth;
    }


    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }


    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


   
  
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }


    public boolean login() {
        return super.login("patient");
    }

    public boolean signup() {
        boolean excepted = false;
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM patient WHERE Patient_Email = ?");
            psCheckUserExists.setString(1, super.getEmail());
            resultSet = psCheckUserExists.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                excepted = true;
                psInsert = connection.prepareStatement("INSERT INTO patient(Patient_Name, Patient_Email, Patient_Password, Patient_Phone_Number, Patient_Gender, Patient_DOB) VALUES (?, ?, ?, ?, ?, ?)");
                psInsert.setString(1, super.getName());
                psInsert.setString(2, super.getEmail());
                psInsert.setString(3, super.getPassword());
                psInsert.setString(4, super.getPhoneNumber());
                psInsert.setString(5, super.getGender());
                psInsert.setDate(6, java.sql.Date.valueOf(dateOfBirth));
                psInsert.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (psCheckUserExists != null) psCheckUserExists.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (psInsert != null) psInsert.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return excepted;
    }
    public ObservableList<Appointment> selectAppointment() {
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
    
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            preparedStatement = connection.prepareStatement("SELECT * FROM avalibleappointment");
            resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                String doctorName = resultSet.getString("Doctor_Name");
                String doctorSpecialist = resultSet.getString("Doctor_specialist");
                String appointmentDate = resultSet.getString("Appointment_Date");
                String appointmentTime = resultSet.getString("Appointment_Time");
    
                Appointment appointment = new Appointment(doctorName, doctorSpecialist, appointmentDate, appointmentTime);
                appointmentList.add(appointment);
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
    
        return appointmentList;
    }

    public boolean deleteAvailableAppointment(String doctorName, String appointmentDate, String appointmentTime, String doctorSpe) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
            String deleteQuery = "DELETE FROM avalibleappointment WHERE Doctor_Name = ? AND Appointment_Date = ? AND Appointment_Time = ?  AND Doctor_Specialist = ?";
            statement = connection.prepareStatement(deleteQuery);

            statement.setString(1, doctorName);
            statement.setString(2, appointmentDate);
            statement.setString(3, appointmentTime);
            statement.setString(4, doctorSpe);

            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;
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


    private Patient getUserProfile(){

        
        return  (modle.getPatient());
    }
   


}

    
    

    // public boolean updateAppointment(Appointment appointment, String patientName, int patientId) {
    //     try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
    //          PreparedStatement preparedStatement = connection.prepareStatement("INSERT appointment SET Patient_Id = ?, Patient_Name = ? WHERE Appointment_Date = ? AND Doctor_Name = ? AND Appointment_Time = ? AND Doctor_Specialist = ?")) {
    //         patientId = 5;
    //         preparedStatement.setInt(1, patientId);
    //         preparedStatement.setString(2, patientName);
    //         preparedStatement.setString(3, appointment.getAppointmentDate());
    //         preparedStatement.setString(4, appointment.getDoctorName());
    //         preparedStatement.setString(5, appointment.getAppointmentTime());
    //         preparedStatement.setString(6, appointment.getDoctorSpecialist());
    
    //         int rowsAffected = preparedStatement.executeUpdate();
    //         return rowsAffected > 0;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    
    //     return false;
    // }

    // public void updateAppointment(Appointment appointment) {
    // }
    
    
    
    



