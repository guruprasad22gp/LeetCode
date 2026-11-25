package Count_Commas_in_Range_II;

public class Solution1 {
    public long countCommas(long n) {
    	 long lower = 1000;
    	 long result = 0;
    	 long commas = 1;
    	 
    	 
    	 while(lower <= n) {
    		 long upper = (lower * 1000) - 1;
    		 if(upper > n) {
    			 upper = n; 
    		 }
    		 long count = upper - lower + 1;
    		 result += (count * commas);
    		 commas++;
    		 lower *= 1000;
    	 }
    	 
    	 return result;
    }
    
    public static void main(String[] args) {
		Solution1 sol1 = new Solution1();
		long n = 1004590;
		System.out.println("Output: " + sol1.countCommas(n));
	}
}
