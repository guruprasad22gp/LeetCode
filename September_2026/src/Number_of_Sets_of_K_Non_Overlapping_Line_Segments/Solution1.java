package Number_of_Sets_of_K_Non_Overlapping_Line_Segments;

public class Solution1 {
	int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
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
    	
    	int skip = solve(i+1, k, n) % MOD;
    	
    	int take = 0;
    	for(int j=i+1;j<=n-1;j++) {
    		take = (take + solve(j, k-1, n)) % MOD;
    	}
    	
    	return (skip + take) % MOD;
    }
    
    public static void main(String[] args) {
		int n = 30;
		int k = 7;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.numberOfSets(n, k));
	}
}
