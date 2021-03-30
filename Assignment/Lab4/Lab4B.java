//  Achievement: 0%
//  Weight Center of a Tree

import java.util.*;
import java.io.*;

public class Lab4A {
    public static void main(String[] args) {
        int num = sk.nextInt();
        int[] w = new int[num+1];
        for (int i = 1; i <= num; i++) {
            w[i] = sk.nextInt();
        }
        LinkedList[] graph = new LinkedList[num+1];
        for (int i = 1; i <= num; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < num; i++) {
            int tmp1 = sk.nextInt();
            int tmp2 = sk.nextInt();
            graph[tmp1].add(tmp2);
            graph[tmp2].add(tmp1);
        }
        
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