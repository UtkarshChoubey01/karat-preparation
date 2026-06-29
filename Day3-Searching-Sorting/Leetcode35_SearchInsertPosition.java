//Given a sorted array of distinct integers and a target value, 
//return the index if the target is found. If not, return the
//index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [1,3,5,6], target = 5
//Output: 2


public class Leetcode35_SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid]== target)
                return mid;

            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return start;
    }

    public static void main(String[] args) {

    	Leetcode35_SearchInsertPosition solution = new Leetcode35_SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};

        System.out.println(solution.searchInsert(nums, 5)); // Expected: 2
        System.out.println(solution.searchInsert(nums, 2)); // Expected: 1
        System.out.println(solution.searchInsert(nums, 7)); // Expected: 4
        System.out.println(solution.searchInsert(nums, 0)); // Expected: 0
    }
}