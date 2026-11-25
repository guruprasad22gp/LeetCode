package Maximum_Number_of_Non_overlapping_Palindrome_Substrings;

public class Solution4 {
	boolean[][] isPalindrome;
    public int maxPalindromes(String s, int k) {
    	int n = s.length();
    	isPalindrome = new boolean[n+1][n+1];
    	palindrome(s);
    	
    	int i = 0;
    	int j = k - 1;
    	
    	return solve(s, k, i, j);
    }
    
    private int solve(String s, int k, int i, int j) {
    	if(i >= s.length() || j >= s.length()) {
    		return 0;
    	}
    	
    	if(isPalindrome[i][j]) {
    		int take = 1 + solve(s, k, j+1, j+k);
    		int grow = solve(s, k, i, j+1);
    		int slide = solve(s, k, i+1, j+1);
    		
    		return Math.max(take, Math.max(grow, slide));
    	}
    	
    	int grow = solve(s, k, i, j+1);
    	int slide = solve(s, k, i+1, j+1);
    	
    	return Math.max(grow, slide);
    }
    
    private void palindrome(String s) {
    	int n = s.length();
    	
    	for(int i=1;i<=n;i++) {
    		for(int j=0;j+i<=n;j++) {
    			int k = j+i-1;
    			
    			if(j == k) {
    				isPalindrome[j][k] = true;
    			} else if(j+1 == k) {
    				isPalindrome[j][k] = (s.charAt(j) == s.charAt(k));
    			} else {
    				isPalindrome[j][k] = (s.charAt(j) == s.charAt(k) && isPalindrome[j+1][k-1]);
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	 String s = "abaccdbbd";
    	 int k = 3;
    	 
    	 Solution4 sol4 = new Solution4();
    	 System.out.println("Output: " + sol4.maxPalindromes(s, k));
	}
}
