package Shortest_and_Lexicographically_Smallest_Beautiful_String;

public class Solution1 {
	public static void main(String[] args) {
		String s = "100011001";
		int k = 3;
		
		Solution1 m = new Solution1();
		
		System.out.println("Output: " + m.shortestBeautifulSubstring(s, k));
	}
	
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        
        for(int len = k; len <=s.length(); len++) {
        	for(int i=0; i<=s.length()-len;i++) {
        		String temp = s.substring(i, i+len);
        		int count = 0;
        		
        		for(char ch: temp.toCharArray()) {
        			if(ch == '1') {
        				count++;
        			}
        		}
        		
        		if(count == k) {
        			if(result == "" || temp.compareTo(result) < 0) {
        				result = temp;
        			}
        		}
        		
        		if(result != "") {
        			return result;
        		}
        	}
        }
        
        return "";
    }
}
