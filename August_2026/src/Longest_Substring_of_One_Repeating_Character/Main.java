package Longest_Substring_of_One_Repeating_Character;

public class Main {
	public static void main(String[] args) {
		String s = "babacc";
		String queryCharacters = "bcb";
		int[] queryIndices = { 1, 3, 3 };

		Main m = new Main();
		int[] result = m.longestRepeating(s, queryCharacters, queryIndices);

		for (int ele : result) {
			System.out.print(ele + " ");
		}
	}

	public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
		int n = queryIndices.length;
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			int index = queryIndices[i];
			char ch = queryCharacters.charAt(i);

			char temp[] = s.toCharArray();
			temp[index] = ch;

			s = new String(temp);

			result[i] = longestRepeatedCharacters(s);

			System.out.println(ch + " - " + s);
		}

		return result;
	}

	public int longestRepeatedCharacters(String s) {
		int max = 0;
		int count = 0;
		char ch = s.charAt(0);
		for (int i = 0; i < s.length(); i++) {
			if (ch == s.charAt(i)) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 1;
				ch = s.charAt(i);
			}
		}

		return Math.max(max, count);
	}
}
