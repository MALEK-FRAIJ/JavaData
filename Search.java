package DataStructures;

public class Search {

     /*
     * interpolation Search = improvement over binary search best used for
     * "uniformly" distribute "guesses" where a value might be based on calculated
     * probe results if probe is incorrect, search area is narrowed, and a new probe
     * is calculated
     */
    // runtime: average case : O(log(log(n)))
    // worst case: O(n)[values increase exponentially]
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            int probe = low + (high - low) * (target - arr[low]) / (arr[high] - arr[low]);

            System.out.println("probe" + probe);
            if (arr[probe] == target)
                return probe;
            else if (arr[probe] < target)
                low = probe + 1;
            else
                high = probe - 1;

        }

        return -1;
    }


    /*
     * binary search = Search algorithm that finds the position
     * of a target value within a sorted array.
     * 
     */
    // runtime complexity: O(log(n))
    // Half of the array is eliminated during each "step"
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = arr[middle];

            if (value < target)
                low = middle + 1;
            else if (value > target)
                high = middle - 1;
            else
                return middle; // target found

        }

        return -1; // target not found
    }

    /* linear search = iterate through a collection one element at a time */
    // runtime complexity: O(n)
    // Disadvantages: slow for large data sets
    /*
     * Advantage:
     * Fast for searches of small to medium data sets
     * Dose not need to sorted
     * Useful for data structures that do not have random access(linked list)
     */
    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
       
  

    }

   
}
