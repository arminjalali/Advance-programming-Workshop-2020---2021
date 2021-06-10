import java.util.ArrayList;

public class VotingSystem {
    ArrayList<Voting> votingList = new ArrayList<Voting>();

    /**
     * creat a vote
     * @param question
     * @param type
     * @param options
     */
    public void createVoting(String question,int type,ArrayList <String> options){
        Voting voting = new Voting(type,question);
        ArrayList<String> setOptions = new ArrayList<>();
        for(int i=0;i<options.size();i++){
            setOptions.add("(Q" +(votingList.size()+1)+")" + options.get(i));

        }
        voting.setOption(setOptions);
        votingList.add(voting);
    }

    /**
     * get voting list
     * @return
     */
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    /**
     * print list of voting
     */
    public void printListOfVoting(){
        for(int i=0;i<getVotingList().size();i++){
            System.out.println("[" + (i+1)+"] " + getVotingList().get(i).getQuestion());
        }
    }

    /**
     * print options of a question
     * @param which
     */
    public void printOptionsOfAQuestion(int which){
        getVotingList().get(which).printOptions();
    }

    /**
     * register a vote
     * @param which
     * @param person
     * @param numberOfChoose
     */
    public void voting(int which,Person person,int numberOfChoose){
        getVotingList().get(which).vote(numberOfChoose,person);
    }

    /**
     * get result of voting
     */
    public void getResult(){
        for (int i=0;i<getVotingList().size();i++){
            getVotingList().get(i).calculateAndPrintResult();
        }
    }
}
