//  Achievement: 100%
//  Lexi Topo Sort

import java.util.*;
import java.io.*;

public class Lab5B {
    public static void main(String[] args) {
        int n = sk.nextInt();
        Node[] arr = new Node[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new Node(i, sk.nextLong());
        }
        for(int i = 1; i < n; i++) {
            int upper = sk.nextInt();
            int lower = sk.nextInt();
            if (upper != 1 && arr[upper].parent == null) {
                int tmp = upper;
                upper = lower;
                lower = tmp;
            }
            arr[upper].children.add(arr[lower]);
            arr[lower].parent = arr[upper];
            arr[lower].cost = sk.nextLong();
        }

        int cnt = 1;
        long hp = arr[1].food;
        long wait = 0;
        Node current = arr[1];
        do {
            long profit = Long.MIN_VALUE;
            int profitPosi = -1;
            for(int i = 0; i < current.children.size(); i++) {
                Node pnt = current.children.get(i);
                if (pnt.traversed) {
                    continue;
                }
                long tmpProfit = pnt.food-pnt.cost;
                if (tmpProfit > profit) {
                    profit = tmpProfit;
                    profitPosi = i;
                }
            }

            if (profitPosi < 0) {
                if (hp < current.cost) {
                    wait += current.cost - hp;
                    hp = 0;
                } else {
                    hp -= current.cost;
                }
                current = current.parent;
            } else {
                Node pnt = current.children.get(profitPosi);
                if (hp < pnt.cost) {
                    wait += pnt.cost - hp;
                    hp = pnt.food;
                } else {
                    hp -= pnt.cost;
                    hp += pnt.food;
                }
                current = pnt;
                current.traversed = true;
                cnt += 1;
            }
        } while (current.index != 1 || cnt < n);

        System.out.println(wait);
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

class Node {
    int index;
    long cost;   // the HP needed when Dateri reach this node from previous node.
    long food;   // the HP contained in the food of this node.
    boolean traversed;
    Node parent;
    ArrayList<Node> children;

    Node(int i, long f) {
        this.index = i;
        this.food = f;
        this.children = new ArrayList<Node>();
    }
}