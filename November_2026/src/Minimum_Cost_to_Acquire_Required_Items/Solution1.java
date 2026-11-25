package Minimum_Cost_to_Acquire_Required_Items;

public class Solution1 {
	public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
		long max = Math.max(need1, need2);
		long min = Math.min(need1, need2);
		long type1 = max * costBoth;
		long type2 = (long) need1 * cost1 + (long) need2 * cost2;
		long type3 = min * costBoth + ((max == need1) ? cost1 : cost2) * (max - min);
		return Math.min(type1, Math.min(type2, type3));
	}

	public static void main(String[] args) {
		int cost1 = 5, cost2 = 4, costBoth = 15, need1 = 0, need2 = 0;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumCost(cost1, cost2, costBoth, need1, need2));
	}
}