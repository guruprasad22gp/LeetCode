package Distribute_Elements_Into_Two_Arrays_I;

import java.util.LinkedList;

public class Main {
	public int[] resultArray(int[] nums) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for(int i=2;i<nums.length;i++) {
        	if(list1.get(list1.size()-1) > list2.get(list2.size()-1)) {
        		list1.add(nums[i]);
        	} else {
        		list2.add(nums[i]);
        	}
        }
        
        int[] result = new int[nums.length];
        int i=0;
        for(int ele: list1) {
        	result[i] = ele;
        	i++;
        }
        
        for(int ele: list2) {
        	result[i] = ele;
        	i++;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		Main m = new Main();
		int[] arr = {2,1,3};
		int[] ans = m.resultArray(arr);
		for(int ele: ans) {
			System.out.print(ele + " ");
		}
	}
}
