import java.util.*;
public class BookAllocation {
    
    public static int minPages(int a[], int k) {
        // int min = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).reduce(Integer.MIN_VALUE, Integer::max);
        int max = Arrays.stream(a).reduce(0, Integer::sum);
        int res = 0;
        while(min <= max){
            int mid = min + ((max - min) >> 1);

            if(isFeasible(a, k, mid)){
                res = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        } 
        return res;
    }

    public static boolean isFeasible(int a[], int k, int res){
        int student = 1, sum = 0;

        for (int i : a) {
            if(sum + i > res){
                student++;
                sum = i;
            }else{
                sum += i;
            }
        }

        return student <= k;
    }

    public static void main(String[] args) {
        System.out.println(minPages(new int[] {10, 10, 20, 30}, 2));
    }
}
