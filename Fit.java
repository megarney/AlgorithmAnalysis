/*
 * Name: Meg Arney
 * Due Date: 4/17
 * File: Fit.java
 * Description: Given an array of numbers between 0 and 1 divide the array into disjoint subsets 
 * such that the sum of the elements in each subset is less than or equal to 1.
 */

import java.util.Scanner;

public class Fit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many numbers are in the array: ");
        int n = scan.nextInt();
        double[] nums = new double[n];
        scan.nextLine();

        System.out.print("Enter the members of the array (all between 0 and 1): \n");
        String elements = scan.nextLine();
        String[] placeholder = elements.split(" ");
        nums[0] = 0;
        for(int i = 0; i < n; i++){
            nums[i] = Double.parseDouble(placeholder[i]);
            if(nums[i] < 0 || nums[i] > 1){
                System.out.println(nums[i] + " is an invalid input");
                System.exit(0);
            }
        }

        System.out.println("\nThe partition is as follows:");
        disjointSubsets(nums);

        scan.close();
    }

    public static void disjointSubsets(double[] nums){
        double total = 0;
        int index = 0;
        String print = "";
        while(total != 1 && index < nums.length){
            if(nums[index] != -1 && total + nums[index] <= 1){
                total += nums[index];
                print += nums[index] + ",";
                nums[index] = -1;
            }
            index++;
        }
        print = print.substring(0, print.length()-1);
        System.out.println("{" + print + "}");
        boolean repeat = false;
        index = 0;
        while(!repeat && index < nums.length){
            if(nums[index] != -1){
                repeat = true;
            }
            index++;
        }
        if(repeat == true){
            disjointSubsets(nums);
        }
        }
}
