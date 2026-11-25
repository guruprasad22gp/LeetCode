package Construct_Uniform_Parity_Array_II;

public class Solution1 {
    public boolean uniformArray(int[] nums1) {
        int oddMin = Integer.MAX_VALUE;
        int evenMin = Integer.MAX_VALUE;
        
        for(int ele: nums1) {
        	if(ele % 2 == 0) {
        		evenMin = Math.min(evenMin, ele);
        	} else {
        		oddMin = Math.min(oddMin, ele);        		
        	}
        }
        
        if(evenMin == Integer.MAX_VALUE || oddMin == Integer.MAX_VALUE) {
        	return true;
        }
        
        return oddMin < evenMin;
    }
    
    public static void main(String[] args) {
		int[] nums = {2,3};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.uniformArray(nums));
	}
}
