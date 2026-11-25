package Predict_the_Winner;

import java.util.Arrays;

public class Main {
	static int dp[][];
	public static void main(String[] args) {
		Main m = new Main();
		
		dp = new int[23][23];
		for(int i=0;i<23;i++) {
			Arrays.fill(dp[i], -1);
		}
		int[] arr = {1,5,233, 7};
		int sum = 0;
		for(int ele: arr) {
			sum += ele;
		}
		
		int p1 = m.solve(0, arr.length-1, arr);
		
		if(sum - p1 > p1) {
			System.out.println("Output: " + false);
		} else {
			System.out.println("Output: " + true);
		}
		
	}
	
	int solve(int start, int end, int[] arr) {
		if(start > end) {
			return 0;
		}
		
		if(dp[start][end] != -1) {
			return dp[start][end];
		}
		
		int sum_start = arr[start] + Math.min(solve(start+2, end, arr), solve(start+1, end-1, arr));
		int sum_end = arr[end] + Math.min(solve(start+1,  end-1, arr), solve(start, end-2, arr));
		
		return dp[start][end] = Math.max(sum_end, sum_start);
	}
}
