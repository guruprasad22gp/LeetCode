package Lexicographically_Smallest_Palindromic_Permutation_Greater_Than_Target;

public class Main {
	public static void main(String[] args) {
		String s = "abababababababababab";
		String target = "babababababababababa";
		
		Main m = new Main();
		System.out.println("output: " + m.lexPalindromicPermutation(s, target));
	}
	
	char mid = ' ';
	int halfLen;
	String result;
    public String lexPalindromicPermutation(String s, String target) {
    		int n = s.length();
    		int[] countS = new int[26];
    		for(char ch: s.toCharArray()) {
    			countS[ch-'a']++;
    		}
    		int oddCount = 0;
    		
    		for(int i=0;i<26;i++) {
    			if(countS[i] % 2 == 1) {
    				oddCount++;
    				mid = (char)(i + 'a');
    			}
    		}
    		
    		if(oddCount > 1) {
    			return "";
    		}
    		
    		for(int c = 0; c<26;c++) {
    			countS[c] /= 2;
    		}
    		
    		StringBuilder curr = new StringBuilder(); 
    		int index = 0;
    		boolean greater = false;
        	halfLen = n/2;
        	
        	boolean ans = build(countS, curr, index, target, greater);
        	return ans? result: "";   		
    }
    
    private boolean build(int[] count, StringBuilder curr, int index, String target, boolean greater) {
    		if(curr.length() == halfLen) {
    			String candidate = new StringBuilder(curr).toString();
    			String rightHalf = new StringBuilder(curr).reverse().toString();
    			
    			if(mid == ' ') {
    				candidate += rightHalf;
    			} else {
    				candidate += mid + rightHalf;
    			}
    			
    			if(candidate.compareTo(target) > 0) {
    				result = candidate;
    				return true;
    			}
    			
    			return false;
    		}
    		
    		for(char ch='a';ch <='z';ch++) {
    			if(count[ch - 'a'] == 0) {
    				continue;
    			}
    			
    			if(greater == false && ch < target.charAt(index)) {
    				continue;
    			}
    			
    			curr.append(ch);
    			count[ch - 'a']--;
    			
    			boolean isGreater = greater || ch > target.charAt(index);
    			
    			if(build(count, curr, index+1, target, isGreater)) {
    				return true;
    			}
    			
    			curr.deleteCharAt(index);
    			count[ch - 'a']++;
    		}
    		
    		return false;
    }    
}