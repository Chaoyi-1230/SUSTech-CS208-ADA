//  Achievement: 90% and WA

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
            int max = diff[num-1];
            if (num == 1) {
                System.out.println(max);
                continue;
            } else if (num == 2) {
                System.out.println(max % diff[0] == 0 ? max : diff[0] + max);
                continue;
            }
            
            int s2 = 0;
            for (int i = num-2; i >= 0; i--) {
                if (max % diff[i] != 0) {
                    s2 = diff[i] + max;
                    break;
                }
            }

            int s3 = 0;
            for (int i = num-1; diff[i] >= max / 3; i--) {
                int big = diff[i];
                int middle = 0;
                int middleIndex = -1;
                for (int j = i-1; j >= 0; j--) {
                    if (big % diff[j] != 0) {
                        middle = diff[j];
                        middleIndex = j;
                        break;
                    }
                }
                if (middle == 0 || middleIndex <= 0) {
                    continue;
                }
                int small = 0;
                int smallIndex = -1;
                for (int j = middleIndex-1; j >= 0; j--) {
                    if (middle % diff[j] != 0 && big % diff[j] != 0) {
                        small = diff[j];
                        smallIndex = j;
                        break;
                    }
                }
                if (small == 0 || smallIndex < 0) {
                    continue;
                }
                if (big+middle+small > s3) {
                    s3 = big+middle+small;
                }
            }

            int[] s = {max,s2,s3};
            Arrays.sort(s);
            System.out.println(s[2]);
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
