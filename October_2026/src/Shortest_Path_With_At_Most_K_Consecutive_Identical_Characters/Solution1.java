package Shortest_Path_With_At_Most_K_Consecutive_Identical_Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {
	public int shortestPath(int n, int[][] edges, String labels, int k) {
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] x : edges) {
			int u = x[0];
			int v = x[1];
			int w = x[2];

			adj.get(u).add(new int[] { v, w });
		}

		int[][] distance = new int[n][k + 1];
		for (int[] x : distance) {
			Arrays.fill(x, Integer.MAX_VALUE);
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[1], b[1]);
		});

		distance[0][1] = 0;
		queue.add(new int[] { 0, 0, 1 });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int node = temp[0];
			int weight = temp[1];
			int count = temp[2];

			if (weight > distance[node][count]) {
				continue;
			}

			if (node == n - 1) {
				return weight;
			}

			for (int[] next : adj.get(node)) {
				int nextNode = next[0];
				int nextWeight = next[1];

				int newCount = (labels.charAt(node) == labels.charAt(nextNode)) ? count + 1 : 1;
				if (newCount > k) {
					continue;
				}
				int newDist = weight + nextWeight;

				if (newDist < distance[nextNode][newCount]) {
					distance[nextNode][newCount] = newDist;
					queue.add(new int[] { nextNode, newDist, newCount });
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] edges = { { 0, 1, 1 }, { 1, 2, 1 }, { 0, 2, 3 } };
		String labels = "aab";
		int k = 1;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.shortestPath(n, edges, labels, k));
	}
}