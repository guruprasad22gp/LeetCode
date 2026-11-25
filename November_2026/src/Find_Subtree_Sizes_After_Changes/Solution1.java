package Find_Subtree_Sizes_After_Changes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	int n;
	List<List<Integer>> adj;
	int[] res;
	int[] lastSeenNode;

	public int[] findSubtreeSizes(int[] parent, String s) {
		n = parent.length;
		adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			int u = i;
			int v = parent[i];
			adj.get(v).add(u);
		}

		lastSeenNode = new int[26];
		Arrays.fill(lastSeenNode, -1);
		res = new int[n];
		Arrays.fill(res, 1);

		DFS(0, s, parent);

		return res;
	}

	void DFS(int source, String s, int[] parent) {
		int index = s.charAt(source) - 'a';
		int nearestAncestor = lastSeenNode[index];
		lastSeenNode[index] = source;
		for (int child : adj.get(source)) {
			DFS(child, s, parent);
		}

		lastSeenNode[index] = nearestAncestor;
		if (source != 0) {
			int newParent = parent[source];
			if (nearestAncestor != -1) {
				newParent = nearestAncestor;
			}

			parent[source] = newParent;

			res[newParent] += res[source];
		}
	}

	public static void main(String[] args) {
		int[] parent = { -1, 0, 0, 1, 1, 1 };
		String s = "abaabc";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + Arrays.toString(sol1.findSubtreeSizes(parent, s)));
	}
}