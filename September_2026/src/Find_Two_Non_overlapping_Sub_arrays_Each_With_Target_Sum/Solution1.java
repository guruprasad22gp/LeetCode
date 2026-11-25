package Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum;

import java.util.Arrays;

public class Solution1 {
    public int minSumOfLengths(int[] arr, int target) {
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        int currentSum = 0;
        
        int[] minLenTillIdx = new int[arr.length];
        Arrays.fill(minLenTillIdx, Integer.MAX_VALUE);
        
        while(j < arr.length) {
        	currentSum += arr[j];
        	
        	while(currentSum > target) {
        		currentSum -= arr[i];
        		i++;
        	}
        	
        	if(currentSum == target) {
        		int len = j - i + 1;
        		
        		if(i > 0 && minLenTillIdx[i-1] != Integer.MAX_VALUE) {
        			result = Math.min(result, len + minLenTillIdx[i-1]);
        		}
        		
        		minLen = Math.min(minLen, len);
        	}
        	
        	minLenTillIdx[j] = minLen;
        	j++;
        }
        
        return result == Integer.MAX_VALUE? -1: result;
    }
    
    public static void main(String[] args) {
		int[] arr = {7,3,4,7};
		int targets = 3;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minSumOfLengths(arr, targets));
	}
}
