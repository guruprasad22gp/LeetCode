package Smallest_Missing_Multiple_of_K;

import java.util.HashSet;

public class Main {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) {
        	set.add(ele);
        }
        
        int i=1;
        int num = i * k;
        while(set.contains(num)) {
        	i++;
        	num = i * k;
        }
        
        return num;
    }
    
    public static void main(String[] args) {
    	int[] nums = {2,3,4,6,8,5};
    	int k = 5;
    	
    	Main m = new Main();
    	System.out.println("Output: " + m.missingMultiple(nums, k));
	}
}
