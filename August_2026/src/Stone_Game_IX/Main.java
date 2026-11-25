package Stone_Game_IX;

public class Main {
	public static void main(String[] args) {
		int[] arr = {5,1,2,4,3};
		Main m = new Main();
		
		System.out.println("Output: " + m.stoneGameIX(arr));
	}
	
	public boolean stoneGameIX(int[] stones) {
    
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		
		for(int ele: stones) {
			int rem = ele % 3;
			
			if(rem == 0) {
				count0++;
			} else if(rem == 1) {
				count1++;
			} else {
				count2++;
			}
		}
		
		if(count0 % 2 == 0) {
			return (count1 >= 1 && count2 >= 1) && (count1 >= count2 || count2 >= count1);
		} else {
			return Math.abs(count1 - count2) >= 3;
		}
    }
}
