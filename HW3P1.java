public class HW3P1 {
    public static void main(String[] args){
        boolean[][] ex1 = new boolean[3][3];
        ex1[0][0] = true;
        ex1[1][1] = true;
        ex1[2][2] = true;
        ex1[0][1] = true;
        ex1[1][0] = true;
        ex1[0][2] = true;
        ex1[2][0] = true;
        ex1[1][2] = false;
        ex1[2][1] = false;

        boolean[][] ex2 = new boolean[4][4];
        ex2[0][0] = true;
        ex2[1][1] = true;
        ex2[2][2] = true;
        ex2[3][3] = true;
        ex2[0][1] = true;
        ex2[1][0] = true;
        ex2[0][2] = false;
        ex2[2][0] = false;
        ex2[0][3] = false;
        ex2[3][0] = false;
        ex2[1][2] = true;
        ex2[2][1] = true;
        ex2[1][3] = false;
        ex2[3][1] = false;
        ex2[2][3] = true;
        ex2[3][2] = true;

        boolean[][] ex3 = new boolean[5][5];
        ex3[0][0] = true;
        ex3[1][1] = true;
        ex3[2][2] = true;
        ex3[3][3] = true;
        ex3[4][4] = true;
        ex3[0][1] = false;
        ex3[1][0] = false;
        ex3[0][2] = true;
        ex3[2][0] = true;
        ex3[0][3] = false;
        ex3[3][0] = false;
        ex3[0][4] = false;
        ex3[4][0] = false;
        ex3[1][2] = true;
        ex3[2][1] = true;
        ex3[1][3] = false;
        ex3[3][1] = false;
        ex3[1][4] = false;
        ex3[4][1] = false;
        ex3[2][3] = true;
        ex3[3][2] = true;
        ex3[2][4] = true;
        ex3[4][2] = true;
        ex3[3][4] = false;
        ex3[4][3] = false;

        boolean[][] ex4 = new boolean[5][5];
        ex4[0][0] = true;
        ex4[1][1] = true;
        ex4[2][2] = true;
        ex4[3][3] = true;
        ex4[4][4] = true;
        ex4[0][1] = false;
        ex4[1][0] = false;
        ex4[0][2] = true;
        ex4[2][0] = true;
        ex4[0][3] = false;
        ex4[3][0] = false;
        ex4[0][4] = false;
        ex4[4][0] = false;
        ex4[1][2] = true;
        ex4[2][1] = true;
        ex4[1][3] = false;
        ex4[3][1] = false;
        ex4[1][4] = false;
        ex4[4][1] = false;
        ex4[2][3] = true;
        ex4[3][2] = true;
        ex4[2][4] = false;
        ex4[4][2] = false;
        ex4[3][4] = false;
        ex4[4][3] = false;


        System.out.println("Test 1 || Central Node Expected || Expected Index: 0 || Output: " + connections(ex1));
        System.out.println("Test 2 || No Central Node Expected || Expected Index: -1 || Output: " + connections(ex2));
        System.out.println("Test 3 || Central Node Expected || Expected Index: 2 || Output: " + connections(ex3));
        System.out.println("Test 4 || No Central Node Expected || Expected Index: -1 || Output: " + connections(ex4));
    }

    public static int connections(boolean[][] connected){
        boolean central;
        for(int i = 0; i < connected.length; i++){
            central = true;
            for(int j = 0; j < connected.length; j++){
                if(!connected[i][j]){
                    central = false;
                    break;
                }
            }
            if(central){
                return i;
            }
        }
        return -1;
    }
}
