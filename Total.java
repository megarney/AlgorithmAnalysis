/*
 * Construct a divide-and-conquer algorithm for finding the total sum of an array of
 * n integers where n ≥ 1.
 * a) Provide the pseudo-code for your algorithm following the coding conventions
 * from our text.
 * b) Set up a recurrence equation for the number of basic operations for your
 * algorithm.
 * c) Use the recurrence equation to find the efficiency class for the algorithm.
 * Implement your algorithm in a file called Total.java. Include in your file a
 * method with header:
 * public static int total(int[] nums)
 * However, I would recommend having a subroutine (another method) that
 * handles the recursion.
 * Sample Run:
 * Enter the number of elements in the array: 5
 * Enter 5 integers: 1 3 5 7 9
 * The total of all elements in the array is 25.
 * 
 * Name: Meg Arney
 * Class: CSCI 3342 - Algorithm Analysis
 * Assignment: HW5
 */

import java.util.Scanner;

public class Total {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scan.nextInt();
        int[] nums = new int[n];
        scan.nextLine();

        System.out.print("Enter " + n + " integers: ");
        String elements = scan.nextLine();
        String[] placeholder = elements.split(" ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(placeholder[i]);
        }

        System.out.println("\nThe total of all elements in the array is " + total(nums));

        scan.close();
    }

    public static int total(int[] nums){
        if(nums.length != 1){
            //A = first half of the array
            int[] A = new int[nums.length/2];
            for(int i = 0; i < A.length; i++){
                A[i] = nums[i];
            }
            
            //B = second half of the array
            int[] B = new int[nums.length - nums.length/2];
            for(int i = 0; i < B.length; i++){
                B[i] = nums[A.length + i];
            }
            
            return total(A) + total(B);
        }
        return nums[0];
    }
}
