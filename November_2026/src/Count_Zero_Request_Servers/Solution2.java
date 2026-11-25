package Count_Zero_Request_Servers;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
	public int[] countServers(int n, int[][] logs, int x, int[] queries) {
		Arrays.sort(logs, (a, b) -> {
			return Integer.compare(a[1], b[1]);
		});
		int m = logs.length;
		int q = queries.length;
		int[] result = new int[q];
		int[][] arr = new int[q][2];
		for (int i = 0; i < q; i++) {
			arr[i][0] = queries[i];
			arr[i][1] = i;
		}

		Arrays.sort(arr, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});

		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;

		for (int[] a : arr) {
			int start = a[0] - x;
			int end = a[0];
			int idx = a[1];

			while (j < m && logs[j][1] <= end) {
				map.put(logs[j][0], map.getOrDefault(logs[j][0], 0) + 1);
				j++;
			}

			while (i < m && logs[i][1] < start) {
				map.put(logs[i][0], map.getOrDefault(logs[i][0], 0) - 1);
				if (map.get(logs[i][0]) == 0) {
					map.remove(logs[i][0]);
				}
				i++;
			}

			result[idx] = n - map.size();
		}

		return result;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] logs = { { 1, 3 }, { 2, 6 }, { 1, 5 } };
		int x = 5;
		int[] queries = { 10, 11 };

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + Arrays.toString(sol1.countServers(n, logs, x, queries)));
	}
}
