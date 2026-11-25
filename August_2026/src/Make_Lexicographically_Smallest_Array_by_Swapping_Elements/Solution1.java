package Make_Lexicographically_Smallest_Array_by_Swapping_Elements;

public class Solution1 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n =  nums.length;
        for(int i=0;i<n;i++) {
        		for(int j=i;j<n;j++) {
        			int diff = nums[i] - nums[j];   			
        			if(diff <= limit && diff > 0) {
        				int temp = nums[i];
        				nums[i] = nums[j];
        				nums[j] = temp;
        				j = i;
        			}
        		}
        }
        return nums;
    }
    
    public static void main(String[] args) {
    		int[] nums = {1, 5, 3, 9, 8};
    		int limit = 2;
    		
    		for(int ele: nums) {
    			System.out.print(ele + " ");
    		}
    		System.out.println();
    		
    		Solution1 sol1 = new Solution1();
    		nums = sol1.lexicographicallySmallestArray(nums, limit);
    		
    		for(int ele: nums) {
    			System.out.print(ele + " ");
    		}
	}
}
