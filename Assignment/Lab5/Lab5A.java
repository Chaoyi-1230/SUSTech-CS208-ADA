//  Achievement: 100%
//  Lexi Topo Sort

import java.util.*;
import java.io.*;

public class Lab5A {
    public static void main(String[] args) {
        int peopleNum = sk.nextInt();
        int houseNum = sk.nextInt();
        int capacity = sk.nextInt();
        int time = sk.nextInt();
        int[] peoplePosi = new int[peopleNum];
        int[] housePosi = new int[houseNum];
        int[] houseVaca = new int[houseNum];

        for (int i = 0; i < peopleNum; i++) {
            peoplePosi[i] = sk.nextInt();
        }
        for (int i = 0; i < houseNum; i++) {
            housePosi[i] = sk.nextInt();
        }

        Arrays.sort(peoplePosi);
        Arrays.sort(housePosi);
        Arrays.fill(houseVaca, capacity);

        int peoplePnt = 0;
        int housePnt = 0;
        int cnt = 0;

        while (peoplePnt < peopleNum && housePnt < houseNum) {
            if (houseVaca[housePnt] <= 0) {
                housePnt++;
                continue;
            }
            if (absDiff(peoplePosi[peoplePnt], housePosi[housePnt]) <= time) {
                cnt++;
                peoplePnt++;
                houseVaca[housePnt]--;
            } else {
                if (peoplePosi[peoplePnt] < housePosi[housePnt]) {
                    peoplePnt++;
                } else {
                    housePnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static int absDiff(int a, int b) {
        return a >= b ? a-b : b-a;
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