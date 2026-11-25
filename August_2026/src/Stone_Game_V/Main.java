	package Stone_Game_V;
	
	import java.util.Arrays;
	
	public class Main {
		public static void main(String[] args) {
			int[] arr = {1,2,3,4};
			Main m = new Main();
			
			System.out.println("Output: " + m.stoneGameV(arr));
		}
		
		int dp[][];
		public int stoneGameV(int[] stoneValue) {
			int n = stoneValue.length;
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
		
		int solve(int left, int right, int[] prefixSum) {
			
			if(left >= right) {
				return 0;
			}
			
			if(dp[left][right] != -1) {
				return dp[left][right];
			}
			
			int aliceScore = 0;
			
			for(int i=left;i<right;i++) {
				int leftSum = prefixSum[i] - (left - 1 >= 0? prefixSum[left- 1]: 0);
				int rightSum = prefixSum[right]-prefixSum[i];
				
				if(leftSum < rightSum) {
					aliceScore = Math.max(aliceScore, leftSum + solve(left, i, prefixSum));
				} else if(leftSum > rightSum) {
					aliceScore = Math.max(aliceScore, rightSum + solve(i+1, right, prefixSum));
				} else {
					aliceScore = Math.max(
							aliceScore, 
							Math.max(
									leftSum + solve(left, i, prefixSum), 
									rightSum + solve(i+1, right, prefixSum)
									)
							);
				}
			}
			
			return dp[left][right] = aliceScore;
		}
	}
