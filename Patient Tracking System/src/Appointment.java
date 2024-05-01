public class Appointment {

    private int appointmentId;
    private  String appointmentDate;
    private String PatientNumber;
    private String PatientName;
    private  String doctorName;
    private  String appointmentTime;
    private   String doctorSpecialist;

  



    public Appointment(int appointmentId, String doctorName,String PatientName, String appointmentDate, String appointmentTime, String doctorSpecialist) {
    this.appointmentId = appointmentId;
    this.doctorName = doctorName;
   
    this.PatientName = PatientName;
    this.appointmentDate = appointmentDate;
    this.appointmentTime = appointmentTime;
    this.doctorSpecialist = doctorSpecialist;
}


    public Appointment(int appointmentId, String appointmentDate, String patientNumber, String patientName,
            String doctorName, String appointmentTime, String doctorSpecialist) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        PatientNumber = patientNumber;
        PatientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
        this.doctorSpecialist = doctorSpecialist;

        
    }


public Appointment( String doctorName,String doctorSpecialist ,String appointmentDate,
String appointmentTime ) {

this.appointmentDate = appointmentDate;
this.doctorName = doctorName;
this.appointmentTime = appointmentTime;
this.doctorSpecialist = doctorSpecialist;




}


    public int getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getPatientNumber() {
        return PatientNumber;
    }
    public void setPatientNumber(String patientNumber) {
        PatientNumber = patientNumber;
    }
    public String getPatientName() {
        return PatientName;
    }
    public void setPatientName(String patientName) {
        PatientName = patientName;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public String getDoctorSpecialist() {
        return doctorSpecialist;
    }
    public void setDoctorSpecialist(String doctorSpecialist) {
        this.doctorSpecialist = doctorSpecialist;
    }


    

    
}
