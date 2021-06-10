import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println("[1] Add a Hall\n[2] Add a movie\n[3] Remove a Hall\n[4] Remove a movie\n[5] Buy ticket\n\n[0] Exit");
    }
static void time(){
    System.out.println("[1] 10-12\n[2] 14-16\n[3] 16-18\n[4] 18-20\n[5] 20-22\n[6] 22-24");
}
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        ArrayList<Customer> person = new ArrayList<>();
        ReservingSystem reservingSystem = new ReservingSystem();
        while (true) {
            int choose;
            menu();
            choose = get.nextInt();
            get.nextLine();
            if (choose < 0 || choose > 5) {
                System.out.println("Error!");
                get.nextLine();
                continue;
            }
            if (choose==1) {
                System.out.println("Enter name of hall");
                String nameOfHall = get.nextLine();
                reservingSystem.addHall(new Hall(nameOfHall));
                System.out.println("Successful!");
                get.nextLine();
            }
            if (choose==2){
                if (reservingSystem.getHalls().size()==0){
                    System.out.println("No hall available!");
                    get.nextLine();
                    continue;
                }
                System.out.println("Enter name of movie");
                String nameOfMovie = get.nextLine();
                int capacity;
                while (true) {
                    System.out.println("Enter capacity");
                    capacity=get.nextInt();
                    get.nextLine();
                    if (capacity<20||capacity>999){
                        System.out.println("Error!");
                        get.nextLine();
                        continue;
                    }
                    break;
                }
                Movie movie = new Movie(nameOfMovie,capacity);
                while (true) {
                    System.out.println("Enter date (this form: 00/00/00)");
                    String date = get.nextLine();
                    int how;
                    while (true){
                        System.out.println("How many round in this day? 1 to 6");
                        how=get.nextInt();
                        get.nextLine();
                        if (how<1||how>6){
                            System.out.println("Error!");
                            get.nextLine();
                            continue;
                        }
                        break;
                    }
                    Datee datee = new Datee(date);
                    time();
                    for (int i=0;i<how;i++){
                        Time time = new Time();
                        time.assign(get.nextInt());
                        time.setCapacity(capacity);
                        time.completeAssign();
                        datee.addTime(time);
                        get.nextLine();
                    }
                    System.out.println("Add another day? Y or N?");
                    String another=get.nextLine();
                    if (another.equals("Y")){
                        movie.addDate(datee);
                    }
                    else if (another.equals("N")){
                        movie.addDate(datee);
                        break;
                    }
                    else {
                        System.out.println("Error!");
                        get.nextLine();
                    }
                }
                System.out.println("Add movie to hall");
                reservingSystem.listOfHalls();
                int whichHall;
                while (true){
                    whichHall=get.nextInt();
                    get.nextLine();
                    if (whichHall<1||whichHall>reservingSystem.getHalls().size()){
                        continue;
                    }
                    break;
                }
                reservingSystem.getHalls().get(whichHall-1).addMovie(movie);
                System.out.println("Successful!");
                get.nextLine();
            }
            if (choose ==3){
                if (reservingSystem.getHalls().size()==0){
                    System.out.println("No hall available!");
                    get.nextLine();
                    continue;
                }
                reservingSystem.listOfHalls();
                int which;
                    which=get.nextInt();
                    get.nextLine();
                    if (which<1||which>reservingSystem.getHalls().size()){
                        System.out.println("Error!");
                        get.nextLine();
                        continue;
                    }
                    reservingSystem.removeHall(which-1);
                System.out.println("Successful!");
                get.nextLine();
            }
            if (choose==4){
                if (reservingSystem.getHalls().size()==0){
                    System.out.println("No hall available!");
                    get.nextLine();
                    continue;
                }
                reservingSystem.listOfHalls();
                int which;
                which=get.nextInt();
                get.nextLine();
                if (which<1||which>reservingSystem.getHalls().size()){
                    System.out.println("Error!");
                    get.nextLine();
                    continue;
                }
                reservingSystem.getHalls().get(which-1).listOfMovies();
                int whichMovie;
                whichMovie=get.nextInt();
                get.nextLine();
                if (whichMovie<1||whichMovie>reservingSystem.getHalls().get(which-1).getMovies().size()){
                    System.out.println("Error!");
                    get.nextLine();
                    continue;
                }
                reservingSystem.getHalls().get(which-1).removeMovie(whichMovie);
                System.out.println("Successful");
                get.nextLine();
            }
            if (choose==5){
                reservingSystem.listOfHalls();
                int whichHall;
                while (true){
                    whichHall=get.nextInt();
                    get.nextLine();
                    if (whichHall<1||whichHall>reservingSystem.getHalls().size()){
                        continue;
                    }
                    break;
                }
                reservingSystem.getHalls().get(whichHall-1).listOfMovies();
                int whichMovie;
                whichMovie=get.nextInt();
                get.nextLine();
                if (whichMovie<1||whichMovie>reservingSystem.getHalls().get(whichHall-1).getMovies().size()){
                    System.out.println("Error!");
                    get.nextLine();
                    continue;
                }
                reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).showDates();
                int whichDate;
                whichDate=get.nextInt();
                get.nextLine();
                if (whichDate<1||whichDate>reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).getDatees().size()){
                    System.out.println("Error!");
                    get.nextLine();
                    continue;
                }
                reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).getDatees().get(whichDate-1).listOfTimes();
                int whichTime;
                whichTime=get.nextInt();
                get.nextLine();
                if (whichTime<1||whichTime>reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).getDatees().get(whichDate-1).getTimes().size()){
                    System.out.println("Error!");
                    get.nextLine();
                    continue;
                }
                System.out.println("Enter your phone number");
                String phone = get.nextLine();
                System.out.println("How many ticket do you want to reserve?");
                int how = get.nextInt();
                get.nextLine();
                System.out.println("Choose your seat!");
                reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).getDatees().get(whichDate-1).getTimes().get(whichTime-1).show();
                for (int i=0;i<how;i++){
                   if (reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).getDatees().get(whichDate-1).getTimes().get(whichTime-1).reserve(get.nextInt())==true){
                       Customer customer = new Customer();
                       customer.setPhoneNumber(phone);
                       customer.addMovie(reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1),reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).getDatees().get(whichDate-1),reservingSystem.getHalls().get(whichHall-1).getMovies().get(whichMovie-1).getDatees().get(whichDate-1).getTimes().get(whichTime-1));
                       person.add(customer);
                   }
                    get.nextLine();
                }
            }
            if (choose==0){
                System.exit(0);
            }
        }
    }
}