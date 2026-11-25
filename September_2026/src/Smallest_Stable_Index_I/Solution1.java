package Smallest_Stable_Index_I;

public class Solution1 {
    public int firstStableIndex(int[] nums, int k) {
    	int n = nums.length;
        int[] minEle = new int[n];
        int minElement = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--) {
        	minElement = Math.min(minElement, nums[i]);
        	minEle[i] = minElement;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
        	max = Math.max(max, nums[i]);
        	if((max - minEle[i]) <= k) {
        		return i;
        	}
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
    	int nums[] = {5,0,1,4};
    	int k = 3;
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.firstStableIndex(nums, k));
	}
}
