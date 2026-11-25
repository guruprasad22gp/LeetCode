package Distinct_Subsequences_II;

import java.util.HashSet;

public class Solution1 {
	HashSet<String> set;
    public int distinctSubseqII(String s) {
        set = new HashSet<>();
        solve(0, new String(), s);
        
        return set.size();
    }
    
    private void solve(int i, String curr, String s) {
    	if(i == s.length()) {
    		if(curr.length() > 0 && !set.contains(curr)) {
    			set.add(curr);
    		}
    		
    		return;
    	}
    	
    	solve(i+1, curr + s.charAt(i), s);
    	solve(i+1, curr, s);
    }

    public static void main(String[] args) {
    	String s = "abc";
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.distinctSubseqII(s));
	}
}
