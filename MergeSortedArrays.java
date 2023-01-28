// How to merge two sorted arrays in Java..
// arr[]1 started from i = 0 and arr[]2 started from j = 0 and result[] started from k = 0
// If one array is exhausted than we will copy all the remaining elements of the other array in the result array.
// our result array is also sorted.

public class MergeSortedArrays {

    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // we are simply returning our sorted resultant array which is the merged arrray of both the arr1 and arr2 arrays
    public int[] merge(int[] arr1, int[] arr2, int n, int m){
        int[] result = new int[n + m];
        int i = 0; // traverse arr1
        int j = 0; // traverse arr2
        int k = 0; // traverse result
        while(i < n && j < m){ // boundary conditions
            if(arr1[i]  < arr2[j]){ // if arr1 element at i is less than arr2 element ar j
                result[k] = arr1[i]; // storing arr1 element into result
                i++; // for checking the next index incrementing i by 1
            }else{
                result[k] = arr2[j]; // storing arr2 element into result
                j++; // for checking the next index incrementing j by 1

            }
            k++; // incrementing k by 1 becoz this index of k is filled so for next turn we are moving it to unfilled index
        }
        // we are simply copying the remaining elements because they are already sorted so no need to compare with any one
        //either arr1 got exhausted or arr2 got exhausted
        // if arr2 is exhausted we are copying the remaining elements of the arr1 in the result array
        while(i < n){
          result[k] = arr1[i];
          i++;k++;
        }
        // if arr1 is exhausted we are copying the remaining elements of the arr2 in the result array
        while(j < m){
            result[k] = arr2[j];
            j++;k++;
        }
          return result;
    }
    public static void main(String[] args) {
        MergeSortedArrays ms = new MergeSortedArrays();
        int[] arr1 = {0, 1, 8, 10}; // sorted in ascending order
        int[] arr2 = {2, 8, 11, 15, 20}; // sorted in ascending order
        ms.printArray(arr1);
        ms.printArray(arr2);

       int[] result =  ms.merge(arr1,arr2, arr1.length, arr2.length);
       ms.printArray(result);

    }
}
