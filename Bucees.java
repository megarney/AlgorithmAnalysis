import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bucees {
    public static void main(String[] args) throws IOException{
        File inputFile = new File("land.dat");
        Scanner file = new Scanner(inputFile);

        //get the size of the table
        int rows = file.nextInt();
        int cols = file.nextInt();

        //read in the table
        int[][] plots = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                plots [i][j] = file.nextInt();
            }
        }

        //find the max side and display the results
        int maxSide = findMaxSide(plots);
        System.out.println("The maximum square area takes up " + maxSide * maxSide + " plots.");

        file.close(); //close the file
    }

    public static int findMaxSide(int[][] plots){
        //bucR represents the number in a row by rows
        int[][] bucR = new int[plots.length][plots[0].length];
        bucR[0][0] = plots[0][0];

        //bucC represents the number in a row by cols
        int[][] bucC = new int[plots.length][plots[0].length];
        bucC[0][0] = plots[0][0];

        //fills first row
        for(int i = 1; i < plots[0].length; i++){
            if(plots[0][i] == 1){
                bucC[0][i] = bucC[0][i] + 1;
            }
            else{
                bucC[0][i] = 0;
            }
        }

        //fills rest of arrays
        for(int row = 1; row < plots.length; row++){
            if(plots[row][0] == 1){
                bucR[row][0] = bucR[row][0] + 1;
            }
            else{
                bucR[row][0] = 0;
            }
            for(int col = 1; col < plots[0].length; col++){
                if(plots[row][col] == 1){
                    //checks to make sure it is a square
                    if(plots[row-1][col-1] == 0){
                        bucR[row][col] = 1;
                        bucC[row][col] = 1;
                    }
                    else{
                        bucR[row][col] = bucR[row][col-1] + 1;
                        bucC[row][col] = bucC[row-1][col] + 1;
                    }
                }
                else{
                    bucR[row][col] = 0;
                    bucC[row][col] = 0;
                }
            }
        }

        //finds the max that is equal in both arrays
        int max = 0;
        for(int i = 0; i < plots.length; i++){
            for(int j = 0; j < plots[0].length; j++){
                if(bucR[i][j] == bucC[i][j] && max < bucR[i][j]){
                    max = bucR[i][j];
                }
            }
        }

        return max;
    }
}
