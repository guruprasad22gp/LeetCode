package Longest_Subsequence_With_Non_Zero_Bitwise_XOR;

public class Main {
	public static void main(String[] args) {
		int[] arr = {2,1,2,1, 3};
		
		Main m = new Main();
		
		System.out.println("Output: " + m.longestSubsequence(arr));
	}
	
	public int longestSubsequence(int[] nums) {
		int xor = 0;
		boolean allZero = true;
		int n = nums.length;
		
		for(int ele: nums) {
			xor ^= ele;
			
			if(ele != 0) {
				allZero = false;
			}
		}
		
		if(allZero) {
			return 0;
		}
		
		return xor == 0? n-1: n;
	}
}
