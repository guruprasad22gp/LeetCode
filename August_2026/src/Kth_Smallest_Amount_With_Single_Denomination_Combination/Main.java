package Kth_Smallest_Amount_With_Single_Denomination_Combination;

public class Main {
	public static void main(String[] args) {
		int[] coins = {6,5};
		int k = 1435065516;
		
		Main m = new Main();
		System.out.println("output: " + m.findKthSmallest(coins, k));
	}
	
	private long GCD(long a, long b) {
		while(b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		
		return a;
	}
	
	private long countSmaller(long mid, int[] coins) {
		long correctedCount = 0;
		
		int n = coins.length;
		
		for(int expressions = 1; expressions <= (1 << n)-1; expressions++) { // 2^n-1
			long LCM = 0;
			long order = 0; // even or odd order or expressions
			
			for(int i=0;i<n;i++) {
				if((expressions & (1 << i)) != 0) {
					order++; // we have taken ith coins
					
					if(LCM == 0) {
						LCM = coins[i];
					} else {
						LCM = (LCM * coins[i])/GCD(LCM, coins[i]);
					}
				}
			}
			
			if(order % 2 == 0) {
				correctedCount -= mid/LCM;
			} else {
				correctedCount += mid/LCM;
			}
		}
		
		return correctedCount;
	}
	
	public long findKthSmallest(int[] coins, int k) {
		
//		maximum element from coins
		int max = 0;
		for(int ele: coins) {
			max = Math.max(ele, max);
		}
		
		long result = -1;
		long left = 1;
		long right =(long) max * k;
		
//		Binary search
		while(left <= right) {
			long mid = left + (right - left)/2;
			
			if(countSmaller(mid, coins) >= k) {
				result = mid;
				right = mid -1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
    }
}
