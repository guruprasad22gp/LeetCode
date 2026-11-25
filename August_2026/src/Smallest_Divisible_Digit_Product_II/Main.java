package Smallest_Divisible_Digit_Product_II;

public class Main {
	public String smallestNumber(String num, long t) {
        int n = num.length();
        
        if(!tIsValidOrNot(t)) {
        	return "-1";
        }
        
        long[] remainingFactor = new long[n+1];
        remainingFactor[0] = t;
        for(int i=0;i<n;i++) {
        	int digit = num.charAt(i) - '0';
        	
        	if(digit == 0) {
        		break;
        	}
        	
        	remainingFactor[i+1] = remainingFactor[i]/gcd(remainingFactor[i], (long)digit);
        }
        
        if(remainingFactor[n] == 1) {
        	return num;
        }
        
        
        int zeroPos = num.indexOf('0');
        int startIndex = zeroPos == -1? n-1: zeroPos;
        
        for(int i=startIndex; i>=0;i--) {
        	
        	long required = remainingFactor[i];
        	int freeSlot = n - 1 - i;
        	
        	for(int digit = (num.charAt(i) - '0')+1; digit <= 9; digit+=1) {
        		long furtherRequired = required/gcd(required, (long)digit);
        		String requiredNum = formANumber(furtherRequired, freeSlot);
        		
        		if(requiredNum.length() == freeSlot) {
        			return num.substring(0, i) + digit + requiredNum;
        		}
        	}
        }
        
        return formANumber(t, n+1);
    }
	
	private boolean tIsValidOrNot(long num) {
		int primeNum[] = {2,3,5,7};
		for(int primeFactor: primeNum) {
			while(num % primeFactor == 0) {
				num /= primeFactor;
			}
		}
		
		return  num == 1;
	}
	
	private String formANumber(long num, int len) {
		StringBuilder sb = new StringBuilder();
		
		for(int digit=9;digit>=2;digit--) {
			while(num % digit == 0) {
				sb.append(digit);
				num /= digit;
			}
		}
		
		while(sb.length() < len) {
			sb.append(1);
		}
		
		sb.reverse();
		
		return sb.toString();
	}
	
	private long gcd(long a, long b) {
		while(b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		String num = "111111";
		long t = 26;
		
		System.out.println("Output: " + m.smallestNumber(num, t));
	}
}
