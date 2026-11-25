package Count_Commas_in_Range;

public class Solution1 {
    public int countCommas(int n) {
    	if(n < 1000) {
    		return 0;
    	}
    	
    	return n - 999;
    }

    public static void main(String[] args) {
		int n =1000;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countCommas(n));
	}
}
