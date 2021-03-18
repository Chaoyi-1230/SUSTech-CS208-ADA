import java.util.*;
import java.io.*;

public class Lab3A {
    public static void main(String[] args) {
        int t = sk.nextInt();
        for (; t > 0; t--) {
            int[] capacity = new int[3];
            for (int i = 0; i <= 2; i++) {
                capacity[i] = sk.nextInt();
            }
            if (capacity[0] % 2 == 1) {
                System.out.println("impossible");
                continue;
            }
            Arrays.sort(capacity);
            int opr = -1;
            Queue<Circ> circs = new LinkedList<Circ>();
            boolean[][][] traversed = new boolean[capacity[2]+1][capacity[1]+1][capacity[0]+1];
            circs.add(new Circ(capacity[2],0,0,0));
            traversed[capacity[2]][0][0] = true;
            while (!circs.isEmpty()) {
                Circ current = circs.poll();

                // Below are 6 possible operations under each circumstance.
                // ci -> cj means that pour as much water as possible from ci to cj.
                // c0 is the smallest, c2 is the biggest.
                if (current.middle==current.large && current.small==0) {
                    opr = current.depth;
                    break;
                }

                // c0 -> c1
                if (current.middle < capacity[1] && current.small > 0) {
                    if (current.middle+current.small >= capacity[1]) {
                        if (!traversed[current.large][capacity[1]][capacity[0]-current.large]) {
                            traversed[current.large][capacity[1]][capacity[0]-current.large] = true;
                            circs.add(new Circ(current.large, capacity[1], capacity[0]-current.large, current.depth+1));
                        }
                    } else {
                        if (!traversed[current.large][current.small+current.middle][0]) {
                            traversed[current.large][current.small+current.middle][0] = true;
                            circs.add(new Circ(current.large, current.small+current.middle, 0, current.depth+1));
                        }
                    }
                }

                // c0 -> c2
                if (current.small > 0) {
                    if (!traversed[current.large+current.small][current.middle][0]) {
                        traversed[current.large+current.small][current.middle][0] = true;
                        circs.add(new Circ(current.large+current.small, current.middle, 0, current.depth+1));
                    }
                }

                // c1 -> c0
                if (current.small < capacity[0] && current.middle > 0) {
                    if (current.small+current.middle >= capacity[0]) {
                        if (!traversed[current.large][capacity[1]-current.large][capacity[0]]) {
                            traversed[current.large][capacity[1]-current.large][capacity[0]] = true;
                            circs.add(new Circ(current.large, capacity[1]-current.large, capacity[0], current.depth+1));
                        }
                    } else {
                        if (!traversed[current.large][0][current.middle+current.small]) {
                            traversed[current.large][0][current.middle+current.small] = true;
                            circs.add(new Circ(current.large, 0, current.middle+current.small, current.depth+1));
                        }
                    }
                }

                // c1 -> c2
                if (current.middle > 0) {
                    if (!traversed[current.large+current.middle][0][current.small]) {
                        traversed[current.large+current.middle][0][current.small] = true;
                        circs.add(new Circ(current.large+current.middle, 0, current.small, current.depth+1));
                    }
                }

                // c2 -> c0
                if (current.small < capacity[0] && current.large > 0) {
                    if (!traversed[capacity[1]-current.middle][current.middle][capacity[0]]) {
                        traversed[capacity[1]-current.middle][current.middle][capacity[0]] = true;
                        circs.add(new Circ(capacity[1]-current.middle, current.middle, capacity[0], current.depth+1));
                    }
                }

                // c2 -> c1
                if (current.middle < capacity[1] && current.large > 0) {
                    if (!traversed[capacity[0]-current.small][capacity[1]][current.small]) {
                        traversed[capacity[0]-current.small][capacity[1]][current.small] = true;
                        circs.add(new Circ(capacity[0]-current.small, capacity[1], current.small, current.depth+1));
                    }
                }

            }
            System.out.println(opr <= 0 ? "impossible" : opr);
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

    static class Circ {
        int large;
        int middle;
        int small;
        int depth;
    
        public Circ(int l, int m, int s, int d) {
            this.large = l;
            this.middle = m;
            this.small = s;
            this.depth = d;
        }
    }
}