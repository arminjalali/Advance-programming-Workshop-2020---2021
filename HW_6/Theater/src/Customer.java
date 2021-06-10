import java.util.ArrayList;

public class Customer {
    private String phoneNumber;
    private ArrayList<ArrayList> movies = new ArrayList<>();

    /**
     * Add a movie to list
     * @param movie
     * @param datee
     * @param time
     */
    public void addMovie(Movie movie,Datee datee,Time time){
       ArrayList arrayList = new ArrayList();
       arrayList.add(movie);
       arrayList.add(datee);
       arrayList.add(time);
       movies.add(arrayList);
    }

    /**
     * Set phone number of customer
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
