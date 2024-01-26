/*
 * There are 𝑛 doors in a hallway, numbered sequentially from 1 to 𝑛. 
 * Initially, all are closed. You make 𝑛 passes by the doors, each time starting with door #1. 
 * On the 𝑖th pass, you toggle the state of every 𝑖th door: if the door is closed, you open it; if it is open, you close it. 
 * After the last pass, explain which doors are open and which are closed and why.
 * 
 * Name: Meg Arney
 * Class: CSCI 3342 - Algoritm Analysis
 * Assignment: HW1
 */

public class HW1P1 {
   
    public static void main(String[] args){
        
        String[] test1 = {"C", "C", "C", "C", "C"};
        System.out.println("Test 1 || odd || elements: " + test1.length + "\n" + promblem1(test1));
        
        String[] test2 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 2 || even || elements: " + test2.length + "\n" + promblem1(test2));
        
        String[] test3 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 3 || odd || elements: " + test3.length + "\n" + promblem1(test3));

        String[] test4 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 4 || even || elements: " + test4.length + "\n" + promblem1(test4));

        String[] test5 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 5 || even || elements: " + test5.length + "\n" + promblem1(test5));

        String[] test6 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 5 || odd || elements: " + test6.length + "\n" + promblem1(test6));

        String[] test7 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 5 || even || elements: " + test7.length + "\n" + promblem1(test7));

        String[] test8 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 8 || odd || elements: " + test8.length + "\n" + promblem1(test8));

        String[] test9 = {"C", "C", "C", "C"};
        System.out.println("\nTest 9 || even || elements: " + test9.length + "\n" + promblem1(test9));

        String[] test10 = {"C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 10 || odd || elements: " + test10.length + "\n" + promblem1(test10));
        
        String[] test11 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        System.out.println("\nTest 8 || odd || elements: " + test11.length + "\n" + promblem1(test11));
        
    }

    public static String promblem1(String[] doors){
        int currentIndex;
        for (int i = 1; i <= doors.length + 1; i++){ //keeps track of the ith door
            currentIndex = i;
            for(int j = 1; j <= doors.length + 1; j++){
                if(j%(i) == 0){
                    if(currentIndex < doors.length + 1){
                        if(doors[currentIndex - 1].equals("C")){
                            doors[currentIndex - 1] = "O";
                        }
                        else{
                            doors[currentIndex - 1] = "C";
                        }
                    }
                    currentIndex = currentIndex + i;
                }
            }
            currentIndex = 0;
        }
        String output = "";
        for (String door : doors){
            output += door + " ";
        }
        return output;
    }
}