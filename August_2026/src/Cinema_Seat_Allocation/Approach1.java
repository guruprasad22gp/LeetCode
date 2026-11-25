package Cinema_Seat_Allocation;

import java.util.HashMap;
import java.util.Map;

public class Approach1 {
	public static void main(String[] args) {
		Approach1 m = new Approach1();
		int n = 4;
		int[][] arr = {
				{4,3},{1,4},{4,6},{1,7}
		};
		
		System.out.println(m.maxNumberOfFamilies(n, arr));
	}
	
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int[] x: reservedSeats) {
			int row = x[0];
			int seatNo = x[1];
			
			map.put(row, map.getOrDefault(row, 0) | (1 << seatNo));
		}
		
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		int maskA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
		int maskB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
		int maskC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
		
		int result = (n - map.size()) * 2;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int mask = entry.getValue();
			System.out.println(entry.getKey() + ": " + entry.getValue());
			
			boolean grpA = (mask & maskA) == 0;
			boolean grpB = (mask & maskB) == 0;
			boolean grpC = (mask & maskC) == 0;
			
			if(grpA && grpB) {
				result += 2;
			} else if(grpA || grpB || grpC) {
				result += 1;
			}
		}
		
		return result;
	}
}
