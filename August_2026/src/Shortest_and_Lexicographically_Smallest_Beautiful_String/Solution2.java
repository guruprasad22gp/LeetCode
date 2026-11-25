package Shortest_and_Lexicographically_Smallest_Beautiful_String;

public class Solution2 {
	public static void main(String[] args) {
		String s = "000";
		int k = 3;
		Solution2 m = new Solution2();
		System.out.println("Output: " + m.shortestBeautifulSubstring(s, k));
	}
	
    public String shortestBeautifulSubstring(String s, int k) {
	    	int n = s.length();
	    	int count = 0;
	    	int left = 0;
	    	String result = "";
	    	
	    	for(int right = 0; right < n; right++) {
	    		if(s.charAt(right) == '1') {
	    			count++;
	    		}
	    		
	    		if(count == k) {
	    			int len = right - left + 1;
	    			String temp = s.substring(left, right +1);
	    			
	    			if(result.isEmpty() || result.length() > len|| (temp.length() == result.length() && temp.compareTo(result) < 0)) {
	    				result = temp;
	    			}
	    		}
	    		
	    		while(count >= k || (left < n && s.charAt(left) == '0')) {
	    			if(s.charAt(left) == '1') {
	    				count--;
	    			}
	    			left++;
	    		}
	    	}
	    	
	    	return result;
    }
}
