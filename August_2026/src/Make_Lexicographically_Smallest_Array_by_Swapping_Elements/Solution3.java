package Make_Lexicographically_Smallest_Array_by_Swapping_Elements;

import java.util.Arrays;

public class Solution3 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Pair each element with its original index: arr[i][0] = value, arr[i][1] = index
        int[][] arr = new int[n][2]; 
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        // Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[n];
        int i = 0;
        
        while (i < n) {
            int j = i;
            // Find the end of the current limit group
            while (j < n && (j == i || arr[j][0] - arr[j - 1][0] <= limit)) {
                j++;
            }
            
            // Collect and sort the original indices for this group
            int[] indices = new int[j - i];
            for (int k = i; k < j; k++) {
                indices[k - i] = arr[k][1];
            }
            
            Arrays.sort(indices);
            
            // Assign sorted values to sorted original positions
            for (int k = 0; k < indices.length; k++) {
                ans[indices[k]] = arr[i + k][0];
            }
            
            i = j;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 9, 8};
        int limit = 2;
        
        for(int ele: nums) {
            System.out.print(ele + " ");
        }
        System.out.println();
        
        Solution3 sol3 = new Solution3();
        nums = sol3.lexicographicallySmallestArray(nums, limit);
        
        for(int ele: nums) {
            System.out.print(ele + " ");
        }
    }
}
