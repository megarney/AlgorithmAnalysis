/*
 * Design an algorithm to determine if a set 𝐴 is a subset of another set 𝐵. 
 * You should provide the pseudocode for your algorithm following the conventions of our book. 
 * Your algorithm will take as input two integer arrays and return a boolean (true if 𝐴⊆𝐵, false otherwise).
 * Implement your algorithm in a file named Subset.java. You should have a method with the following header:
 * public static boolean isSubset(int[] A, int[] B)
 * The main program should read two integer arrays from the console, call the method above implementing your 
 * algorithm, and based on the result (true/false) print out one of the following messages:
 * A is a subset of B.
 * A is NOT a subset of B.
 * 
 * Name: Meg Arney
 * Class: CSCI 3342 - Algoritm Analysis
 * Assignment: HW1
 */

import java.util.Scanner;

public class Subset {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //creates the array A according to the number of elements in the array
        System.out.print("Enter the number of elements in the first array: ");
        int aLength = scan.nextInt();

        int[] arrA = new int[aLength];
        scan.nextLine();

        //adds the elements to array A
        System.out.print("Enter the elements of A: ");
        String aElements = scan.nextLine();

        aElements = aElements.replaceAll("\\s", ""); //gets rid of all the spaces
        String[] placeholderA = aElements.split(",");
        for(int i = 0; i < aLength; i++){
            arrA[i] = Integer.parseInt(placeholderA[i]);
        }

        //creates the array B according to the number of elements in the array
        System.out.print("Enter the number of elements in the second array: ");
        int bLength = scan.nextInt();

        int[] arrB = new int[bLength];
        scan.nextLine();

        //adds the elements to array B
        System.out.print("Enter the elements of B: ");
        String bElements = scan.nextLine();

        bElements = bElements.replaceAll("\\s", ""); //gets rid of all the spaces
        String[] placeholderB = bElements.split(",");
        for(int i = 0; i < bLength; i++){
            arrB[i] = Integer.parseInt(placeholderB[i]);
        }

        //output:
        if(isSubset(arrA, arrB)){
            System.out.println("A is a subset of B");
        }
        else{
            System.out.println("A is NOT a subset of B");
        }

        scan.close();
    }

    public static boolean isSubset(int[] A, int[] B){
        boolean bHASa = false;
        //Compares each of the elements in A to all of the elements in B
        for(int a = 0; a < A.length; a++){
            for(int b = 0; b < B.length; b++){
                if(A[a] == B[b]){
                    bHASa = true;
                }
            }
            if(!bHASa){
                return false; //if, at any point, one of the elements that is in A is not in B, returns false
            }
            else{
                bHASa = false;
            }
        }
        return true; //if false is never returned, return true
    }
}
