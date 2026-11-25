package Find_X_Value_of_Array_II;

import java.util.Arrays;

class Node {
	int[] count;
	int product;

	Node(int k) {
		count = new int[k];
		product = 1;
	}

	Node(int[] count, int product) {
		this.count = count;
		this.product = product;
	}
}

class SegmentTree {
	int n;
	int k;
	Node[] st;

	SegmentTree(int[] arr, int k) {
		this.k = k;
		n = arr.length;
		st = new Node[4 * n];
		buildST(0, 0, n - 1, arr);
	}

	void buildST(int node, int start, int end, int[] arr) {
		if (start == end) {
			st[node] = new Node(k);
			makeLeafNode(node, arr[start]);
			return;
		}

		int mid = start + (end - start) / 2;
		buildST(2 * node + 1, start, mid, arr);
		buildST(2 * node + 2, mid + 1, end, arr);

		st[node] = merge(st[2 * node + 1], st[2 * node + 2]);
	}

	void makeLeafNode(int node, int val) {
		Arrays.fill(st[node].count, 0);

		int rem = val % k;
		st[node].count[rem] = 1;
		st[node].product = rem;
	}

	Node merge(Node left, Node right) {
		Node result = new Node(k);

		result.product = (left.product * right.product) % k;

		for (int x = 0; x < k; x++) {
			result.count[x] = left.count[x];
		}

		for (int x = 0; x < k; x++) {
			int newRem = (left.product * x) % k;
			result.count[newRem] += right.count[x];
		}

		return result;
	}

	void update(int index, int val) {
		segTreeUpdate(0, 0, n - 1, index, val);
	}

	private void segTreeUpdate(int node, int start, int end, int index, int val) {
		if (start == end) {
			makeLeafNode(node, val);
			return;
		}

		int mid = start + (end - start) / 2;
		if (index <= mid) {
			segTreeUpdate(2 * node + 1, start, mid, index, val);
		} else {
			segTreeUpdate(2 * node + 2, mid + 1, end, index, val);
		}

		st[node] = merge(st[2 * node + 1], st[2 * node + 2]);
	}

	Node query(int left, int right) {
		return segTreeQuery(0, 0, n - 1, left, right);
	}

	private Node segTreeQuery(int node, int start, int end, int left, int right) {
		if (left <= start && right >= end) {
			return st[node];
		}

		if (right < start || left > end) {
			return new Node(k);
		}

		int mid = start + (end - start) / 2;

		if (right <= mid) {
			return segTreeQuery(2 * node + 1, start, mid, left, right);
		} else if (left > mid) {
			return segTreeQuery(2 * node + 2, mid + 1, end, left, right);
		} else {
			Node leftS = segTreeQuery(2 * node + 1, start, mid, left, right);
			Node rightS = segTreeQuery(2 * node + 2, mid + 1, end, left, right);

			return merge(leftS, rightS);
		}
	}
}

public class Solution1 {
	public int[] resultArray(int[] nums, int k, int[][] queries) {
		int n = queries.length;
		int[] result = new int[n];

		SegmentTree st = new SegmentTree(nums, k);

		for (int i = 0; i < n; i++) {
			int index = queries[i][0];
			int val = queries[i][1];
			int start = queries[i][2];
			int x = queries[i][3];

			st.update(index, val);

			Node resultNode = st.query(start, nums.length - 1);

			result[i] = resultNode.count[x];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 10 };
		int k = 1;
		int[][] queries = { { 0, 6, 1, 0 } };

		Solution1 sol1 = new Solution1();
		int[] result = sol1.resultArray(nums, k, queries);

		for (int ele : result) {
			System.out.print(ele + " ");
		}

	}
}