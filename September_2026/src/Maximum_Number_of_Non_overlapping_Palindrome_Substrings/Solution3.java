package Maximum_Number_of_Non_overlapping_Palindrome_Substrings;

public class Solution3 {
    public int maxPalindromes(String s, int k) {
    	int n = s.length();
        if(k == 1) {
            return n;
        }

        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>=i;j--) {
                if(isPalindrome(s, i, j)) {
                    int take = 1 + ((j+k <= n)? dp[j+1][j+k]: 0);
                    int grow = dp[i][j+1];
                    int slide = dp[i+1][j+1];

                    dp[i][j] = Math.max(take, Math.max(grow, slide));
                    continue;
                }

                int grow = dp[i][j+1];
                int slide = dp[i+1][j+1];

                dp[i][j] = Math.max(grow, slide);
            }
        }

        return dp[0][k-1];
    	
    }
    
    private boolean isPalindrome(String s, int i, int j) {
    	if(i > j) {
    		return false;
    	}
    	
    	while(i < j) {
    		if(s.charAt(i) != s.charAt(j)) {
    			return false;
    		}
    		
    		i++;
    		j--;
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	 String s = "abaccdbbd";
    	 int k = 3;
    	 
    	 Solution3 sol3 = new Solution3();
    	 System.out.println("Output: " + sol3.maxPalindromes(s, k));
	}
}