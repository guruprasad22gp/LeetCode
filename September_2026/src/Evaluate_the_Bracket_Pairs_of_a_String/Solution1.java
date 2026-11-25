package Evaluate_the_Bracket_Pairs_of_a_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		String s = "(name)is(age)yearsold";
		List<List<String>> knowledge = Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"));

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.evaluate(s, knowledge));
	}

	public String evaluate(String s, List<List<String>> knowledge) {
		HashMap<String, String> map = new HashMap<>();
		for (List<String> ls : knowledge) {
			map.put(ls.get(0), ls.get(1));
		}

		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				int j = i + 1;
				while (j < s.length() && s.charAt(j) != ')') {
					j++;
				}

				String sub = s.substring(i + 1, j);
				result.append(map.getOrDefault(sub, "?"));
				i = j + 1;
			} else {
				result.append(s.charAt(i));
				i++;
			}
		}

		return result.toString();
	}
}
