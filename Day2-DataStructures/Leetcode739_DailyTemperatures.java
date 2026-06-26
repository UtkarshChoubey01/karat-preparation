//Given an array of integers temperatures represents the daily temperatures, 
//return an array answer such that answer[i] is the number of days you have
//to wait after the ith day to get a warmer temperature. If there is no future
//day for which this is possible, keep answer[i] == 0 instead.
//
// 
//
//Example 1:
//
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]

import java.util.Arrays;
import java.util.Stack;

public class Leetcode739_DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int size = temperatures.length;
        int[] ans = new int[size];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index =stack.pop();
                ans[index] = i - index;
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        Leetcode739_DailyTemperatures solution =
                new Leetcode739_DailyTemperatures();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = solution.dailyTemperatures(temperatures);

        System.out.println("Output : " + Arrays.toString(result));
    }
}