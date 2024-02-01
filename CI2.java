public class CI2 {

    private static int count;

    public static void main(String[] args){
        count = 0;
        System.out.println("Test 1: n = 0: count = " + problemFour(0));

        count = 0;
        System.out.println("Test 2: n = 1: count = " + problemFour(1));

        count = 0;
        System.out.println("Test 3: n = 2: count = " + problemFour(2));

        count = 0;
        System.out.println("Test 4: n = 3: count = " + problemFour(3));

        count = 0;
        System.out.println("Test 5: n = 4: count = " + problemFour(4));

        count = 0;
        System.out.println("Test 6: n = 5: count = " + problemFour(5));

        count = 0;
        System.out.println("Test 7: n = 6: count = " + problemFour(6));

        count = 0;
        System.out.println("Test 8: n = 9: count = " + problemFour(9));

        count = 0;
        System.out.println("Test 9: n = 10: count = " + problemFour(10));
    }

    public static int problemFour(int n){
        if(n == 0){
            return 0;
        }
        else{
            int x = 0;
            for(int j = 1; j <= n; j++){
                x = problemFour(n - 1) - 5*j;
                count++;
            }
            return count;
        }
    }
}
