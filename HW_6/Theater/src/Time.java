 import java.util.ArrayList;

public class Time {
    private String clock;
    private int capacity;
    private int capacityHolder;
    private ArrayList chairs = new ArrayList();

    /**
     * Set clock
     * @param num
     */
    public void assign(int num){
        switch (num){
            case 1:
                clock="10-12";
                break;
            case 2:
                clock="14-16";
                break;
            case 3:
                clock="16-18";
                break;
            case 4:
                clock="18-20";
                break;
            case 5:
                clock="20-22";
                break;
            case 6:
                clock="22-24";
                break;
        }
    }

    /**
     * Add chairs for this time
     */
    public void completeAssign(){
        for (int i=1;i<=capacity;i++){
            if (i<10){
                chairs.add("00" + i);
            }
            else if (i>9&&i<99){
                chairs.add("0" + i);
            }
            else {
                chairs.add(""+i);
            }
        }
        capacityHolder=capacity;
    }

    /**
     * Add a capacity
     */
    public void addCapacity(){
        capacity+=1;
    }

    /**
     * Reduce a capacity
     */
    public void minusCapacity(){
        capacity-=1;
    }

    /**
     * Check capacity
     * @return
     */
    public boolean checkCapacity(){
        if (capacity<1){
            System.out.println("Error!");
            return false;
        }
        return true;
    }

    /**
     * Reserve a seat
     * @param num
     * @return
     */
    public boolean reserve(int num) {
        if (chairs.get(num - 1).equals("   ")) {
            System.out.println("Error!");
            return false;
        }
        minusCapacity();
        if (checkCapacity()) {
            chairs.set(num - 1, "   ");
            return true;
        }
        else {
            addCapacity();
            System.out.println("Error!");
            return false;
        }
    }

    /**
     * Show seats
     */
    public void show(){
        for (int i =0;i<capacityHolder;i++){
            if (i%10==0){
                System.out.println();
            }
            System.out.print(chairs.get(i)+"  ");
        }
    }

    /**
     * Get clock
     * @return
     */
    public String getClock() {
        return clock;
    }

    /**
     * Set capacity
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
