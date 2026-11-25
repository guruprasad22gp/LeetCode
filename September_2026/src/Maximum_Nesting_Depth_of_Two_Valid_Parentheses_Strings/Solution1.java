package Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings;

public class Solution1 {
	public int[] maxDepthAfterSplit(String seq) {
		int n = seq.length();
		int[] res = new int[n];
		int depth = 0;
		for (int i = 0; i < n; i++) {
			if (seq.charAt(i) == '(') {
				depth++;
				res[i] = depth % 2;
			} else {
				res[i] = depth % 2;
				depth--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String seq = "()(())()";
		Solution1 sol1 = new Solution1();
		int[] res = sol1.maxDepthAfterSplit(seq);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}
