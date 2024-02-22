public class HW4P1 {
    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,6,7,8,9,10};

        int[] arr2 = {2,3,4,5};

        int[] arr3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        System.out.println("Test 1 || Expected number: 5 || Output: " + problemOne(arr1));
        System.out.println("Test 2 || Expected number: 1 || Output: " + problemOne(arr2));
        System.out.println("Test 3 || Expected number: 15 || Output: " + problemOne(arr3));
    }

    public static int problemOne(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }
        return arr.length + 1;
    }
}
