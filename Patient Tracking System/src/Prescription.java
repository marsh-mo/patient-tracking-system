

public class Prescription {
    private int prescriptionId;
    private int patientAge;
    private String patientGender;
    private String patientName;
    private int patientId;
    private String doctorName;
    private String medicineName;
    private String medicineInstructions;

    


    public Prescription(int prescriptionId, int patientAge, String patientGender, String patientName,int patientId ,String doctorName,
            String medicineName, String medicineInstructions) {
        this.prescriptionId = prescriptionId;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.medicineName = medicineName;
        this.medicineInstructions = medicineInstructions;
        this.patientId = patientId;
    }

    public Prescription(String patientName,String medicineName,String medicineInstructions){
        this.patientName = patientName;
        this.medicineName = medicineName;
        this.medicineInstructions = medicineInstructions;

    }


    public Prescription() {
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineInstructions() {
        return medicineInstructions;
    }

    public void setMedicineInstructions(String medicineInstructions) {
        this.medicineInstructions = medicineInstructions;
    }




    


}
