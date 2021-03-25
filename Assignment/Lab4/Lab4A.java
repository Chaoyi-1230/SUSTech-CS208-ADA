//  Achievement: 60%

import java.util.*;
import java.io.*;

public class Lab4A {
    public static void main(String[] args) {
        boolean possible = true;
        int job = sk.nextInt();
        int dep = sk.nextInt();
        LinkedList<Integer> priList = new LinkedList();
        LinkedList<Integer> output = new LinkedList();
        boolean[] traversed = new boolean[job+1];
        for (int i = 1; i <= job; i++) {
            priList.add(i);
        }
        LinkedList<Integer>[] graph = new LinkedList[job+1];
        for (int i = 1; i <= job; i++) {
            graph[i] = new LinkedList();
        }
        
        for (int i = 0; i < dep; i++) {
            int from = sk.nextInt();
            int to = sk.nextInt();
            graph[to].add(from);
        }
        
        int untraversed = job;
        while (untraversed > 0) {
            int least = 0;
            for (Iterator iter = priList.iterator(); iter.hasNext();) {
                int i = Integer.parseInt(iter.next().toString());
                //int i = iter.next().toString();
                if (graph[i].isEmpty() && !traversed[i]) {
                    least = i;
                    traversed[i] = true;
                    untraversed--;
                    output.add(i);
                    break;
                }
            }

            if (least <= 0) {
                possible = false;
                break;
            }

            for (int i = 1; i <= job; i++) {
                int index = 0;
                for (Iterator iter = graph[i].iterator(); iter.hasNext();) {
                    int j = Integer.parseInt(iter.next().toString());
                    //int j = iter.next();
                    if (j == least) {
                        graph[i].remove(index);
                        break;
                    } else {
                        index++;
                    }
                }
            }
        }

        if (possible) {
            for (int i : output) {
                System.out.print(i);
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