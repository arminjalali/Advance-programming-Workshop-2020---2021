public class Main {
    public static void main(String[] args) {
        for(int i =0;i<args.length;i++){
            String str = args[i];
            for(char c : str.toCharArray()){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}