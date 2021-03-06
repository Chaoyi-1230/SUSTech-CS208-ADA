/* Achievement: 60%
 */

import java.util.Scanner;

public class Lab0A{
    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        final int MOD = 998244353;
        byte t = sk.nextByte();
        for(; t > 0; t--) {
            int step = sk.nextInt();
            int stride = sk.nextInt();
            long[] way = new long[step+1];

            for (int i = 0; i <= step; i++) {
                if (i == 0) {
                    way[i] = 0;
                }else if (i > 0 && i <= stride) {
                    way[i] = 1;
                    for (int j = 1; j < i; j++) {
                        way[i] += (way[j] % MOD);
                    }
                }else{
                    way[i] = 0;
                    for (int j = 1; j <= stride; j++) {
                        way[i] += (way[i-j] % MOD);
                    }
                }
            }
            System.out.println(way[step] % MOD);
        }
    }

}
