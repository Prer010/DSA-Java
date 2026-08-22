class Solution {
    public int splitArray(int[] nums, int k) {
       int start = 0;
       int end = 0;

       for(int i =0; i<nums.length; i++) {
        start = Math.max(start, nums[i]); // largest element in the array = smallest max sum possible
        end += nums[i]; // sum of all elements in the array = maximum max sum possible
       }

       // binary search
       while (start < end) {
        int subarr = 1;
        int sum = 0;
        int mid = start + (end-start) / 2; // take the avg. of the smallest possible max sum and the largest possible max sum and check against it

        for (int i = 0; i<nums.length; i++) { // breaking into subarrays based on a max sum constraint taken as avg. of the smallest and largest possible max sum and each time reaching the possible minimized max sum by finding mid using binary search on either right or left side of the calculated mid.
            if(sum+nums[i] > mid){
                // create new subarray
                sum = nums[i];
                subarr++;
            } else {
                // keep adding in the same subarray
                sum += nums[i];
            }
        }

        if(subarr > k) {
            // reduce the no. of subarrays by increasing the max sum to be checked against
            // actual possible max sum is on the right side of the mid, so calculate new mid on the right hand side
            start = mid+1;
        } else {
            // increase the no. of subarrays decreasing the max sum
            // actual possible max sum is on the left side of the mid, so calculate new mid on the left hand side
            end = mid;
        }
       }

       return end; 
    }
}