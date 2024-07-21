import java.util.*;
public class SpiralTraversal {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] spiralOrder(final int[][] A) {
        int a[] = new int[A.length * A[0].length];
        int top = 0, left = 0, right = A[0].length - 1, bottom = A.length - 1;
        int idx = 0;
        while(top <= bottom && left <= right){
            
            for(int i = left; i <= right; i++){
                a[idx++] = A[top][i];
            }
            top++;
            
            for(int i = top; i <= bottom; i++){
                a[idx++] = A[i][right];
            }
            right--;
            
            if(left <= right && top <= bottom){
                for(int i = right; i >= left; i--){
                    a[idx++] = A[bottom][i];
                }
                bottom--;
            
                for(int i = bottom; i >= top; i--){
                    a[idx++] = A[i][left];
                }
                left++;
            }
        }
        
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1}})));

    }
}
