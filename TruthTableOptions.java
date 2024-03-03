/*
 * Instructions:
 * 
 * Implement your algorithm in a file called TruthTableOptions.java. 
 * Your program should read an integer from the user representing the number of propositions. 
 * The program will output all the truth table options. 
 * Your algorithm from the previous part should be implemented as a method.
 * 
 * Sample Run:
 * Enter the number of propositions: 3
 * The 8 options are:
 * TTT
 * TTF
 * TFT
 * TFF
 * FTT
 * FTF
 * FFT
 * FFF
 */

 import java.util.Scanner;

public class TruthTableOptions {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of propositions: ");
        int n = scan.nextInt();

        System.out.println("The " + (int)Math.pow(2,n) + " options are:");

        String[] truthTable = new String[(int)Math.pow(2,n)];
        truthTable = truthTableOptions(truthTable, n);

        for(int i = 0; i < truthTable.length; i++){
            System.out.println(truthTable[i]);
        }

        scan.close();
    }

    public static String[] truthTableOptions(String[] truthTable, int n){
        int count = (int)Math.pow(2,n);
        int index;
        for(int column = 0; column < n; column++){
            index = 0;
            for(int row = 0; row < truthTable.length; row++){
                if(index < count/2){
                    if(truthTable[row] != null){
                        truthTable[row] = truthTable[row] + "T";
                    }
                    else{
                        truthTable[row] = "T";
                    }
                }
                else{
                    if(truthTable[row] != null){
                        truthTable[row] = truthTable[row] + "F";
                    }
                    else{
                        truthTable[row] = "F";
                    }
                }
                index++;
                if(index == count){
                    index = 0;
                }
            }
            count = count/2;
        }
        return truthTable;
    }
}
