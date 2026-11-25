package Distinct_Subsequences_II;

import java.util.Arrays;

public class Solution2 {
	int[] prevIndex;
	int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        prevIndex = new int[n+1];
        
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        for(int i=1;i<=n;i++) {
        	int idx = s.charAt(i-1) - 'a';
        	prevIndex[i] = lastSeen[idx];
        	lastSeen[idx] = i; 
        }
        
    	return (solve(n)-1 + MOD) % MOD;
    }
    
    private int solve(int n) {
    	if(n==0) {
    		return 1;
    	}
    	
    	int total = (2 * solve(n-1)) % MOD;
    	
    	if(prevIndex[n] != -1) {
    		int duplicates = solve(prevIndex[n]-1) % MOD;
    		total = (total - duplicates) % MOD;
    	}
    	return total;
    }

    public static void main(String[] args) {
    	String s = "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
    	
    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.distinctSubseqII(s));
	}
}
