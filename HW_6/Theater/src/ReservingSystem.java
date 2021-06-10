import java.util.ArrayList;

public class ReservingSystem {
    private ArrayList<Hall> halls = new ArrayList<>();

    /**
     * Add a hall to list
     * @param hall
     */
    public void addHall(Hall hall){
        halls.add(hall);
    }

    /**
     * Remove a hall from list
     * @param num
     */
    public void removeHall(int num){
        halls.remove(num);
    }

    /**
     * Print list of halls
     */
    public void listOfHalls(){
        for (int i=0;i<halls.size();i++){
            System.out.println("[" + (i+1)+"] " + halls.get(i).getName());
        }
    }

    /**
     * Get list of halls
     * @return
     */
    public ArrayList<Hall> getHalls() {
        return halls;
    }
}
