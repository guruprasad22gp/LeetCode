package Brace_Expansion_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
	String s;
	int n;
	int idx;

	public List<String> braceExpansionII(String expression) {
		n = expression.length();
		s = expression;
		idx = 0;

		Set<String> st = performUnion();
		List<String> result = new ArrayList<>();
		result.addAll(st);
		result.sort((a, b) -> {
			return a.compareTo(b);
		});
		return result;
	}

	private Set<String> performUnion() {
		Set<String> result = new HashSet<>();

		while (true) {
			Set<String> temp = performConcat();
			result.addAll(temp);
			if (idx < n && s.charAt(idx) == ',') {
				idx++;
			} else {
				break;
			}
		}

		return result;
	}

	private Set<String> performConcat() {
		Set<String> result = new HashSet<>();
		result.add("");

		while (idx < n && (s.charAt(idx) == '{' || Character.isAlphabetic(s.charAt(idx)))) {
			Set<String> temp = getUnit();

			Set<String> conRes = new HashSet<>();
			for (String r : result) {
				for (String l : temp) {
					conRes.add(r + l);
				}
			}

			result = conRes;
		}

		return result;
	}

	private Set<String> getUnit() {
		Set<String> result = new HashSet<>();

		if (s.charAt(idx) == '{') {
			idx++;
			result = performUnion();
		} else {
			result.add(String.valueOf(s.charAt(idx)));
		}
		idx++;
		return result;
	}

	public static void main(String[] args) {
		String expression = "{a,b}{c,{d,e}}";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.braceExpansionII(expression));

	}
}