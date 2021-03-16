import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.Arrays;

public class Lab2A {
    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        int n = sk.nextInt();
        for (; n > 0; n--) {
            int num = sk.nextInt();
            int[] diff = new int[num];
            for (int i = 0; i < num; i++) {
                diff[i] = sk.nextInt();
            }
            diff = rmvDupSort(diff);
            num = diff.length;
            if (num == 1) {
                System.out.println(diff[0]);
                continue;
            } else if (num == 2) {
                System.out.println(diff[1] % diff[0] == 0 ? diff[1] : diff[0] + diff[1]);
                continue;
            }
            int s1 = diff[num-1];   // s1 is the max difficulty for one question.
            
            int s2 = diff[num-1];
            for (int i = num-2; i >= 0; i--) {
                if (s2 % diff[i] != 0) {
                    s2 += diff[i];
                    break;
                }
            }

            int s3 = diff[num-1];
            for (int i = num-2; i >= 0; i--) {
                if (s3 % diff[i] == 0) {
                    diff[i] = 0;
                }
            }
            Arrays.sort(diff);

            if (diff[num-3] == 0) {
                System.out.println(s2);
            } else {
                s3 += diff[num-2];
                for (int i = num-3; i >= 0 && diff[i] != 0; i--) {
                    if (diff[num-2] % diff[i] != 0) {
                        s3 += diff[i];
                        break;
                    } 
                }
                System.out.println(s3);
            }
        }
    }



    public static int[] rmvDupSort(int[] arr) {

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }
        Set<Integer> set = new TreeSet(hashSet);
        Integer[] integers = set.toArray(new Integer[]{});

        int[] result = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            result[i] = integers[i].intValue();
        }

        return result;
    }
}
