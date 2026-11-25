package Count_Commas_in_Range_II;

public class Solution2 {
    public long countCommas(long n) {
    	 long start = 1000;
    	 long result = 0;
    	 
    	 while(start <= n) {
    		 long count = n - start + 1;
    		 result += count;
    		 start *= 1000;
    	 }
    	 
    	 return result;
    }
    
    public static void main(String[] args) {
		Solution2 sol2 = new Solution2();
		long n = 1000000;
		System.out.println("Output: " + sol2.countCommas(n));
	}
}
