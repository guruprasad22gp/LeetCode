package Find_the_Largest_Almost_Missing_Integer;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int nums[] = {1,2,3,4,5,1,2,4,1,3,5};
		int k = 5;
		
		System.out.println("Output: " + m.largestInteger(nums, k));
	}
	
    public int largestInteger(int[] nums, int k) {
    	int n = nums.length;
    	int[] count = new int[51];
    	
    	for(int i=0;i<=n-k;i++) {
    		boolean[] seen = new boolean[51];
    		
    		for(int j=i;j<i+k;j++) {
    			if(!seen[nums[j]]) {
    				seen[nums[j]] = true;
    				count[nums[j]]++;
    			}
    		}
    	}
    	
    	int ans = -1;
    	
    	for(int i=0;i<count.length;i++) {
    		if(count[i] == 1) {
    			ans = i;
    		}
    	}
    	
    	return ans;
    }
}
