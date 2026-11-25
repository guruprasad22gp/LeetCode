package Removing_Minimum_and_Maximum_From_Array;

public class Solution1 {
    public int minimumDeletions(int[] nums) {
    	int n = nums.length;
        int minEleIndex = -1;
        int maxEleIndex = -1;
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
        	if(minEle >  nums[i]) {
        		minEle = nums[i];
        		minEleIndex = i;
        	}
        	
        	if(maxEle < nums[i]) {
        		maxEle = nums[i];
        		maxEleIndex = i;
        	}
        }
        
        int leftIdx = Math.min(maxEleIndex, minEleIndex);
        int rightIdx = Math.max(maxEleIndex, minEleIndex);
        
        int case1 = (leftIdx + 1) + (n - rightIdx);
        int case2 = (rightIdx + 1);
        int case3 = n - leftIdx;
        
        return Math.min(case1, Math.min(case2, case3));
    }
    
    public static void main(String[] args) {
    	int[] nums = {2,10,7,5,4,1,8,6};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.minimumDeletions(nums));
	}
}
