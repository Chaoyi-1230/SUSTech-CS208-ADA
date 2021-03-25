//  Achievement: 100%

import java.util.*;
import java.io.*;

public class Lab3B {
    static short[][] table = new short[26][26];
    static boolean[] appeared = new boolean[26];
    static short beauty = 0;
    public static void main(String[] args) {
        int t = sk.nextInt();
        for (; t>0; t--) {
            String word = sk.next();
            if (word.length() == 1) {
                System.out.println(0);
                continue;
            }
            int length = word.length();
            for (int i = 1; i < length; i++) {
                if (charVower(word.charAt(i-1)) || charVower(word.charAt(i))) {
                    continue;
                } else {
                    table[charToInt(word.charAt(i-1))][charToInt(word.charAt(i))]++;
                    table[charToInt(word.charAt(i))][charToInt(word.charAt(i-1))]++;
                    appeared[charToInt(word.charAt(i-1))] = true;
                    appeared[charToInt(word.charAt(i))] = true;
                }
            }
            ArrayList charList = new ArrayList<>();
            int cnt = 67108864;   // 26 digits of "1" in Decimal;
            char ch = 'a';
            while (cnt > 0) {
                
                if (cnt % 2 == 1) {
                    charList.add(ch);
                }
                ch += 1;
                cnt >>= 1;
            }

        }
    }

    private static int charToInt(char ch) {
        return (ch - 'a');
    }

    private static boolean charVower(char ch) {
        return (ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u');
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