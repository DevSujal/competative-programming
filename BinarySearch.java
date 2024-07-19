public class BinarySearch {
    public static int binarySearch(int arr[], int num, int left, int right) {

        if (left > right)
            return -1;

        int mid = left + ((right - left) >> 1);
        if (arr[mid] == num) {
            return mid + 1;
        }

        if (num < arr[mid]) {
            return binarySearch(arr, num, left, mid - 1);
        } else {
            return binarySearch(arr, num, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

        int n = 4;
        System.out.println(binarySearch(arr, n, 0, arr.length - 1));
    }
}
