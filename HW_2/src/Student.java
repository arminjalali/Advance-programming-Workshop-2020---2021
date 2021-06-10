public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lname last name of student
     * @param sID   student ID
     */
    Student(String fName, String lname, String sID) {
        firstName = fName;
        lastName = lname;
        id = sID;
        grade = 0;
    }

    /**
     * get grade of student
     * @return grade field
     */
    public int getGrade() {
        return grade;
    }

    /**
     * get first name of student
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get id of student
     * @return id field
     */
    public String getId() {
        return id;
    }

    /**
     * get last name of student
     * @return lastName field
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param firstName set first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param grade set grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     *
     * @param id set id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param lastName set id
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Print the student’s last name and ID number to the output terminal.
     */
    public void print() { System.out.println(lastName + ", student ID: " + id + ", grade: " + grade); }
}
