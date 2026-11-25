package Count_Zero_Request_Servers;

import java.util.Arrays;
import java.util.HashSet;

public class Solution1 {
	public int[] countServers(int n, int[][] logs, int x, int[] queries) {

		int[] res = new int[queries.length];
		int i = 0;
		for (int q : queries) {
			int left = q - x;
			int right = q;
			int server = countServer(logs, left, right);
			res[i++] = n - server;
		}

		return res;
	}

	private int countServer(int[][] logs, int low, int high) {
		int count = 0;

		HashSet<Integer> set = new HashSet<>();
		for (int[] x : logs) {
			if (low <= x[1] && x[1] <= high && !set.contains(x[0])) {
				count++;
				set.add(x[0]);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] logs = { { 1, 3 }, { 2, 6 }, { 1, 5 } };
		int x = 5;
		int[] queries = { 10, 11 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + Arrays.toString(sol1.countServers(n, logs, x, queries)));
	}
}
