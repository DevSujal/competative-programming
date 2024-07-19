import java.util.ArrayList;
import java.util.Scanner;

public class FirstOccurence {
    
    public static int getFirstOccurence(ArrayList<Integer> arr, int n, int idx){
        if(idx >= arr.size()){
            return -1;
        }

        int val = getFirstOccurence(arr, n, idx+1);

        if(arr.get(idx) == n) return idx;
        else return val;
            
    }
    public static int getLastOccurence(ArrayList<Integer> arr, int n, int idx){
        if(idx >= arr.size()){
            return -1;
        }

        int val = getLastOccurence(arr, n, idx+1);

        if(val == -1 && arr.get(idx) == n) return idx;
        else return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>(n);

        while (n-- > 0) {
            arr.add(sc.nextInt());
        }
        int num = sc.nextInt();
        System.out.println(getFirstOccurence(arr, num, 0));
        System.out.println(getLastOccurence(arr, num, 0));
    }
}
