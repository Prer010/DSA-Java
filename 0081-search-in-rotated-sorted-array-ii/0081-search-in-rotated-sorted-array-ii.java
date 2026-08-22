class Solution {
    public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return true;
        }

        // Jab teeno equal ho, decision nahi le sakte -> shrink dono taraf se
        if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
            start++;
            end--;
        }
        // Left half ascending sorted hai
        else if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                end = mid - 1; // target left half mein hai
            } else {
                start = mid + 1;
            }
        }
        // Right half ascending sorted hai
        else {
            if (nums[mid] < target && target <= nums[end]) {
                start = mid + 1; // target right half mein hai
            } else {
                end = mid - 1;
            }
        }
    }
    return false;
}
}