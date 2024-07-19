public class SubArray {

    public static void printAllSubArrays(int arr[], int idx, int end) {
        if (idx >= arr.length) 
            return;

        if (idx > end) 
            printAllSubArrays(arr, 0, end + 1);

        else {
            for (int i = idx; i < end; i++)
                System.out.print(arr[i] + " ");
            if (idx != end)
                System.out.println();
            printAllSubArrays(arr, idx + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };

        printAllSubArrays(arr, 0, 0);
    }
}
