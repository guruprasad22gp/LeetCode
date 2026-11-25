package Stone_Game_VIII;

import java.util.Arrays;

public class Main {
	int[] dp;
	public int stoneGameVIII(int[] stones) {
		int n = stones.length;
		int[] prefixSum = new int[n];
		prefixSum[0] = stones[0];
		for(int i=1;i<n;i++) {
			prefixSum[i] = prefixSum[i-1] + stones[i]; 
		}
		
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		
		return solve(1, prefixSum);
	}
	
	private int solve(int i, int[] prefixSum) {
		if(i == prefixSum.length-1) {
			return prefixSum[i];
		}
		
		if(dp[i] != -1) {
			return dp[i];
		}
		
		int take = prefixSum[i] - solve(i+1, prefixSum);
		int skip = solve(i+1, prefixSum);
		
		return dp[i] = Math.max(take, skip);
	}
	
	public static void main(String[] args) {
		int[] stones = {-53,-56,90,-74,-50,29,37,64,-31,-54,74,-80,-18,-69,-44,73,99,-47,-35,71,-55,-27,34,1,-66,-63,3,-34,33,91,-25,-40,-33,68,-34,-32,69,44,-54};
		
		Main m = new Main();
		
		System.out.println("Output: " + m.stoneGameVIII(stones));
	}
}
