package Maximum_Number_of_Non_overlapping_Palindrome_Substrings;

public class Solution8 {
	boolean[][] isPalindrome;
    public int maxPalindromes(String s, int k) {
    	int n = s.length();
    	
    	isPalindrome = new boolean[n+1][n+1];
    	palindrome(s);
    	int[] dp = new int[n+1];
    	for(int i=0;i<k;i++) {
    		dp[i] = 0;
    	}
    	
    	for(int i=k;i<=n;i++) {
    		int j = i-1;
    		int result = dp[j];
    		
    		for(int a=0;j-a+1 >= k;a++) {
    			if(isPalindrome[a][j]) {
    				result = Math.max(result, 1 + dp[a]);
    			}
    		}
    		
    		dp[i] = result;
    	}
    	
    	return dp[n];
    } 
    
    private void palindrome(String s) {
    	int n = s.length();
    	
    	for(int i=1;i<=n;i++) {
    		for(int j=0;j+i<=n;j++) {
    			int k = i+j-1;
    			
    			if(j == k) {
    				isPalindrome[j][k] = true;
    			} else if(j+1 == k) {
    				isPalindrome[j][k] = s.charAt(j) == s.charAt(k);
    			} else {
    				isPalindrome[j][k] = (s.charAt(j) == s.charAt(k) && isPalindrome[j+1][k-1]);
    			}
    		}
    	}
    }

    public static void main(String[] args) {
    	 String s = "abaccdbbd";
    	 int k = 3;
    	 
    	 Solution8 sol8 = new Solution8();
    	 System.out.println("Output: " + sol8.maxPalindromes(s, k));
	}
}