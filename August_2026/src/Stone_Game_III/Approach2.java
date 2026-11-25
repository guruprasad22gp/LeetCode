package Stone_Game_III;

public class Approach2 {
	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i=n-1;i>=0;i--) {
			int result = Integer.MIN_VALUE;
			
			result = Math.max(stoneValue[i] - a, result);
			
			if(i+1 < n) {
				result = Math.max(result, stoneValue[i] + stoneValue[i+1] - b);
			}
			
			if(i+2 < n) {
				result = Math.max(result, stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - c);
			}
			
			c = b;
			b = a;
			a = result;
		}
		
		if(a < 0) {
			return "Bob";
		} else if(a > 0) {
			return "Alice";
		} else {
			return "Tie";
		}
    }
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,6};
		Main m = new Main();
		
		System.out.println("Output: " + m.stoneGameIII(arr));
	}
}
