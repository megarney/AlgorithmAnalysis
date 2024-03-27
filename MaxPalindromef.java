import java.util.Scanner;

public class MaxPalindromef {
    public static void main(String[] args){
        //read the integer from the console
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the integer: ");
        int number = console.nextInt();

        //find the max palindrome and display the number
        //to the console
        int max = maxPalindrome(number);
        System.out.println("The maximal palindrome is " + max);

        console.close();
    }

    /*
     * Given an integer with n digits, this method creates
     * the maximal palindrome from the digits of the given number
     * @param num - a positive integer
     * @return - an integer representing the maximal palindrome
     */
    public static int maxPalindrome(int num){
        //find the number with the largest number of odd number of 
        //occurences and make that the middle
        
        String numStr = Integer.toString(num); //int to string
        char[] ch = numStr.toCharArray(); //string to char array
        int[][] arr = new int[numStr.length()][2]; //2-d int array: row 1 = ints; row 2 = frequency of int
        for(int i = 0; i < numStr.length(); i++){ //fill row 1 of 2-d array
            arr[i][0] = Character.getNumericValue(ch[i]);
            arr[i][1] = 1;
        }
        //fill in row 2
        for(int i = 0; i < numStr.length()-1; i++){
            for(int j = i+1; j < numStr.length(); j++){
                if(arr[i][0] == arr[j][0]){
                    arr[i][1] = arr[i][1] + 1;
                }
            }
        }

        int len = numStr.length(); //number of unique integers

        //if the number is a repeat, the 'length' is -1
        for(int i = numStr.length()-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[i][0] == arr[j][0]){
                    arr[i][1] = -1;
                    len--;
                    break;
                }
            }
        }

        //find the largest odd frequency and get rid of other ones
        int oddFreq = 0;
        int middle = -1;
        for(int i = 0; i < numStr.length(); i++){
            if(arr[i][1]%2 == 1 && arr[i][1] > oddFreq){
                oddFreq = arr[i][1];
                middle = arr[i][0];
            }
            else if(arr[i][1]%2 == 1 && arr[i][1] == 1){
                arr[i][1] = -1;
            }
            System.out.print(arr[i][1] + " ");
        }

        String result = "";

        //if the number of unique numbers is made of all even frequency of ints
        if(middle == -1){
            result += Integer.toString(arr[0][0]);
        }
        else{

        }

        return middle;
        
        
        /*
         * 
        arr[numStr.length()-1][1] = 1;
        for(int i = 0; i < numStr.length(); i++){

        }
         */
    }
}
