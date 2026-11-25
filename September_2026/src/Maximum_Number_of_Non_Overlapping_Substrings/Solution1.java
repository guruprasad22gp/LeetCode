package Maximum_Number_of_Non_Overlapping_Substrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<String> maxNumOfSubstrings(String s) {
    	int n = s.length();

    	int[] startIndex = new int[26];
    	Arrays.fill(startIndex, -1);
    	int[] endIndex = new int[26];
    	Arrays.fill(endIndex, 0);
    	    	
    	for(int i=0;i<s.length();i++) {
    		int idx = s.charAt(i)-'a';
    		if(startIndex[idx] == -1) {
    			startIndex[idx] = i;
    		}
    		
    		endIndex[idx] = i;
    	}
    	
    	boolean[] isValid = new boolean[26];
    	Arrays.fill(isValid, true);
    	
    	
    	for(int c=0;c<26;c++) {
    		if(startIndex[c] == -1) {
    			continue;
    		}
    		
    		int start = startIndex[c];
    		
    		for(int i=start;i<=endIndex[c];i++) {
    			int idx = s.charAt(i)-'a';
    			if(startIndex[idx] < start) {
    				isValid[c] = false;
    				break;
    			}
    			endIndex[c] = Math.max(endIndex[c], endIndex[idx]);
    		}
    	}
    	
    	List<String> result = new ArrayList<String>();
    	int lastTakenStartIndex = Integer.MAX_VALUE;
    	
    	for(int i=n-1;i>=0;i--) {
    		int idx = s.charAt(i) - 'a';
    		 
    		if(!isValid[idx]) {
    			continue;
    		}
    		
    		if(i == startIndex[idx] && endIndex[idx] < lastTakenStartIndex) {
    			result.add(s.substring(i, endIndex[idx] + 1));
    			lastTakenStartIndex = i;
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		String s = "dzdabazbbccd";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxNumOfSubstrings(s));
	}
}