import java.util.ArrayList;
import java.util.Date;

public class Patient {
    private Date birthday;
    private String basicInsurance;
    private String supplementalInsurance;
    private String degreeOfEducation;
    private String job;
    private String location;
    private String geographicalLocation;
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    /**
     * Initial parameters
     * @param birthday
     * @param basicInsurance
     * @param supplementalInsurance
     * @param degreeOfEducation
     * @param job
     * @param location
     * @param geographicalLocation
     */
    public Patient(Date birthday , String basicInsurance , String supplementalInsurance , String degreeOfEducation , String job , String location , String geographicalLocation){
        this.birthday = birthday;
        this.birthday = birthday;
        this.supplementalInsurance = supplementalInsurance;
        this.degreeOfEducation = degreeOfEducation;
        this.job = job;
        this.location = location;
        this.geographicalLocation = geographicalLocation;
    }

    /**
     * Add a sickness to list
     */
    public void addSickness(){}

    /**
     * Get type of basic insurance
     * @return
     */
    public String getBasicInsurance() {
        return basicInsurance;
    }

    /**
     * Get list of medical records
     * @return
     */
    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    /**
     * Get date of doctor check up
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Get degree of education
     * @return
     */
    public String getDegreeOfEducation() {
        return degreeOfEducation;
    }

    /**
     * Get geographical location
     * @return
     */
    public String getGeographicalLocation() {
        return geographicalLocation;
    }

    /**
     * Get job of patient
     * @return
     */
    public String getJob() {
        return job;
    }

    /**
     * Get location
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * Get type of supplemental insurance
     * @return
     */
    public String getSupplementalInsurance() {
        return supplementalInsurance;
    }

    /**
     * Print all data
     * @return
     */
    @Override
    public String toString() {
        return "Patient{" +
                "birthday=" + birthday +
                ", basicInsurance='" + basicInsurance + '\'' +
                ", supplementalInsurance='" + supplementalInsurance + '\'' +
                ", degreeOfEducation='" + degreeOfEducation + '\'' +
                ", job='" + job + '\'' +
                ", location='" + location + '\'' +
                ", geographicalLocation='" + geographicalLocation + '\'' +
                ", medicalRecords=" + medicalRecords +
                '}';
    }
}
