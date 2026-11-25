package Find_the_Lexicographically_Smallest_Valid_Sequence;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		String word1 = "bacdc";
		String qord2 = "abc";
		int[] ans = m.validSequence(word1, qord2);
		for(int ele: ans) {
			System.out.print(ele + " ");
		}
	}
	
    public int[] validSequence(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
        int[] rightHandSideMatchedLength = new int[m];
        
        int matchCount = 0;
        int j = n-1;
        for(int i=m-1;i>=0;i--) {
        	if(j > 0 && word1.charAt(i) == word2.charAt(j)) {
        		matchCount++;
        		j--;
        	}
        	
        	rightHandSideMatchedLength[i] = matchCount;
        }
        
        int[] ans = new int[n];
        j = 0;
        int i = 0;
        boolean canChange = true;
        while(i < m &&  j < n) {
        	if(word1.charAt(i) == word2.charAt(j)) {
        		ans[j] = i;
        		j++;
        	} else if(canChange == true && i+1 < m && rightHandSideMatchedLength[i+1] >= n-j-1) {
        		ans[j] = i;
        		j++;
        		canChange = false;
        	}
        	i++;
        }
        
        if(j != n) {
        	return new int[] {};
        }
        return ans;
    }
}
