package Check_Divisibility_by_Digit_Sum_and_Product;

public class Main {
	public static void main(String[] args) {
		int n = 99;
		Main m = new Main();
		
		System.out.println("output: " + m.checkDivisibility(n));
	}
	
    public boolean checkDivisibility(int n) {
    	int t = n;
    	int product = 1;
    	int sum = 0;
    	
    	while(t > 0) {
    		int temp = t % 10;
    		product *= temp;
    		sum += temp;
    		t /= 10;
    	}
    	
    	return t % (product + sum) == 0;
    }
}
