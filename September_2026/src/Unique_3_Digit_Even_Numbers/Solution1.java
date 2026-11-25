package Unique_3_Digit_Even_Numbers;

import java.util.HashSet;

public class Solution1 {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		for(int k=0;k<n;k++) {
        			if(i == j || i == k || j == k || digits[i] == 0 || digits[k] % 2 != 0) {
        				continue;
        			}
        			int num = digits[i] * 100 + digits[j] * 10 + digits[k];
        			
        			if(!set.contains(num)) {
        				set.add(num);
        			}
        		} 
        	}
        }
        
        return set.size();
    }

    public static void main(String[] args) {
		int[] digits = {0,2,4};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.totalNumbers(digits));
	}
}
