// Achievement: 100%

import java.util.Scanner;

public class Main1{
    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        final int MOD = 998244353;
        byte t = sk.nextByte();
        for(; t > 0; t--) {
            int step = sk.nextInt();
            int stride = sk.nextInt();
            assert step >= stride;
            assert stride >= 1;
            
            if (step == 1) {
                System.out.println(1);
                continue;
            }
            long[][] initial = new long[1][stride];

            for (int i = 0; i < stride; i++) {
                initial[0][i] = 1;
            }

            for (int i = stride-2; i > -1; i--) {
                for (int j = stride-1; j > i; j--) {
                    initial[0][i] += initial[0][j];
                }
                initial[0][i] %= MOD;
            }

            if (step == stride) {
                System.out.println(initial[0][0]);
                continue;
            }
            long[][] mat = matFibonacci(stride);
            long[][] res = matMul(initial, matPow(mat, step-stride, MOD), MOD);

            System.out.println(res[0][0]);
        }
    }
    private static long[][] matFibonacci(int d) {
        long[][] res = new long[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                res[i][j] = (j == 0 || j == i+1) ? 1 : 0; 
            }
        }
        return res;
    }
    
    private static long[][] matPow(long[][] mat, int pow, int mod) {
        int row = mat.length;
        int col = mat[0].length;
        assert row == col;
        assert pow > 0;
        long[][] res = new long[row][col];
        for (int i = 0; i < row; i++) {
            res[i][i] = 1;
        }
        while (pow != 0) {
            if ((pow & 1) == 1) {
                res = matMul(res, mat, mod);
            }
            mat = matMul(mat, mat, mod);
            pow >>= 1;
        }
        return res;
    }
    
    private static long[][] matMul(long[][] mat1, long[][] mat2, int mod) {
        int row1 = mat1.length;
        int row2 = mat2.length;
        int col1 = mat1[0].length;
        int col2 = mat2[0].length;
        assert col1 == row2;
        long[][] res = new long[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    res[i][j] += (mat1[i][k] * mat2[k][j]) % mod;
                    res[i][j] %= mod;
                }
            }
        }
        return res;
    }

    private static void matPrint(long[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}