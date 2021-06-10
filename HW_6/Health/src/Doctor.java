import java.util.ArrayList;

public class Doctor {
    private String reviewOfMedicalHistory;
    private String prescribe;
    private Doctor referToAnotherDoctor;
    private ArrayList<Patient> patients;

    /**
     * Get considered doctor
     * @return
     */
    public Doctor getReferToAnotherDoctor() {
        return referToAnotherDoctor;
    }

    /**
     * Get prescribe of doctor
     * @return
     */
    public String getPrescribe() {
        return prescribe;
    }

    /**
     * Get review of medical history
     * @return
     */
    public String getReviewOfMedicalHistory() {
        return reviewOfMedicalHistory;
    }

    /**
     * GetListOfPatient
     * @return
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Prescribe medication based on symptoms
     */
    public void setPrescribe(){}

    /**
     * Refer to another doctor
     */
    public void setReferToAnotherDoctor(){}

    /**
     * Print all data
     * @return
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "reviewOfMedicalHistory='" + reviewOfMedicalHistory + '\'' +
                ", prescribe='" + prescribe + '\'' +
                ", referToAnotherDoctor=" + referToAnotherDoctor +
                ", patients=" + patients +
                '}';
    }
}
