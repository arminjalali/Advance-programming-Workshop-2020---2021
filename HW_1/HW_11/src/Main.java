import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int num1,num2,first=0,second=0;
        num1 = get.nextInt();
        num2 = get.nextInt();
        if (num1 < 2 || num2 < 2){
            System.out.println("Not Prime");
            System.exit(0);
        }
        if (num1>num2){
            first = num2;
            second = num1;
        }
        else if (num2>num1){
            first = num1;
            second = num2;
        }
        else{
            System.out.println("Not prime!");
            System.exit(0);
        }
        for (int i = 2 ;i<=first;i++){
            if (first%i==0&&second%i==0){
                System.out.println("Not prime!");
                System.exit(0);
            }
        }
        System.out.println("Prime");
    }
}
