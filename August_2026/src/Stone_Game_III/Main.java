package Stone_Game_III;

import java.util.Arrays;

public class Main {
	int dp[];
	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        int ans = solve(0, stoneValue);
        if(ans > 0) {
        	return "Alice";
        } else if(ans < 0) {
        	return "Bob";
        } else {
        	return "Tie";
        }
    }
	
	private int solve(int i, int[] arr) {
		if(i >= arr.length) {
			return  0;
		}
		
		if(dp[i] != -1) {
			return dp[i];
		}
		
		int result = Integer.MIN_VALUE;
		
		result = Math.max(arr[i] - solve(i+1,arr), result);
		if(i+1 < arr.length) {
			result = Math.max(arr[i] + arr[i+1] - solve(i+2, arr), result);
		}
		if(i+2 < arr.length) {
			result = Math.max(arr[i] + arr[i+1] + arr[i+2] - solve(i+3, arr), result);
		}
		
		return dp[i] = result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,7};
		
		Main m = new Main();
		System.out.println("Output: " + m.stoneGameIII(arr));
	}
}
