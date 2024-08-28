public class water {

    public static void main(String[] args) {
        int[] test1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Test 1 | Expected: 6 | Output: " + trap(test1));
         
        int[] test2 = {4,2,0,3,2,5};
        System.out.println("Test 2 | Expected: 9 | Output: " + trap(test2));

        int[] test3 = {100, 0, 0, 200};
        System.out.println("Test 3 | Expected: 200 | Output: " + trap(test3));

        int[] test4 = {0, 0, 0, 0, 0, 0};
        System.out.println("Test 4 | Expected: 0 | Output: " + trap(test4));

        int[] test5 = {400, 100, 300, 401, 0};
        System.out.println("Test 5 | Expected: 400 | Output: " + trap(test5));

        int[] test6 = {0, 0, 0, 0, 0, 100};
        System.out.println("Test 6 | Expected: 0 | Output: " + trap(test6));

        int[] test7 = {100, 0, 0, 0, 0};
        System.out.println("Test 7 | Expected: 0 | Output: " + trap(test7));

        int[] test8 = {0, 0, 0, 100, 0, 0, 0};
        System.out.println("Test 8 | Expected: 0 | Output: " + trap(test8));
    }

    public static int trap(int[] height) {

        //if there is no available space for water
        if(height.length <= 2){
            return 0;
        }

        //find max height
        int max = 0;
        for(int i = 0; i < height.length; i++){
            if(max < height[i]){
                max = height[i];
            }
        }

        //find the leftmost max
        int index = 0;
        int leftIndex = -1;
        while(leftIndex == -1){
            if(height[index] == max){
                leftIndex = index;
            }
            index++;
        }

        //find the rightmost max
        index = height.length-1;
        int rightIndex = -1;
        while(rightIndex == -1){
            if(height[index] == max){
                rightIndex = index;
            }
            index--;
        }

        //if the max is only at one index (cannot hold water at that level), decrease and continue
        if(leftIndex == rightIndex){
            height[rightIndex]--;
            return trap(height);
        }

        //calculate the total units possible within the space
        int total = 0;
        for(int i = leftIndex+1; i < rightIndex; i++){
            total += max - height[i];
        }

        //create new array with all of the spaces that have not already been calculated
        int[] c = new int[(height.length)-(rightIndex-leftIndex)];
        for(int i = 0; i < leftIndex; i++){
            c[i] = height[i];
        }
        int j = c.length-1;
        for(int i = height.length-1; i > rightIndex; i--){
            c[j] = height[i];
            j--;
        }
        c[leftIndex] = height[leftIndex]--;
        return total + trap(c);
    }
}
