package Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum;

import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int[] arr = {1, 2, 3, 2, 5};
		System.out.println("Output: " + m.missingInteger(arr));
	}
	
	public int missingInteger(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int ele: nums) {
			set.add(ele);
		}
		
		int num = nums[0];
		int sum = 0;
		
		for(int ele: nums) {
			if(ele == num) {
				num++;
				sum += ele;
			} else {
				break;
			}
		}
		
		while(true) {
			if(set.contains(sum)) {
				sum++;
			} else {
				break;
			}
		}
		
		return sum;
    }
}
