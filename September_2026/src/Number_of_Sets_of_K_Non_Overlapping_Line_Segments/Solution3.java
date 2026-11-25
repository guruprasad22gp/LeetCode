package Number_of_Sets_of_K_Non_Overlapping_Line_Segments;

public class Solution3 {
    public static void main(String[] args) {
		int n = 1000;
		int k = 998;
		
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.numberOfSets(n, k));
	}

    int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
    	int[][] dp = new int[k+1][n+1];
    	
    	for(int i=0;i<=n;i++) {
    		dp[0][i] = 1;
    	}
    	
    	for(int i=1;i<=k;i++) {
    		for(int j=n-1;j>=0;j--) {
    			int skip = dp[i][j+1];
    				
    			int take = 0;
    			
    			for(int a=j+1;a<n;a++) {
    				take = (take + dp[i-1][a]) % MOD;
    			}
    			
    			dp[i][j] = (take + skip) % MOD;
    		}
    	}
    	
    	return dp[k][0];	
    }
}