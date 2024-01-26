/*
 * The mode of a finite nonempty list of 𝑛 real numbers 𝑆 is defined as the number that occurs the 
 * most times in the list. For example, the mode of [2,3,4,5,8,2,3,4,5,4,3,3] is 3 because three occurs 
 * the most times. For each representation of 𝑆 given below, describe using pseudo-code an algorithm to 
 * compute the mode following the pseudo-code conventions from our text.
 * 
 * Name: Meg Arney
 * Class: CSCI 3342 - Algoritm Analysis
 * Assignment: HW1
 */

public class HW1P2 {
    public static void main(String[] args){
        int[] test1 = {2, 3, 4, 5, 8, 2, 3, 4, 5, 4, 3, 3};
        System.out.println("Test 1 || expected mode: 3 || mode: " + sortedMode(test1));
        
        int[] test2 = {5, 2, 3, 3, 2, 4, 5, 5, 4};
        System.out.println("Test 2 || expected mode: 5 || mode: " + sortedMode(test2));

        int[] test3 = {7, 5, 3, 4, 2, 7, 2, 6};
        System.out.println("Test 3 || expected mode: 2, 7 || mode: " + sortedMode(test3));

        int[] test4 = {4, 4, 4, 5, 6, 7, 8, 8};
        System.out.println("Test 4 || expected mode: 4 || mode: " + sortedMode(test4));

        int[] test5 = {2, 3, 3, 3, 4, 5, 5, 6, 6, 7, 7, 7};
        System.out.println("Test 5 || expected mode: 3, 7 || mode: " + sortedMode(test5));

        int[] test6 = {3, 3, 2, 1, 5, 9, 23, 1, 3, 4, 3};
        System.out.println("Test 6 || expected mode: 3 || mode: " + sortedMode(test6));

        int[] test7 = {4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8};
        System.out.println("Test 7 || expected mode: 5, 6, 7 || mode: " + sortedMode(test7));

        int[] test8 = {5, 5, 5, 5, 5};
        System.out.println("Test 8 || expected mode: 5 || mode: " + sortedMode(test8));

        int[] test9 = {1, 2, 4, 1, 2, 6, 2, 2, 1, 4, 5, 2, 2};
        System.out.println("Test 9 || expected mode: 2 || mode: " + sortedMode(test9));

        int[] test10 = {1, 8, 8, 8, 3, 1, 1, 8};
        System.out.println("Test 10 || expected mode: 8 || mode: " + sortedMode(test10));
        
    }

    public static int[] sortArr(int[] P){
        int[] S = new int[P.length];
        int min = P[0];
        for(int i = 1; i < P.length; i++){
            if(min > P[i]){
                min = P[i];
            }
        }
        int index = 0;
        int current = min;
        for(int i = 0; i < P.length; i++){
            for(int j = 0; j < P.length; j++){
                if(P[j] == current){
                    S[index] = P[j];
                    index++;
                }
            }
            current++;
        }
        return S;
    }

    public static String sortedMode(int[] P){
        int[] S = sortArr(P);
        String mode = String.valueOf(S[0]); //sets the mode to the first number
        int modeCount = 0; //the number of times the current mode has appeared
        int currentCount = 0; //the number of times the number at the index in the following for loop has appeared
        for(int i = 0; i < S.length - 1; i++){
            if(S[i+1] == S[i]){ //if the next number is the same as the current number
                currentCount++;
            }
            else{
                currentCount = 0;
            }
            if(modeCount < currentCount ){ //if the number of times the number at the current index has appeared is greated than the number of times the current mode has appeared
                mode = String.valueOf(S[i]);
                modeCount = currentCount;
            }
            else if(modeCount == currentCount){ //if there is more than one mode / a tie
                mode += ", " + String.valueOf(S[i]);
            }
        }
        return mode;
    }
}
