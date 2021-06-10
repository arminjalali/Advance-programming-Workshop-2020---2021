import java.util.Date;

public class MedicalRecord{
    private String typeOfDisease;
    private String sickCondition;
    private String physicianDiagnosis;
    private String securityLevel;
    private String medicine;
    private Date date;
    private Doctor doctor;

    /**
     * Set date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Set doctor
     * @param doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Prescription medicine
     * @param medicine
     */
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    /**
     * Set physical diagnosis
     * @param physicianDiagnosis
     */
    public void setPhysicianDiagnosis(String physicianDiagnosis) {
        this.physicianDiagnosis = physicianDiagnosis;
    }

    /**
     * Set security level
     * @param securityLevel
     */
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * Set condition of patient
     * @param sickCondition
     */
    public void setSickCondition(String sickCondition) {
        this.sickCondition = sickCondition;
    }

    /**
     * Set Type of diseases
     * @param typeOfDisease
     */
    public void setTypeOfDisease(String typeOfDisease) {
        this.typeOfDisease = typeOfDisease;
    }

    /**
     * Get date
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get doctor
     * @return
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Get medicine
     * @return
     */
    public String getMedicine() {
        return medicine;
    }

    /**
     * Get physical diagnosis
     * @return
     */
    public String getPhysicianDiagnosis() {
        return physicianDiagnosis;
    }

    /**
     * Get security level of diseases
     * @return
     */
    public String getSecurityLevel() {
        return securityLevel;
    }

    /**
     * Get condition of patient
     * @return
     */
    public String getSickCondition() {
        return sickCondition;
    }

    /**
     * get type of disease
     * @return
     */
    public String getTypeOfDisease() {
        return typeOfDisease;
    }

    /**
     * Print all data
     * @return
     */
    @Override
    public String toString() {
        return "MedicalRecord{" +
                "typeOfDisease='" + typeOfDisease + '\'' +
                ", sickCondition='" + sickCondition + '\'' +
                ", physicianDiagnosis='" + physicianDiagnosis + '\'' +
                ", securityLevel='" + securityLevel + '\'' +
                ", medicine='" + medicine + '\'' +
                ", date=" + date +
                ", doctor=" + doctor +
                '}';
    }
}
