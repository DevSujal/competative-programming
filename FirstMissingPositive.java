public class FirstMissingPositive {
    public static int findFirstMissingPositive(int arr[]) {

        for (int i = 0; i < arr.length; i++) if(arr[i] < 0) arr[i] = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            if(val >= 1 && val <= arr.length){

                if(arr[val - 1] == 0)
                    arr[val - 1] = 0 - arr.length - 1;
                else if(arr[val - 1] > 0)
                    arr[val - 1] *= -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) return i + 1;
        }

        return arr.length + 1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3};
        System.out.println(findFirstMissingPositive(arr));
    }
}
