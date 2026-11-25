package Stone_Game_V;

import java.util.Arrays;

public class bottomUp {
	public static void main(String[] args) {
		int[] arr = {7,7,7,7,7,7,7};
		Main m = new Main();
		
		System.out.println("Output: " + m.stoneGameV(arr));
	}
	
	int dp[][];
	int n;
	public int stoneGameV(int[] stoneValue) {
		n = stoneValue.length;
        dp = new int[n+1][n+1];
        for(int i=0;i<n+1;i++) {
        	Arrays.fill(dp[i], -1);
        }
		int[] prefixSum = new int[n];
        
        prefixSum[0] = stoneValue[0];
        
        for(int i=1;i<n;i++) {
        	prefixSum[i] = prefixSum[i-1] + stoneValue[i];
        }
        
        return solve(0, n-1, prefixSum);
    }
	private int solve(int left, int right, int[] prefixSum) {
		if(left >= right) {
			return 0;
		}
		
		if(dp[left][right] != -1) {
			return dp[left][right];
		}
		
		int aliceScore = 0;
		
		for(int l=n-1;l>=0;l--) {
			for(int r=l+1;r<n;r++) {
				for(int i=l;i<r;i++) {
					int leftSum = prefixSum[i] - (left - 1 >= 0? prefixSum[left- 1]: 0);
					int rightSum = prefixSum[right]-prefixSum[i];
					
					if(leftSum < rightSum) {
						aliceScore = Math.max(aliceScore, leftSum + dp[l][i]);
					} else if(leftSum > rightSum) {
						aliceScore = Math.max(aliceScore, rightSum + dp[i+1][r]);
					} else {
						aliceScore = Math.max(
								aliceScore, 
								Math.max(
										leftSum + dp[l][i], 
										rightSum + dp[i+1][r]
										)
								);
					}
				}
			}
		}
		
		return dp[left][right];
	}
}
