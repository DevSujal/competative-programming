public class DivideTheNo {
    public static void main(String[] args) {
        // int a = Integer.MIN_VALUE, b = 3;
        // System.out.println(a);
        // System.err.println(1 - a);
        // System.out.println(a);
        // int count = 0;
        // while(a >= b){
        // count++;
        // a = a ^ b;
        // }
        // System.out.println(a ^ b);

        int arr[] = new int[] { 3, 4, 5, 6, 7, 2, 3 };
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
            System.out.println(ans);
        }
    }
}
