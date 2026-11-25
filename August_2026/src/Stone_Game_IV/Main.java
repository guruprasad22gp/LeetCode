package Stone_Game_IV;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int n = 4;
		
		System.out.println("Output: " + m.winnerSquareGame(n));
	}
	
	
	boolean[] dp;
	public boolean winnerSquareGame(int n) {
		dp = new boolean[n+1];
		Arrays.fill(dp, false);
		return solve(n);
    }
	
	private boolean solve(int n) {
		if(n == 0) {
			return false;
		}
		
		if(dp[n]) {
			return dp[n];
		}
		
		for(int k=1;k*k <= n; k++) {
			if(!solve(n-k*k)) {
				return dp[n] = true;
			}
		}
		
		return dp[n] = false;
	}
}
