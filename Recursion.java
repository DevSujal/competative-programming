import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {

    public static void printArray(ArrayList<Integer> arr, int idx) {

        if (idx >= arr.size())
            return;

        printArray(arr, idx + 1);
        System.out.println(arr.get(idx));
    }

    public static long findAToThePowerB(int a, int b) {
        if (b <= 0)
            return 1;

        return findAToThePowerB(a, b - 1) * a;
    }

    public static int findNoOfWays(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        return findNoOfWays(matrix, row - 1, col) + findNoOfWays(matrix, row, col - 1);
    }

    public static int josPr(int n, int k) {

        // josephus problem
        if (n == 1)
            return 0;

        return ((josPr(n - 1, k) + k) % n);
    }

    public static boolean isPalindromString(String str, int idx, int backIdx) {
        System.out.println(idx + " " + backIdx);
        if (idx >= str.length() / 2) {
            return true;
        }

        boolean isPalindrom = isPalindromString(str, idx + 1, backIdx - 1);

        if (isPalindrom && str.charAt(backIdx) == str.charAt(idx)) {
            return isPalindrom;
        } else {
            return false;
        }
    }

    public static void printSubSequenceOfAString(String str, String word) {
        if(str == "") {
            System.out.println(word);
            return;
        }

        char ch = str.charAt(0);

        printSubSequenceOfAString(str.substring(1), word + ch); //inclusion
        printSubSequenceOfAString(str.substring(1), word); // exclusion
    }
    public static void pirntAllPerm(String str, String word) {

        if(str.length() == 0) {
            System.out.println(word);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            pirntAllPerm(newStr, word + ch);
        }
    }

    public static void towerOfHanoi(int n, String source, String helper, String destination) {

        if(n == 1) {
            System.out.println(n + " disk is moving from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println(n + " disk is moving from " + source + " to " + destination);
        towerOfHanoi(n-1, helper, source, destination);
    }



    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // while (n-- > 0) {
        // arr.add(sc.nextInt());
        // }
        // printArray(arr, 0);
        // sc.close();

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // matrix.add(new ArrayList<>());
        // matrix.add(new ArrayList<>());
        // matrix.add(new ArrayList<>());
        // matrix.get(0).add(1);
        // matrix.get(0).add(1);
        // matrix.get(1).add(1);
        // matrix.get(1).add(1);
        // matrix.get(1).add(1);
        // matrix.get(0).add(1);
        // matrix.get(2).add(1);
        // matrix.get(2).add(1);
        // matrix.get(2).add(1);

        // System.out.println((matrix.size() - 1) + " " + (matrix.get(0).size() - 1));
        // System.out.println(findNoOfWays(matrix, matrix.size(),
        // matrix.get(0).size()));
        // System.out.println(josPr(5, 3));

        // System.out.println(isPalindromString("1221", 0, 3));

        // printSubSequenceOfAString("abc", "");

        // pirntAllPerm("abc", "");
        // System.out.println("abcda".replace('a', '7'));
        towerOfHanoi(3, "source", "helper", "destination");
    }
}
