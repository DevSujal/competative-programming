import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {

    public static void printArray(ArrayList<Integer> arr, int idx) {

        if (idx >= arr.size())
            return;

            printArray(arr, idx + 1);
            System.out.println(arr.get(idx)); 
    }

    public static long findAToThePowerB(int a, int b){
        if(b <= 0) return 1;

        return findAToThePowerB(a, b-1) * a;
    }

    public static int findNoOfWays(ArrayList<ArrayList<Integer>> matrix, int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }

        return findNoOfWays(matrix, row-1, col) + findNoOfWays(matrix, row, col-1);
    }

    public static int josPr(int n, int k){

        // josephus problem
        if(n == 1) return 0;

        return ((josPr(n - 1, k) + k ) % n);
    }

    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // while (n-- > 0) {
        //     arr.add(sc.nextInt());
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
        // System.out.println(findNoOfWays(matrix, matrix.size(), matrix.get(0).size()));
        System.out.println(josPr(5, 3));
    }
}
