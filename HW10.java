public class HW10 {

    //rows
    public static int bob = 0;
    public static int jim = 1;
    public static int tom = 2;
    //columns
    public static int ann = 0;
    public static int lea = 1;
    public static int sue = 2;
    
    public static void main(String[] args) {

        //men ranking women
        int[][] men = new int[4][4];

        men[bob][ann] = 2;
        men[bob][lea] = 1;
        men[bob][sue] = 3;

        men[jim][ann] = 3;
        men[jim][lea] = 1;
        men[jim][sue] = 2;

        men[tom][ann] = 3;
        men[tom][lea] = 2;
        men[tom][sue] = 1;

        //women ranking men
        int[][] women = new int[4][4];

        women[ann][bob] = 3;
        women[ann][jim] = 1;
        women[ann][tom] = 2;

        women[lea][bob] = 2;
        women[lea][jim] = 3;
        women[lea][tom] = 1;

        women[sue][bob] = 3;
        women[sue][jim] = 1;
        women[sue][tom] = 2;

        //pairings
        int[][] unstable = new int[3][2];

        unstable[0][0] = bob;
        unstable[0][1] = ann;

        unstable[1][0] = jim;
        unstable[1][1] = lea;

        unstable[2][0] = tom;
        unstable[2][1] = sue;

        int[][] stable = new int[3][2];
        stable[0][0] = bob;
        stable[0][1] = ann;

        stable[1][0] = jim;
        stable[1][1] = sue;

        stable[2][0] = tom;
        stable[2][1] = lea;

        System.out.println("Test 1 | Expected: false | Output: " + check(unstable, men, women));
        System.out.println("Test 2 | Expected: true | Output: " + check(stable, men, women));
    }

    public static boolean check(int[][] pairs, int[][] men, int[][] women){
        for(int i = 0; i < pairs.length; i++){
            for(int j = 0; j < pairs[0].length; i++){
                //men[pairs[i][0]][pairs[i][1]]
                //women[pairs[j][0]][pairs[j][1]]
                
            }
        }
        return true;
    }

}
