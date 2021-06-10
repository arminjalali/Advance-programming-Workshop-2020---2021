public class Person {
    private String firstName;
    private String lastName;

    /**
     * constructor
     * @param firstName
     * @param lastName
     */
    public Person(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    /**
     * get first name of person
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get last name of person
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

}
