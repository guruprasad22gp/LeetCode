package Construct_Uniform_Parity_Array_I;

public class Main {
	public static void main(String[] args) {
		int[] nums = {2, 3};
		
		Main m = new Main();
		System.out.println("Output: " + m.uniformArray(nums));
		System.out.println("Output: " + m.uniformArray1(nums));
	}
	
	public boolean uniformArray1(int[] nums) {
		return true;
	}
	
    public boolean uniformArray(int[] nums1) {
    	int n = nums1.length;
    	int oddCount = 0;
		int evenCount = 0;
		
		for(int ele: nums1) {
			if(ele % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}
		
		if(oddCount == n || evenCount == n) {
			return true;
		}
		
		
		int[] result = new int[n];
		for(int i=0;i<n;i++) {
			if(nums1[i] % 2 == 1) {
				result[i] = nums1[i];
			} else {
				for(int j=0;j<n-1;j++) {
					if((Math.abs(nums1[j] - nums1[j+1])) % 2 == 1) {
						result[j] = Math.abs(nums1[j] - nums1[j+1]);
						break;
					}
				}
			}
		}
		
		for(int ele: result) {
			if(ele % 2 != 1) {
				return false;
			}
		}
		
		return true;
    }
}
