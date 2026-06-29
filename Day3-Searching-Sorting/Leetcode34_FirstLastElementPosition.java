//Given an array of integers nums sorted in non-decreasing order, 
//find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]


public class Leetcode34_FirstLastElementPosition {

	public int[] searchRange(int[] nums, int target) {
        
        int start=findFirst(nums,target),end =findLast(nums,target);
       return new int[]{start,end};
   }

   public int findFirst(int[] nums, int target){
       int start=0,end =nums.length-1,first=-1;
        while(start<=end){
        
           int mid = start +(end-start)/2;
           if(nums[mid]==target) {
               first=mid;
               end=mid-1;
           }

           
           if(nums[mid]<target)start=mid+1;
           if(nums[mid]>target)end=mid-1;
            
       }
       return first;
   }

    public int findLast(int[] nums, int target){
       int start=0,end =nums.length-1,last=-1;
        while(start<=end){
        
           int mid = start +(end-start)/2;
           if(nums[mid]==target) {
               last=mid;
               start=mid+1;
           }

           
           if(nums[mid]<target)start=mid+1;
           if(nums[mid]>target)end=mid-1;
            
       }
       return last;
   }

    public static void main(String[] args) {

    	Leetcode34_FirstLastElementPosition solution = new Leetcode34_FirstLastElementPosition();

        int[] nums = {5,7,7,8,8,10};

        int[] arr=solution.searchRange(nums, 8); 
        for(int num: arr) {
        	System.out.println(num);
        }
        
    }
}