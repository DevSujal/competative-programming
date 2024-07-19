import java.util.Arrays;
import java.util.Scanner;

public class InverseArray {

    public static void inverseArray(int arr[], int idx, int ans[]){

        if(idx >= arr.length){
            return;
        }

        ans[arr[idx]] = idx;
        inverseArray(arr, idx+1, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans[] = new int[n];
        inverseArray(arr, 0, ans);

        System.out.println(Arrays.toString(ans));
    }
}
