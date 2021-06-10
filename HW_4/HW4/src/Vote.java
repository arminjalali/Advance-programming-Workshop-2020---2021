import java.util.Date;

public class Vote {
    Person person;
    String date;
    public Vote(Person person, String date){
        this.person=person;
        this.date=date;
    }

    /**
     * get person
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * get date
     * @return date
     */
    public String getDate() {
        return date;
    }

}
