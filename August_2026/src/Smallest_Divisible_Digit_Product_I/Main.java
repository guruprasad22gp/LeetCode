package Smallest_Divisible_Digit_Product_I;

public class Main {
    public int smallestNumber(int n, int t) {
    	while(true) {
    		if(solve(n, t)) {
    			return n;
    		}
    		
    		n++;
    	}
    }
    
    private boolean solve(int num, int t) {
    	int product = 1;
    	
    	while(num > 0) {
    		int temp = num % 10;
    		product *= temp;
    		num /= 10;
    	}
    	
    	return product % t == 0;
    }
    
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println("Output: " + m.smallestNumber(11, 3));
	}
}
