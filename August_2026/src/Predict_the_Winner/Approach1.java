package Predict_the_Winner;

import java.util.Arrays;

public class Approach1 {
	int dp[][];
	public static void main(String[] args) {
		Approach1 m = new Approach1();
		System.out.println("Output: " + m.solution());
	}
	
	public boolean solution() {
		dp = new int[23][23];
		for(int i=0;i<23;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int[] arr = {1,5,233, 7};

		int ans = solve(0, arr.length-1, arr);
		
		if(ans >= 0) {
			return true;
		}
		return false;
		
	}
	
	public int solve(int start, int end, int[] arr) {
		if(start > end) {
			return 0;
		}
		
		if(dp[start][end] != -1) {
			return dp[start][end];
		}
		
		int sum_start = arr[start] - solve(start+1, end, arr);
		int sum_end = arr[end] - solve(start, end - 1, arr);
		
		return dp[start][end] = Math.max(sum_start, sum_end);
	}
}
