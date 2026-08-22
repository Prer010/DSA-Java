class Solution {
    public static int binarySearch(int[] arr, int start, int end, int target) 
        {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                start = mid + 1; // Search in the right half
            } else {
                end = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public int search(int[] nums, int target) {
       int start = 0;
       int end = nums.length - 1;
        int pivot = 0;
        int ans = 0;
        
        while (start < end) {
        int mid = start + (end - start) / 2;
       if (nums[mid] > nums[end]) {
        start = mid + 1;  // pivot right side mein hai
        } else {
            end = mid;        // pivot mid ya left mein hai
        }
    }
        pivot = start; // similar to finding the peak element

    if (binarySearch(nums, 0, pivot-1, target) != -1) {
        ans = binarySearch(nums, 0, pivot-1, target);
    } else {
        ans = binarySearch(nums, pivot, nums.length - 1, target);
    }

    return ans;
    }
}