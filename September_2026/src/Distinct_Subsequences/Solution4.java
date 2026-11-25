package Distinct_Subsequences;

import java.util.Arrays;

public class Solution4 {
	int[][] dp;
    public int numDistinct(String s, String t) {
    	int m = s.length();
    	int n = t.length();
        
    	dp = new int[m+1][n+1];
        for(int[] x: dp) {
        	Arrays.fill(x, -1);
        }
        
    	return solve(s, t, m, n);
    }
    
    private int solve(String s, String t, int m, int n) {
    	if(n == 0) {
    		return 1;
    	}
    	
    	if(m == 0) {
    		return 0;
    	}
    	
    	if(dp[m][n] != -1) {
    		return dp[m][n];
    	}
    	
    	if(s.charAt(m-1) == t.charAt(n-1)) {
    		return dp[m][n] = solve(s, t, m-1, n-1) + solve(s, t, m-1, n);
    	} else {
    		return dp[m][n] = solve(s, t, m-1, n);
    	}
    }
    
    public static void main(String[] args) {
    	String s = "babgbag";
    	String t = "bag";
    	
    	Solution4 sol4 = new Solution4();
    	
    	System.out.println("Output: " + sol4.numDistinct(s, t));
	}
}
