import java.util.HashMap;

public class SubArrayWithGivenSumK {

    public static int subArrayWithGivenSumK(int a[], int sum) {
        int currSum = 0, start = 0, end = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];

            if(currSum == sum) {
                start = 0;
                end = i;
                break;
            }

            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }

            map.put(currSum, i);
        }

        if(end == -1) return -1;
        System.out.println(start + " " + end);
        return 1;
    }

    public static void main(String[] args) {
        subArrayWithGivenSumK(new int[]{10, 15, -5, 15, -10, 5}, 5);
    }
}
