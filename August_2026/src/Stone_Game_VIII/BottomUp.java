package Stone_Game_VIII;

public class BottomUp {
	public static void main(String[] args) {
		int[] stones = {-53,-56,90,-74,-50,29,37,64,-31,-54,74,-80,-18,-69,-44,73,99,-47,-35,71,-55,-27,34,1,-66,-63,3,-34,33,91,-25,-40,-33,68,-34,-32,69,44,-54};
		
		BottomUp m = new BottomUp();
		System.out.println("Output: " + m.stoneGameVIII(stones));
	}
	
	public int stoneGameVIII(int[] stones) {
		int n = stones.length;
		
		int[] prefixSum = new int[n];
		
		prefixSum[0] = stones[0];
		for(int i=1;i<n;i++) {
			prefixSum[i] = prefixSum[i-1] + stones[i]; 
		}
		
		int[] dp = new int[n+1];
		dp[n-1] = prefixSum[n-1];
		for(int i=n-2;i>=1;i--) {
			int take = prefixSum[i] - dp[i+1];
			int skip = dp[i+1];
			
			dp[i] = Math.max(take, skip);
 		}
		
		return dp[1];
	}
}