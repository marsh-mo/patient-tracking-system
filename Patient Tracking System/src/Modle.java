public class Modle {
    

    private static Patient patient;
   
    private static Doctor doctor;

    private static Admin admin;
  
    


    public static Patient getPatient() {
        return patient;
    }


    public static void setPatient(Patient patient) {
        Modle.patient = patient;
    }


  


    public static Doctor getDoctor() {
        return doctor;
    }


    public static void setDoctor(Doctor doctor) {
        Modle.doctor = doctor;
    }


    public static Admin getAdmin() {
        return admin;
    }


    public static void setAdmin(Admin admin) {
        Modle.admin = admin;
    }




}
