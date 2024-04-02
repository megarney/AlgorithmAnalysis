import java.util.HashMap;

public class TestBFvST {

    public static int iterationCount = 0;
    public static long start;
    public static long end;
    public static long time;

    public static void main(String[] args) {

        int one[] = new int[1000];
        int four[] = new int[2000];
        int nine[] = new int[3000];
        int sixteen[] = new int[4000];
        int twfive[] = new int[5000];
        int thsix[] = new int[6000];
        int fonine[] = new int[7000];
        int sifour[] = new int[8000];
        int eione[] = new int[9000];
        int onhund[] = new int[10000];
        int ontwone[] = new int[11000];
        int onfofour[] = new int[12000];
        int onsixnine[] = new int[13000];
        int onnisix[] = new int[14000];
        int twtwfi[] = new int[15000];
         
        experiment(one);
        experiment(four);
        experiment(nine);
        experiment(sixteen);
        experiment(twfive);
        experiment(thsix);
        experiment(fonine);
        experiment(sifour);
        experiment(eione);
        experiment(onhund);
        experiment(ontwone);
        experiment(onfofour);
        experiment(onsixnine);
        experiment(onnisix);
        experiment(twtwfi);
    }

    public static void experiment(int[] test){
        for(int i = 0; i < test.length; i++){
            int rand;
            if(test.length > i){
                rand = (int)(Math.random() * (9)) + 1;
                test[i] = rand;
            }
        }

        iterationCount = 0;
        System.out.print("Input Size: " + test.length + " \t| Output: " + nearlyIdenticalBF(test) + "\t| BF Count: " + iterationCount + "\t| BF Time: " + time);
        iterationCount = 0;
        nearlyIdenticalH(test);
        System.out.print("\t| H Count: " + iterationCount + "\t| H Time: " + time + "\n");
    }

    public static int nearlyIdenticalBF(int[] a){
        start = System.nanoTime();
        int longest = 0; // current longest nearly identical subsequence
        int n = a.length;
        for(int i = 0; i < n; i++){
            int count = 0; // Number of values = 1 more than current value
            boolean nextPresent = false; // T/F: a[j] + 1 is present
            for(int j = 0; j < n; j++){
                iterationCount++;
                if(a[j] == a[i]){
                    count = count + 1;
                }
                else if(a[j] + 1 == a[i]){
                    count = count + 1;
                    nextPresent = true;
                }
            }

            if(nextPresent){
                longest = Math.max(count, longest);
            }
        }
        end = System.nanoTime();
        time = end-start;
        return longest;
    }

    private static int nearlyIdenticalH(int[] inputArray) {
        start = System.nanoTime();
        HashMap<Integer, Integer> H = new HashMap<>();

		for (int i = 0; i < inputArray.length; i++) {
			H.put(inputArray[i], 0);
            iterationCount++;
		}

		for (int i = 0; i < inputArray.length; i++) {
			H.put(inputArray[i], H.get(inputArray[i]) + 1);
            iterationCount++;
		}

		int longest = 0;

		for (int key : H.keySet()) {
            iterationCount++;
			if (H.containsKey(key + 1)) {
				longest = Math.max(longest, H.get(key) + H.get(key + 1));
			}
		}
        end = System.nanoTime();
        time = end-start;
		return longest;
	}
}
