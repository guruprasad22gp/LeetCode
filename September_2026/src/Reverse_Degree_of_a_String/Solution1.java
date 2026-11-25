package Reverse_Degree_of_a_String;

public class Solution1 {
    public int reverseDegree(String s) {
        int total = 0;
        
        int i = 1;
        for(char ch: s.toCharArray()) {
        	int idx = 'z' - ch + 1;
        	total += i * idx;
        	i++;
        }
        
        return total;
        
    }
    
    public static void main(String[] args) {
		String s = "abc";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.reverseDegree(s));
	}
}
