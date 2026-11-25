package Length_of_Longest_Subarray_With_at_Most_K_Frequency;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,2,3, 1,2};
		int k = 2;
		
		Main m = new Main();
		
		System.out.println("Output: " + m.maxSubarrayLength(arr, k));
	}
	
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
        	map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        	
        	while(map.get(nums[right]) > k) {
        		map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
        		left++;
        	}
        	
        	max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
