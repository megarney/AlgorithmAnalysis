import java.util.Scanner;

public class Heap {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scan.nextInt();
        int[] nums = new int[n+1];
        scan.nextLine();

        System.out.print("Enter " + n + " integers: \n");
        String elements = scan.nextLine();
        String[] placeholder = elements.split(" ");
        nums[0] = 0;
        for(int i = 1; i < n+1; i++){
            nums[i] = Integer.parseInt(placeholder[i-1]);
        }

        System.out.println("\nThe max heap is given by:");
        int[] max = maxHeap(nums);
        for(int i = 1; i < max.length; i++){
            System.out.print(max[i] + " ");
        }

        System.out.println("\nThe min heap is given by:");
        int[] min = minHeap(max);
        for(int i = 1; i < min.length; i++){
            System.out.print(min[i] + " ");
        }
        scan.close();
    }

    public static int[] maxHeap(int[] H){
        int k;
        int v;
        boolean heap;
        int j;
        for(int i = H.length/2; i > 0; i--){
            k = i;
            v = H[k];
            heap = false;
            while(!heap && 2*k < H.length){
                j = 2*k;
                if(j<H.length-1){
                    if(H[j] < H[j+1]){
                        j++;
                    }
                }
                if(v >= H[j]){
                    heap = true;
                }
                else{
                    H[k] = H[j];
                    k = j;
                }
                H[k] = v;
            }
        }
        return H;
    }

    public static int[] minHeap(int[] H){
        int height = ((int)Math.ceil(Math.log(H.length + 1) / Math.log(2)) - 1) +1;
        int min;
        int minIndex;
        for(int c = 1; c <= height; c++){
            for(int i = H.length/2; i > 0; i--){
                if((2*i)+1 < H.length){
                    if(H[2*i] <= H[2*i+1]){
                        min = H[2*i];
                        minIndex = 2*i;
                    }
                    else{
                        min = H[2*i+1];
                        minIndex = 2*i+1;
                    }
                    if(H[i] > min){
                        H[minIndex] = H[i];
                        H[i] = min;
                    }
                }
                else if((2*i) < H.length){
                    if(H[i] > H[2*i]){
                        min = H[2*i];
                        H[2*i] = H[i];
                        H[i] = min;
                    }
                }
            }
        }
        return H;
    }
}
