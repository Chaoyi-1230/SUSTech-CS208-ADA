//  Achievement: 100%
//  A math problem.

import java.util.*;
import java.io.*;

public class Lab6A {
    public static void main(String[] args) {
        int n = sk.nextInt();
        if (n==1) {
            System.out.println(sk.next());
            return;
        }
        int[] num = new int[n];
        int positive = 0;
        int zero = 0;
        int leastAbs = Integer.MAX_VALUE;
        long sumAbs = 0;
        for (int i = 0; i < n; i++) {
            num[i] = sk.nextInt();
            if (num[i]>0) {
                positive++;
            } else if (num[i]==0) {
                zero++;
            }
            if (abs(num[i]) < leastAbs) {
                leastAbs = abs(num[i]);
            }
            sumAbs+=abs(num[i]);
        }
        if (positive>0 && n-positive-zero>0) {
            System.out.println(sumAbs);
        } else {
            System.out.println(sumAbs-leastAbs-leastAbs);
        }
    }

    private static int abs(int a) {
        return a >= 0 ? a : 0-a;
    }

    private static QuickReader sk = new QuickReader(System.in);

    private static class QuickReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public QuickReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}