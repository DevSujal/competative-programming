import java.util.*;
public class BinarySearch {
    public static int binarySearch(int arr[], int num, int left, int right) {

        if (left > right)
            return -1;

        int mid = left + ((right - left) >> 1);
        if (arr[mid] == num) {
            return mid;
        }

        if (num < arr[mid]) {
            return binarySearch(arr, num, left, mid - 1);
        } else {
            return binarySearch(arr, num, mid + 1, right);
        }
    }

    public static int searchInRotatedSortedArray(int a[], int key) {

        int low = 0, high = a.length - 1;

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] == key) return mid;

            if(a[low] < a[mid]) { // Left array is sorted
                if(a[low] <= key && key < a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(a[low] > a[mid]) { // Right array is sorted
                if(a[mid] < key && key <= a[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { // a[low] == a[mid], handle duplicates
                low++;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        //  int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11 ,12, 34, 89, 84785, 88034, 89345, 489438, 9948493, 843985039};

        // int low = 0, high = 1, key = 11;

        // while(arr[high] < key){
        //     low = high;
        //     high = high << 1;
        // }

        // System.out.println(binarySearch(arr, key, low, high));

        // int idx = Arrays.binarySearch(arr, low, high, key);
        // System.out.println(idx);

         int arr[] =  {3, 4, 5, 1, 2};

         System.out.println(searchInRotatedSortedArray(arr, 1));
    }
}
