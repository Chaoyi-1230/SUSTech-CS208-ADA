//  Achievement: 0%
//  Weight Center of a Tree

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int num = sk.nextInt();
        int[] w = new int[num+1];
        for (int i = 1; i <= num; i++) {
            w[i] = sk.nextInt();
        }
        ArrayList nodes = new ArrayList<Node>();
        nodes.add(null);
        for (int i = 1; i <= num; i++) {
            Node tmp = new Node(i, sk.nextInt());
            nodes.add(tmp);
        }
        for (int i = 1; i <= num-1; i++) {
            
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

public class Node {
    int id;
    int weight;
    ArrayList children;

    Node(int i, int w) {
        this.id = i;
        this.weight = w;
    }
}