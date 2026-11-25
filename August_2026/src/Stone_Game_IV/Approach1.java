package Stone_Game_IV;

import java.util.Arrays;

//Bottom up approach
public class Approach1 {
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println("Output: " + m.winnerSquareGame(9));
	}
	
	boolean[] dp;
	public boolean winnerSquareGame(int n) {
        dp = new boolean[n+1];
        Arrays.fill(dp, false);
        
		if(n == 0) {
        	return false;
        }
		
		for(int i=0;i<n+1;i++) {
			for(int k=1;k*k<=i;k++) {
				if(!dp[i-k*k]) {
					dp[i] = true;
					break;
				}
			}
		}
        
		return dp[n] == true;
    }
}
