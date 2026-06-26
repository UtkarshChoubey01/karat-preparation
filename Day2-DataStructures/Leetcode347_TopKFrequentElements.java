//Given an integer array nums and an integer k, return the k most
//frequent elements. You may return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,1,2,2,3], k = 2
//
//Output: [1,2]

import java.util.*;

public class Leetcode347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[k];

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
    
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < k; i++) {
            arr[i] = list.get(i).getKey();
        }

        return arr;
    }

    public static void main(String[] args) {

    	Leetcode347_TopKFrequentElements solution = new Leetcode347_TopKFrequentElements();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = solution.topKFrequent(nums, k);

        System.out.println("Output : " + Arrays.toString(result));
    }
}