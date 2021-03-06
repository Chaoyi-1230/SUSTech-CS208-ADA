// Achievement: 100%

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        final int MOD = 998244353;
        byte t = sk.nextByte();
        for(; t > 0; t--) {
            int step = sk.nextInt();
            int stride = sk.nextInt();
            assert step >= stride;
            assert stride >= 1;

            if (stride == 1) {
                System.out.println(1);
                continue;
            }

            long[] way = new long[step+1];
            way[0] = 1;
            way[1] = 1;
            for (int i = 2; i <= stride; i++) {
                /*
                for (int j = 0; j < i; j++) {
                    way[i] += way[j];
                    way[i] %= MOD;
                }
                */
                way[i] = (way[i-1] * 2) % MOD;
            }

            if (step == stride) {
                System.out.println(way[step]);
                continue;
            }

            for (int i = stride+1; i <= step; i++) {
                // way[i] = way[i-1]*2 - way[i-stride-1];
                way[i] = ((2 * (way[i-1] % MOD) ) - way[i-stride-1] % MOD + MOD) % MOD;
            }
            System.out.println(way[step]);
        }
    }

    private static void arrPrint(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}