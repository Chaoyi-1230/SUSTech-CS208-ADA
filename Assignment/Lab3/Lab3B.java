//  Achievement: 90% and TLE

import java.util.Scanner;


public class Lab1A {
    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        int n = sk.nextInt();
        String[] men = new String[n];
        String[] women = new String[n];
        String[][] menPref = new String[n][n];
        String[][] womenPref = new String[n][n];
        String[] menPartner = new String[n];
        String[] womenPartner = new String[n];
        int engaged = 0;

        String tmp = sk.nextLine();
        men = sk.nextLine().split(" ");
        women = sk.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            menPref[i] = sk.nextLine().split(" ");
        }
        for (int i = 0; i < n; i++) {
            womenPref[i] = sk.nextLine().split(" ");
        }
        
        while (engaged < n) {
            int singleManIndex = 0;
            while (singleManIndex < n) {
                if (menPartner[singleManIndex] == null) {
                    break;
                }
                singleManIndex++;
            }
            for (int i = 0; i < n && menPartner[singleManIndex] == null; i++) {
                int w = findWomanByName(menPref[singleManIndex][i], women, n);
                if (womenPartner[w] == null) {
                    womenPartner[w] = men[singleManIndex];
                    menPartner[singleManIndex] = women[w];
                    engaged++;
                } else if (tradeUp(womenPartner[w], men[singleManIndex], w, n, womenPref)) {
                    menPartner[findManByName(womenPartner[w], men, n)] = null;
                    womenPartner[w] = men[singleManIndex];
                    menPartner[singleManIndex] = women[w];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(men[i]);
            System.out.print(" ");
            System.out.println(menPartner[i]);
        }

    }

    private static int findManByName(String name, String[] men, int n) {
        for (int i = 0; i < n; i++) {
            if (men[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
    private static int findWomanByName(String name, String[] women, int n) {
        for (int i = 0; i < n; i++) {
            if (women[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
    private static boolean tradeUp(String current, String novel, int index, int n, String[][] womenPref) {
        for (int i = 0; i < n; i++) {
            if (womenPref[index][i].equals(novel)) {
                return true;
            } else if (womenPref[index][i].equals(current)) {
                return false;
            }
        }
        return false;
    }
}
