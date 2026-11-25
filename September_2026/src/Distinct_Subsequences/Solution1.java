package Distinct_Subsequences;

public class Solution1 {
    public int numDistinct(String s, String t) {
        
    	return solve(s, t, 0, 0);
    }
    
    private int solve(String s, String t, int i, int j) {
    	if(j >= t.length()) {
    		return 1;
    	}
    	
    	if(i >= s.length()) {
    		return 0;
    	}
    	
    	
    	if(s.charAt(i) == t.charAt(j)) {
    		return solve(s, t, i+1, j+1) + solve(s, t, i+1, j);
    	} else {
    		return solve(s, t, i+1, j);
    	}
    }
    
    public static void main(String[] args) {
    	String s = "babgbag";
    	String t = "bag";
    	
    	Solution1 sol1 = new Solution1();
    	
    	System.out.println("Output: " + sol1.numDistinct(s, t));
	}
}
