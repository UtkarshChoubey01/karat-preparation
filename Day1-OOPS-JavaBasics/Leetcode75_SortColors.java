
//Given an array nums with n objects colored red, white, or blue,
//sort them in-place so that objects of the same color are adjacent, 
//with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.

class Solution {
	public void sortColors(int[] nums) {
		int red = 0, blue = 0, white = 0;

		for (int col : nums) {

			if (col == 0)
				red++;
			if (col == 1)
				white++;
			if (col == 2)
				blue++;
		}

		for (int i = 0; i < red; i++) {
			nums[i] = 0;
		}
		for (int i = red; i < red + white; i++) {
			nums[i] = 1;
		}
		for (int i = red + white; i < red + white + blue; i++) {
		 	nums[i] = 2;
		}

	}
}
