package Make_Lexicographically_Smallest_Array_by_Swapping_Elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // create duplicate array and copy nums, then sort it
        int[] arr = nums.clone();
        Arrays.sort(arr);
        
        int groupNum = 0;
        HashMap<Integer, Integer> elementToGroup = new HashMap<>();
        elementToGroup.put(arr[0], groupNum);
        
        HashMap<Integer, List<Integer>> groupToList = new HashMap<>();
        groupToList.putIfAbsent(groupNum, new LinkedList<>());
        groupToList.get(groupNum).add(arr[0]);
        
        // Use the sorted array `arr` to define groups based on limit
        for(int i = 1; i < n; i++) {
            if(Math.abs(arr[i] - arr[i-1]) > limit) {
                groupNum += 1;
            }
            
            groupToList.putIfAbsent(groupNum, new LinkedList<>());
            groupToList.get(groupNum).add(arr[i]);
            
            elementToGroup.put(arr[i], groupNum);
        }
        
        // Build the answer using the original positions from `nums`
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int group = elementToGroup.get(num);
            
            // Assign the smallest available number from that specific group
            nums[i] = groupToList.get(group).getFirst();
            groupToList.get(group).removeFirst();
        }
        
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 2, 7, 3, 8, 4, 9, 6, 3};
        int limit = 1;
        
        for(int ele: nums) {
            System.out.print(ele + " ");
        }
        System.out.println();
        
        Solution2 sol2 = new Solution2();
        nums = sol2.lexicographicallySmallestArray(nums, limit);
        
        for(int ele: nums) {
            System.out.print(ele + " ");
        }
    }
}