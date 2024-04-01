import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

public class TestBF {

    public static int iterationCount = 0;
    public static long start;
    public static long end;
    public static long time;

    public static void main(String[] args) {

        int one[] = {1};
        int four[] = new int[4];
        int nine[] = new int[9];
        int sixteen[] = new int[16];
        int twfive[] = new int[25];
        int thsix[] = new int[36];
        int fonine[] = new int[49];
        int sifour[] = new int[64];
        int eione[] = new int[81];
        int onhund[] = new int[100];
        int ontwone[] = new int[121];
        int onfofour[] = new int[144];
        int onsixnine[] = new int[169];
        int onnisix[] = new int[196];
        int twtwfi[] = new int[225];
        int twfisix[] = new int[256];
        int tweinine[] = new int[289];
        int thtwfour[] = new int[324];
        int thsione[] = new int[361];
        int fourhund[] = new int[400];
        int fofoone[] = new int[441];
        int foeifour[] = new int[484];
        int fitwnine[] = new int[529];
        int fisesix[] = new int[576];
        int sitwfive[] = new int[625];
        int sisesix[] = new int[676];
        int setwnine[] = new int[729];
        int seeifour[] = new int[784];
        int eifoone[] = new int[841];
        int ninhund[] = new int[900];
        int nisione[] = new int[961];
        int max[] = new int[1024];

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
        experiment(twfisix);
        experiment(tweinine);
        experiment(thtwfour);
        experiment(thsione);
        experiment(fourhund);
        experiment(fofoone);
        experiment(foeifour);
        experiment(fitwnine);
        experiment(fisesix);
        experiment(sitwfive);
        experiment(sisesix);
        experiment(setwnine);
        experiment(seeifour);
        experiment(eifoone);
        experiment(ninhund);
        experiment(nisione);
        experiment(max);
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
        System.out.println(test.length + ": \t| Output: " + nearlyIdentical(test) + " \t| Count: " + iterationCount + " \t| Time: " + time);
    }

    public static int nearlyIdentical(int[] a){
        start = System.nanoTime();
        int longest = 0; // current longest nearly identical subsequence
        int n = a.length;
        for(int i = 0; i < n - 1; i++){
            int count = 0; // Number of values = 1 more than current value
            boolean nextPresent = false; // T/F: a[j] + 1 is present
            for(int j = 0; j < n - 1; j++){
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
}
