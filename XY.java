import java.util.Scanner;

public class XY {

    private static String input;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string consisting of X's or Y's:");
        input = scan.nextLine();
        scan.close();

        System.out.println("\n" + countYbeforeX(input) + " substrings start with Y and end with X.");
    }

    public static int countYbeforeX(String str){
        int substrings = 0;
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i)==('Y')){
                for(int j = i+1; j < str.length(); j++){
                    if(str.charAt(j)==('X')){
                        substrings++;
                    }
                }
            }
        }
        return substrings;
    }
}
