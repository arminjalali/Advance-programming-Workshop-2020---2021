public class College {
    private String name;
    private Lab[] labs;
    private int avg;
    private int size;

    /**
     * constructor
     * @param name
     */
    public College(String name){
    this.name=name;
    size=0;

}

    /**
     *
     * @param avg set average
     */
    public void setAvg(int avg) {
        this.avg = avg;
    }

    /**
     *
     * @param labs set list of labs
     */
    public void setLabs(Lab[] labs) {
        this.labs = labs;
    }

    /**
     *
     * @param name set name of lab
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get average
     * @return avg field
     */
    public int getAvg() {
        return avg;
    }

    /**
     * get list of labs
     * @return labs field
     */
    public Lab[] getLabs() {
        return labs;
    }

    /**
     * get name of lab
     * @return name field
     */
    public String getName() {
        return name;
    }

    /**
     * add a lab to list
     * @param lab
     */
    public void addLab(Lab lab){
        labs[size] = lab;
        size++;
    }

    /**
     * print all information
     */
    public void print(){
        System.out.println("name: " + name + " - number of labs: " + size + " - Average: " + getAvg());
    }

    /**
     * calculate average of grades
     */
    public void calculateAvg(){
    avg=0;
    for (int i=0;i<size;i++){
        avg+=getLabs()[i].getAvg();
    }
        avg = avg/size;
    }
}
