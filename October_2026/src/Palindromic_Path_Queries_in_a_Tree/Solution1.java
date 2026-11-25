package Palindromic_Path_Queries_in_a_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SegmentTree {
	int n;
	int[] tree;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		build(0, 0, n - 1, arr);
	}

	void build(int i, int start, int end, int[] arr) {
		if (start == end) {
			tree[i] = arr[start];
			return;
		}
		int mid = start + (end - start) / 2;
		build(2 * i + 1, start, mid, arr);
		build(2 * i + 2, mid + 1, end, arr);
		tree[i] = tree[2 * i + 1] ^ tree[2 * i + 2];
	}

	void update(int index, int val) {
		update(0, 0, n - 1, index, val);
	}

	private void update(int i, int start, int end, int index, int val) {
		if (start == end) {
			tree[i] = val;
			return;
		}

		int mid = start + (end - start) / 2;
		if (index <= mid) {
			update(2 * i + 1, start, mid, index, val);
		} else {
			update(2 * i + 2, mid + 1, end, index, val);
		}

		tree[i] = tree[2 * i + 1] ^ tree[2 * i + 2];
	}

	int query(int u, int v) {
		return query(0, 0, n - 1, u, v);
	}

	private int query(int i, int start, int end, int u, int v) {
		if (v < start || u > end) {
			return 0;
		}

		if (u <= start && v >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		return query(2 * i + 1, start, mid, u, v) ^ query(2 * i + 2, mid + 1, end, u, v);
	}
}

public class Solution1 {
	int n;
	List<List<Integer>> adj;

	int[] tin;
	int[] tout;
	int[] eulerTour;
	int time;

	int[][] parent;
	int col;
	int[] depths;

	public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
		this.n = n;
//		Adjacency list for graph;
		adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] x : edges) {
			int u = x[0];
			int v = x[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		tin = new int[n];
		tout = new int[n];
		eulerTour = new int[n + n];
		time = 0;
		col = 32 - Integer.numberOfLeadingZeros(n);
		parent = new int[n][col];
		for (int[] x : parent) {
			Arrays.fill(x, -1);
		}
		depths = new int[n];

		DFS(0, -1, 0, s);
		buildAncestor();

//		build segment tree
		SegmentTree st = new SegmentTree(eulerTour);

		List<Boolean> result = new ArrayList<>();
		for (String x : queries) {
			String[] arr = x.split(" ");
			String statement = arr[0];
			if (statement.equals("query")) {
				int u = Integer.parseInt(arr[1]);
				int v = Integer.parseInt(arr[2]);

				int LCA = getLCA(u, v);
				char ch = s.charAt(LCA);
				int charValue = 1 << (ch - 'a');
				int mask = st.query(0, tin[u]) ^ st.query(0, tin[v]) ^ charValue;

				System.out.println(mask);
				result.add((mask & (mask - 1)) == 0);

			} else {
				int index = Integer.parseInt(arr[1]);
				char ch = arr[2].charAt(0);

				int val = 1 << (ch - 'a');

//				update the String at index value char ch
				StringBuilder sb = new StringBuilder(s);
				sb.setCharAt(index, ch);
				s = sb.toString();

				st.update(tin[index], val);
				st.update(tout[index], val);
			}
		}

		return result;

	}

	void DFS(int source, int par, int depth, String s) {
		depths[source] = depth;
		parent[source][0] = par;
		tin[source] = time;
		eulerTour[time] = 1 << (s.charAt(source) - 'a');
		time++;

		for (int v : adj.get(source)) {
			if (v == par) {
				continue;
			}

			DFS(v, source, depth + 1, s);
		}

		tout[source] = time;
		eulerTour[time] = 1 << (s.charAt(source) - 'a');
		time++;
	}

	void buildAncestor() {
		for (int j = 1; j < col; j++) {
			for (int node = 0; node < n; node++) {
				if (parent[node][j - 1] != -1) {
					parent[node][j] = parent[parent[node][j - 1]][j - 1];
				}
			}
		}
	}

	int getLCA(int u, int v) {
		if (depths[u] != depths[v]) {
			if (depths[u] > depths[v]) {
				u = getAncestor(u, depths[u] - depths[v]);
			} else {
				v = getAncestor(v, depths[v] - depths[u]);
			}
		}

		if (u == v) {
			return u;
		}

		for (int j = col - 1; j >= 0; j--) {
			if (parent[u][j] == -1) {
				continue;
			}

			if (parent[u][j] != parent[v][j]) {
				u = parent[u][j];
				v = parent[v][j];
			}
		}

		return parent[u][0];
	}

	int getAncestor(int node, int k) {
		for (int j = 0; j < col; j++) {
			if ((k & (1 << j)) != 0) {
				node = parent[node][j];
				if (node == -1) {
					return -1;
				}
			}
		}

		return node;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 } };
		String s = "aac";
		String[] queries = { "query 0 2", "update 1 b", "query 0 2 " };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.palindromePath(n, edges, s, queries));
	}
}