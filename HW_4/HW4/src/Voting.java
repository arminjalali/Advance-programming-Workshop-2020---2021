import ir.huri.jcal.JalaliCalendar;
import java.util.*;

public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters = new ArrayList<>();
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String,HashSet<Vote>> polls = new HashMap<String, HashSet<Vote>>();
    public Voting(int type,String question){
        this.type=type;
        this.question=question;
    }
    /**
     * get question
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * get the list of voters
     * @return voters
     */
    public ArrayList<Person> getVoters() {
        return voters;
    }

    /**
     * get options of a question
     * @return options
     */
    public ArrayList<String> getOptions() {
        return options;
    }
    public void printOptions(){
        for (int i=0;i<getOptions().size();i++){
            System.out.println("[" + (i+1)+"] " + getOptions().get(i));
        }
    }
    public void printOptions2(){
        for (int i=0;i<getOptions().size();i++){
            System.out.println("[" + (i+1)+"] " + getOptions().get(i));
           HashSet<Vote> set =  polls.get(getOptions().get(i));
      //     for (int j = 0 ; j< set.size(); j++){
        //       System.out.println(set);
          // }
    //        for (int j = 0 ; j < polls.get(getOptions().get(i)).size() ; j++) {
            Iterator<Vote> it = polls.get(getOptions().get(i)).iterator();
                while (it.hasNext()) {
                    System.out.println(((Vote)it.next()).getPerson().getFirstName());
      //          }
            }
        }
    }

    /**
     * set options
     * @param options
     */
    public void setOption(ArrayList<String> options){
        this.options=options;
        for(int i=0;i<options.size();i++){
            HashSet<Vote> hashSet = new HashSet<>();
            getPolls().put(options.get(i),hashSet);
        }
    }

    /**
     * register a vote
     * @param option
     * @param person
     */
    public void vote(int option,Person person) {
        for(Vote v :getPolls().get(getOptions().get(option))) {
            if (v.person.getFirstName().equals(person.getFirstName())&&v.person.getLastName().equals(person.getLastName())){
                System.out.println("Error!");
                return;
            }
        }
        JalaliCalendar jalaliCalendar = new JalaliCalendar();
        String date = jalaliCalendar.getYear()+"/"+jalaliCalendar.getMonth()+"/"+jalaliCalendar.getDay();
        getPolls().get(getOptions().get(option)).add(new Vote(person,date));
        getVoters().add(person);
        System.out.println("Successful!");
    }

    /**
     * print a  question with options
     */
    public void printQuestion(){
        System.out.println(question);
        printOptions2();
    }

    /**
     * remove duplicated elements
     */
    public void removeDuplicated(){
        for (int i=0;i<getVoters().size();i++){
            for (int j=i;j<getVoters().size();j++){
                if (getVoters().get(i).getFirstName().equals(getVoters().get(j).getFirstName())&&getVoters().get(i).getLastName().equals(getVoters().get(j).getLastName())&&i!=j){
                    getVoters().remove(j);
                }
            }
        }
    }
    /**
     * print voters that vote
     */
    public void printVoters(){
        System.out.println("Question: " + question+"\nVoters: ");
        Set<Map.Entry<String,HashSet<Vote>>> map = getPolls().entrySet();
        for(int i=0;i<getVoters().size();i++){
            System.out.print(getVoters().get(i).getFirstName()+" "+getVoters().get(i).getLastName()+" ");
            for (Map.Entry<String,HashSet<Vote>> a : map){
                for (Vote vote : a.getValue()){
                    if (vote.getPerson().getFirstName().equals(getVoters().get(i).getFirstName())&&vote.getPerson().getLastName().equals(getVoters().get(i).getLastName())){
                        System.out.println(vote.getDate()+" ");
                    }
                }
            }
        }
    }

    /**
     * get list of polls
     * @return
     */
    public HashMap<String, HashSet<Vote>> getPolls() {
        return polls;
    }
    /**
     * check duplicated
     * @param person
     * @return
     */
    public boolean justOneVote(Person person){
        for (int i=0;i<getVoters().size();i++){
            if (getVoters().get(i).getFirstName().equals(person.getFirstName())&&getVoters().get(i).getLastName().equals(person.getLastName())){
                return false;
            }
        }
        return true;
    }
    /**
     * get type of roll
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * calculate and print result
     */
    public void calculateAndPrintResult(){
        System.out.println("Question: " + question);
        Set<Map.Entry<String,HashSet<Vote>>> traverse = getPolls().entrySet();
        int counter=0;
        for (Map.Entry<String, HashSet<Vote>> it : traverse){
            counter+=it.getValue().size();
        }
        for (Map.Entry<String, HashSet<Vote>> it : traverse){
            System.out.println(it.getKey() + " --> " + (((double)it.getValue().size()/counter)*100));
        }
    }
}
