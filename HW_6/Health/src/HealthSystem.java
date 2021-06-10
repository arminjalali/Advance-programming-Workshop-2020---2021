import java.util.ArrayList;

public class HealthSystem {
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<MedicalRecord> diseases = new ArrayList<>();

    /**
     * The whole treatment process
     */
    public void treatment(){

    }

    /**
     * Add a doctor to list
     */
    public void addADoctorToList(){

    }

    /**
     *
     * Add a patient to list
     */
    public void addAPatientToList(){

    }

    /**
     * Add a sickness to list
     */
    public void addASickness(){

    }

    /**
     * Get list of doctors
     * @return
     */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Get list of diseases
     * @return
     */
    public ArrayList<MedicalRecord> getDiseases() {
        return diseases;
    }

    /**
     * Get list of patients
     * @return
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Print all data
     * @return
     */
    @Override
    public String toString() {
        return "HealthSystem{" +
                "doctors=" + doctors +
                ", patients=" + patients +
                ", diseases=" + diseases +
                '}';
    }
}
