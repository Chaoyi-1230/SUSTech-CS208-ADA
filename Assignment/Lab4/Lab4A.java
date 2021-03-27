//  Achievement: 100%
//  Lexi Topo Sort

import java.util.*;
import java.io.*;

public class Lab4A {
    public static void main(String[] args) {
        int job = sk.nextInt();
        int dep = sk.nextInt();
        PriorityQueue priQueue = new PriorityQueue<Integer>();  // A heap helps find the smallest untraversed node.
        LinkedList output = new LinkedList<Integer>();  // A linkedlist with nodes in topological order.
        int[] inDegree = new int[job+1];
        LinkedList[] outGraph = new LinkedList[job+1];
        for (int i = 1; i <= job; i++) {
            outGraph[i] = new LinkedList<Integer>();
        }
        
        for (int i = 0; i < dep; i++) {
            int from = sk.nextInt();
            int to = sk.nextInt();
            outGraph[from].add(to);
            inDegree[to]++;
        }

        for (int i = 1; i <= job; i++) {
            if (inDegree[i] == 0) {
                priQueue.add(i);
            }
        }

        while (!priQueue.isEmpty()) {
            int least = (Integer)priQueue.poll();
            output.add(least);

            for (Object n : outGraph[least]) {
                inDegree[(Integer)n]--;
                if (inDegree[(Integer)n] == 0) {
                    priQueue.add((Integer)n);
                }
            }
            outGraph[least] = null;   
        }

        if (output.size()==job) {
            for (Iterator iter = output.iterator(); iter.hasNext();) {
                System.out.print(iter.next());
                System.out.print(" ");
            }
            System.out.println();
        } else {
            System.out.println("impossible");
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