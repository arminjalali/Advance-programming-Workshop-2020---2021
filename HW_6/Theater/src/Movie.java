import java.util.ArrayList;

public class Movie {
    private String name;
    private int capacity;
    private ArrayList<Datee> datees = new ArrayList<>();

    /**
     * Constructor
     * @param name
     * @param capacity
     */
    public Movie(String name,int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Add a date to list
     * @param datee
     */
    public void addDate(Datee datee){
        datees.add(datee);
    }

    /**
     * Show list of dates
     */
    public void showDates(){
        for (int i =0;i<datees.size();i++){
            System.out.println("[" + (i+1) + "]" + datees.get(i).getDate());
        }
    }

    /**
     * Get name of movie
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get date
     * @return
     */
    public ArrayList<Datee> getDatees() {
        return datees;
    }
}
