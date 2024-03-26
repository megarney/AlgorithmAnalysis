import java.util.HashSet;
import java.util.Arrays;

public class HW7P2 {
    public static void main(String[] args){
        int[] set1 = {0,3,7,2,5,8,4,6,0,1};
        int[] result1 = subcollection(set1);
        System.out.print("Test 1: {");
        for(int i = 0; i < result1.length-2; i++){
            System.out.print(result1[i] + ",");
        }
        System.out.print(result1[result1.length-2] + "} Length: " + result1[result1.length-1]);
    }
}

public static int[] subcollection(int[] set){
    Arrays.sort(set);

    int length = 1;
    int currLength = 1;
    int index = 0;
    for(int i = 0; i < set.length - 1; i++){
        if(set[i] == set[i+1]+1){
            currLength++;
            if(length >= currLength){
                index = i;
                length = currLength;
            }
        }
        else{
            length = 1;
        }
    }

    int[] result = new int[length+1];
    result[length] = length;
    for(int i = 0; i < result.length-1; i++){
        result[i] = set[index];
        index++;
    }

    return result;
}