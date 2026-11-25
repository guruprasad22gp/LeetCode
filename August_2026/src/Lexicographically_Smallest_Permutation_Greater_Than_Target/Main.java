package Lexicographically_Smallest_Permutation_Greater_Than_Target;

public class Main {
    public String lexGreaterPermutation(String s, String target) {
        int countS[] = new int[26];
        for(char ch: s.toCharArray()) {
        		countS[ch - 'a']++;
        }
        
        StringBuilder curr = new StringBuilder();
        int index = 0;
        boolean greater = false;
        
        boolean ans = solve(countS, curr, index, target, greater);
        
        return ans? result: "No answer";
    }
    
    String result = "";
    private boolean solve(int[] count, StringBuilder curr, int index, String target, boolean greater) {
    		if(index == target.length()) {
    			if(greater) {
    				result = curr.toString();
    				return true;
    			}
    			return false;
    		}
    		
    		for(char ch = 'a'; ch <= 'z'; ch++) {
    			if(count[ch - 'a'] == 0) {
    				continue;
    			}
    			
    			if(greater == false && ch < target.charAt(index)) {
    				continue;
    			}
//    			add to String
    			curr.append(ch);
    			count[ch - 'a']--;
    			
//    			explore
    			boolean isGreater = greater || (ch > target.charAt(index) ? true: false);
    			
    			if(solve(count, curr, index+1, target, isGreater)) {
    				return true;
    			}
    			
//    			Undo
    			curr.deleteCharAt(index );
    			count[ch - 'a']++;
    		}
    		
    		return false;
    }

    public static void main(String[] args) {
		Main m = new Main();
		String s = "code";
		String target = "leet";
		
		System.out.println("Output: " + m.lexGreaterPermutation(s, target));
	}
}
