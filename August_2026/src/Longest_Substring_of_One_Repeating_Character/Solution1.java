package Longest_Substring_of_One_Repeating_Character;

class Node {
	int maxLen;
	char rightChar;
	char leftChar;
	int preLen;
	int suffLen;

	Node() {
		maxLen = 0;
		rightChar = 0;
		leftChar = 0;
		preLen = 0;
		suffLen = 0;
	}

	Node(int maxLen, char rightChar, char leftChar, int preLen, int suffLen) {
		this.maxLen = maxLen;
		this.rightChar = rightChar;
		this.leftChar = leftChar;
		this.preLen = preLen;
		this.suffLen = suffLen;
	}
}

class ST {
	int n;
	Node[] segmentTree;

	ST(String s) {
		this.n = s.length();
		segmentTree = new Node[4 * n];
		buildST(0, 0, n - 1, s);
	}

	void buildST(int node, int start, int end, String s) {
		if (start == end) {
			segmentTree[node] = new Node(1, s.charAt(start), s.charAt(end), 1, 1);
			return;
		}

		int mid = start + (end - start) / 2;
		buildST(2 * node + 1, start, mid, s);
		buildST(2 * node + 2, mid + 1, end, s);
		segmentTree[node] = merge(segmentTree[2 * node + 1], segmentTree[2 * node + 2], mid - start + 1, end - mid);
	}

	Node merge(Node left, Node right, int leftLen, int rightLen) {
		Node result = new Node();

		result.leftChar = left.leftChar;
		result.rightChar = right.rightChar;

		result.preLen = left.preLen;
		if (left.preLen == leftLen && left.rightChar == right.leftChar) {
			result.preLen = left.preLen + right.preLen;
		}

		result.suffLen = right.suffLen;
		if (rightLen == right.suffLen && right.leftChar == left.rightChar) {
			result.suffLen = right.suffLen + left.suffLen;
		}

		result.maxLen = Math.max(left.maxLen, right.maxLen);
		if (left.rightChar == right.leftChar) {
			result.maxLen = Math.max(result.maxLen, left.suffLen + right.preLen);
		}

		return result;
	}

	void update(int node, int start, int end, int pos, char ch) {
		if (start == end) {
			segmentTree[node] = new Node(1, ch, ch, 1, 1);
			return;
		}

		int mid = start + (end - start) / 2;
		if (pos <= mid) {
			update(2 * node + 1, start, mid, pos, ch);
		} else {
			update(2 * node + 2, mid + 1, end, pos, ch);
		}

		segmentTree[node] = merge(segmentTree[2 * node + 1], segmentTree[2 * node + 2], mid - start + 1, end - mid);
	}

	int query() {
		return segmentTree[0].maxLen;
	}
}

public class Solution1 {
	public static void main(String[] args) {
		String s = "abyzz";
		String queryCharacters = "aa";
		int[] queryIndices = { 2, 1 };

		Solution1 m = new Solution1();
		int[] result = m.longestRepeating(s, queryCharacters, queryIndices);

		for (int ele : result) {
			System.out.print(ele + " ");
		}
	}

	public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
		int n = queryCharacters.length();
		int[] result = new int[n];

		ST st = new ST(s);

		for (int i = 0; i < n; i++) {
			int pos = queryIndices[i];
			char ch = queryCharacters.charAt(i);

			st.update(0, 0, s.length() - 1, pos, ch);

			result[i] = st.query();
		}

		return result;
	}
}