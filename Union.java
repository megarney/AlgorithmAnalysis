import java.util.Arrays;

public class Union {
    public static void main(String[] args){
        int[] A1 = {1,2,3,4,5};
        int[] B1 = {1,3,5,7,9};
        System.out.print("Test 1 | Expected Output: 1 2 3 4 5 7 9 | Output: ");
        int[] test1 = union(A1, B1);
        for (int num : test1){
            System.out.print(String.valueOf(num) + " ");
        }

        System.out.println("\n");

        int[] A2 = {1,1,2,3,3,3,3,4,5};
        int[] B2 = {6,6,6,6,6,6,6};
        System.out.print("Test 2 | Expected Output: 1 2 3 4 5 6 | Output: ");
        int[] test2 = union(A2, B2);
        for (int num : test2){
            System.out.print(String.valueOf(num) + " ");
        }
    }

    public static int[] union(int[] A, int[] B){
        int[] C = new int[A.length + B.length];
        for(int i = 0; i < A.length; i++){
            C[i] = A[i];
        }
        for(int i = A.length; i < C.length; i++){
            C[i] = B[i - A.length];
        }
        Arrays.sort(C);
        int[] D = new int[C.length];
        D[0] = C[0];
        int currindex = 1;
        for(int i = 1; i < C.length; i++){
            if(C[i-1] != C[i]){
                D[currindex] = C[i];
                currindex++;
            }
        }
        int[] E = new int[currindex];
        for(int i = 0; i < E.length; i++){
            E[i] = D[i];
        }
        return E;
    }
}
