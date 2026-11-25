package Find_Missing_Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public List<Integer> findMissingElements(int[] nums) {
    	Arrays.sort(nums);
    	int n = nums.length;
    	
    	HashSet<Integer> set = new HashSet<>();
    	for(int ele: nums) {
    		set.add(ele);
    	}
    	
    	int start = nums[0];
    	int end = nums[n-1];
    	
    	List<Integer> ans = new ArrayList<>();
    	for(int i=start;i<=end;i++) {
    		if(set.contains(i)) {
    			continue;
    		}
    		
    		ans.add(i);
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,4,5,7};
		
		Main m = new Main();
		List<Integer> ans = m.findMissingElements(arr);
		
		System.out.println(ans);
	}
}
