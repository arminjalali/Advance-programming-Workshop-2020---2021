import java.util.ArrayList;

public class Datee {
    private String date;
    private ArrayList<Time> times = new ArrayList<>();

    /**
     * Constructor
     * @param date
     */
    public Datee(String date){
        this.date=date;
    }

    /**
     * Add a time to list
     * @param time
     */
    public void addTime(Time time){
        times.add(time);
    }

    /**
     * Print the list of times
     */
    public void listOfTimes(){
        for (int i=0;i<times.size();i++){
            System.out.println("[" + (i+1)+"] " + times.get(i).getClock());
        }
    }

    /**
     * Get time
     * @return
     */
    public ArrayList<Time> getTimes() {
        return times;
    }

    /**
     * Get date
     * @return
     */
    public String getDate() {
        return date;
    }
}
