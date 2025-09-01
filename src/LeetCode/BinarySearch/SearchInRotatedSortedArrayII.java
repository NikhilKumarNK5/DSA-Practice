package LeetCode.BinarySearch;

public class SearchInRotatedSortedArrayII {
    // Approach 1: Using Linear Search
    // TC => O(N)
    public boolean search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return true;
        }
        return false;
    }
    // Approach 2: Using Binary Search
    // TC => O(LogN)
    public boolean searchBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return true; // if the target is found
            }

            // shrinks window if duplicates
            if(nums[start] == nums[mid] && nums[end] == nums[mid]) {
                start++;
                end--;
            }

            else if(nums[start] <= nums[mid]) { // left half is sorted
                // target lies in left half
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { //right half is sorted
                // target lies in right half
                if(target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
