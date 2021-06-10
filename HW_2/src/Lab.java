/**
 * Lab!
 * @author Armin
 */
public class Lab {
    private Student[] students;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;

    /**
     * creat a new Lab
     * @param cap
     * @param d
     */
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
    }

    /**
     * Check capacity of lab
     * @param std
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * Print all information
     */
    public void print() {
        for(int i=0;i<currentSize;i++){
            System.out.println("name: " + getStudents()[i].getFirstName() + " " + getStudents()[i].getLastName() + " | ID: " + getStudents()[i].getId() + " | grade: " + getStudents()[i].getGrade());
        }
        System.out.println("Average grade " + getAvg());
    }

    /**
     * get all of students
     * @return Student[] field
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     *
     * @param students set students
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * get average
     * @return avg field
     */
    public int getAvg() {
        return avg;
    }

    /**
     * calculate average of grades
     */
    public void calculateAvg() {
        avg=0;
        for(int i=0;i<currentSize;i++){
            avg+=getStudents()[i].getGrade();
        }
        avg = avg/currentSize;
    }
    /**
     * get day
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     *
     * @param day set day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * capacity of lab
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @param capacity set capacity of lab
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
