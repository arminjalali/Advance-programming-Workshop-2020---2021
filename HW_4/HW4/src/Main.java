import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void menu(){
        System.out.println(
                "[1] Create voting\n" +
                        "[2] Register vote\n" +
                        "[3] Show list of questions\n" +
                        "[4] Show list of voters\n" +
                        "[5] Show result\n\n" +
                        "[0] Exit"
        );
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        Random random = new Random();
        VotingSystem votingSystem = new VotingSystem();
        while (true) {
            menu();
            int choose = get.nextInt();
            get.nextLine();
            if (choose<0||choose>5){
                System.out.println("Out of range!");
                get.nextLine();
                continue;
            }
            if (choose==1){
                System.out.println("Enter the question");
                String question = get.nextLine();
                System.out.println("Enter 0 for single-vote mode or enter 1 for multi-vote mode");
                int type = get.nextInt();
                get.nextLine();
                ArrayList<String> options = new ArrayList<>();
                System.out.println("Enter the number of options");
                int numOfOptions= get.nextInt();
                get.nextLine();
                if(numOfOptions<2||type>1||type<0){
                    System.out.println("Error!");
                    get.nextLine();
                    continue;
                }
                for(int i=0;i<numOfOptions;i++){
                    System.out.println("Enter option number " + (i+1));
                    options.add(get.nextLine());
                }
                votingSystem.createVoting(question,type,options);
            }
            if(choose==2) {
                System.out.println("Enter the first name");
                String first = get.nextLine();
                System.out.println("Enter the last name");
                String last = get.nextLine();
                Person person = new Person(first, last);
                System.out.println("Choose question");
                votingSystem.printListOfVoting();
                int whichQuestion = get.nextInt();
                get.nextLine();
                if (votingSystem.getVotingList().get(whichQuestion - 1).justOneVote(person) == false) {
                    System.out.println("You have already voted!");
                    get.nextLine();
                    continue;
                }
                int numOfVote;
                if (votingSystem.getVotingList().get(whichQuestion - 1).getType() == 1) {
                    System.out.println("Multi-vote mode: How many options do you want to choose? max is: " + votingSystem.getVotingList().get(whichQuestion - 1).getOptions().size());
                    numOfVote = get.nextInt();
                    get.nextLine();
                    if (numOfVote < 2 || numOfVote > votingSystem.getVotingList().get(whichQuestion - 1).getOptions().size()) {
                        System.out.println("Error");
                        get.nextLine();
                        continue;
                    }
                } else {
                    numOfVote = 1;
                }
                int manualOrRandom=0;
                if (numOfVote == 1){
                    System.out.println("[1] Manual\n[2] Random");
                    manualOrRandom = get.nextInt();
                    get.nextLine();
                    if (manualOrRandom < 1 || manualOrRandom > 2) {
                        System.out.println("Error!");
                        get.nextLine();
                        continue;
                    }
                }
                votingSystem.printOptionsOfAQuestion(whichQuestion-1);
                for (int i=0;i<numOfVote;i++) {
                    int chooseOption;
                    if (manualOrRandom==1) {
                        chooseOption = get.nextInt();
                        get.nextLine();
                    }
                    else {
                        chooseOption=random.nextInt((votingSystem.getVotingList().get(whichQuestion - 1).getOptions().size())+1);
                    }
                    if (chooseOption < 1 || chooseOption > votingSystem.getVotingList().get(whichQuestion - 1).getOptions().size()) {
                        System.out.println("Error");
                        get.nextLine();
                        continue;
                    }
                    System.out.println("Random: " + chooseOption);
                    votingSystem.voting(whichQuestion-1,person,chooseOption-1);
                    votingSystem.getVotingList().get(whichQuestion-1).removeDuplicated();
                }
            }
            if (choose==3){
                for(int i=0;i<votingSystem.getVotingList().size();i++){
                    votingSystem.getVotingList().get(i).printQuestion();
                    System.out.println();
                    get.nextLine();
                }
            }
            if (choose==4){
                for(int i=0;i<votingSystem.getVotingList().size();i++){
                    votingSystem.getVotingList().get(i).printVoters();
                    System.out.println();
                }
            }
            if (choose==5){
                votingSystem.getResult();
                get.nextLine();
            }
            if (choose==0){
                System.exit(0);
            }
        }
    }
}
