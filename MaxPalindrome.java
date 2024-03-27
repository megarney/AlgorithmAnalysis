import java.util.Scanner;

public class MaxPalindrome {
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
        int[] freq = {0,0,0,0,0,0,0,0,0,0}; //index corresponds directly to num
        char[] set = (Integer.toString(num)).toCharArray();

        for(int i = 0; i < set.length; i++){
            freq[Character.getNumericValue(set[i])]++;
        }

        //find first odd
        int firstOdd = -1;
        for(int i = 0; i < 10; i++){
            if(firstOdd == -1 && freq[i]%2 == 1){
                firstOdd = i;
                freq[i]--;
            }
            else if(freq[i]%2 == 1){
                freq[i]--;
            }
        }

        //len = length of the palidrome
        int len = 0;
        for(int i = 1; i < 10; i++){
            len += freq[i];
        }
        if(firstOdd != -1){
            len++;
        }

        int[] result = new int[len];

        if(len%2==1){
            result[(len/2)] = firstOdd;
        }

        String firstHalf = "";
        for(int i = 1; i < 10; i++){
            if(freq[i] != 0){
                for(int j = 0; j < freq[i]/2; j++){
                    firstHalf += Integer.toString(i);
                }
            }
        }

        char[] ch = firstHalf.toCharArray();
        for(int i = 0; i < len/2; i++){
            result[i] = Character.getNumericValue(ch[i]);
            result[result.length-(i+1)] = Character.getNumericValue(ch[i]);
        }

        String full = "";
        for(int i = 0; i < len; i++){
            full += result[i];
        }

        return Integer.valueOf(full);
    }
}
