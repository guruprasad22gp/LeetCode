package Smallest_Stable_Index_II;

public class Solution1 {
    public int firstStableIndex(int[] nums, int k) {
    	int n = nums.length;
    	int minEle[] = new int[n];
    	int currMin = Integer.MAX_VALUE;
    	for(int i=n-1;i>=0;i--) {
    		currMin = Math.min(currMin, nums[i]);
    		minEle[i] = currMin;
    	}
    	
    	int max= Integer.MIN_VALUE;
    	for(int i=0;i<n;i++) {
    		max = Math.max(max, nums[i]);
    		if(max- minEle[i] <= k) {
    			return k;
    		}
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	int[] nums = {5,0,1,4};
    	int k = 3;
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.firstStableIndex(nums, k));
	}
}
