package Find_Target_Indices_After_Sorting_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	public List<Integer> targetIndices(int[] nums, int target) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int ele = nums[i];
			if (ele == target) {
				result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 5, 2, 3 };
		int target = 2;
		Solution1 sol1 = new Solution1();
		System.out.println("Output :" + sol1.targetIndices(nums, target));
	}
}
