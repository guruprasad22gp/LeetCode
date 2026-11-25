package Number_of_Sets_of_K_Non_Overlapping_Line_Segments;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
		int n = 1000;
		int k = 998;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.numberOfSets(n, k));
	}

    int MOD = 1_000_000_007;
    int[][] dp;
    public int numberOfSets(int n, int k) {
    	dp = new int[k+1][n+1];
    	for(int[] x: dp) {
    		Arrays.fill(x, -1);
    	}
    	
    	int i = 0;
    	return solve(i, k, n);
    }
    
    private int solve(int i, int k, int n) {
    	if(k == 0) {
    		return 1;
    	}
    	
    	if(i >= n) {
    		return 0;
    	}
    	
    	if(dp[k][i] != -1) {
    		return dp[k][i];
    	}
    	
    	int skip = solve(i+1, k, n) % MOD;
    	
    	int take = 0;
    	for(int j=i+1;j<n;j++) {
    		take = (take + solve(j, k-1, n)) % MOD;
    	}
    	
    	return dp[k ][i] = (take + skip) % MOD;
    }
}