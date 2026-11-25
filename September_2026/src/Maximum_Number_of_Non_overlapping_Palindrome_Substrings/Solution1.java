package Maximum_Number_of_Non_overlapping_Palindrome_Substrings;

public class Solution1 {
    public int maxPalindromes(String s, int k) {
        
    	int i = 0;
    	int j = k - 1;
    	return solve(s, k, i, j);
    }
    
    private int solve(String s, int k, int i, int j) {
    	if(i >= s.length() || j >= s.length()) {
    		return 0;
    	}
    	
    	if(isPalindrome(s, i, j)) {
    		int take = 1 + solve(s, k, j+1, j+k);
    		int grow = solve(s, k, i, j+1);
    		int slide = solve(s, k, i+1, j+1);
    		return Math.max(take, Math.max(grow, slide));
    	}
    	
    	int grow = solve(s, k, i, j+1);
    	int slide = solve(s, k, i+1, j+1);
    	
    	return Math.max(grow, slide);
    }
    
    private boolean isPalindrome(String s, int i, int j) {
    	String str = s.substring(i, j+1);
    	
    	StringBuilder sb = new StringBuilder(str);
    	
    	return str.equals(sb.reverse().toString());
    }
    
    public static void main(String[] args) {
    	 String s = "abaccdbbd";
    	 int k = 3;
    	 
    	 Solution1 sol1 = new Solution1();
    	 System.out.println("Output: " + sol1.maxPalindromes(s, k));
	}
}
