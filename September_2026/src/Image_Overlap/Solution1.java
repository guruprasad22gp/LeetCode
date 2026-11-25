package Image_Overlap;

public class Solution1 {
    public int largestOverlap(int[][] img1, int[][] img2) {
    	int n = img1.length;
    	
    	int maxOverlap = 0;
    	
    	for(int rowOff = -n + 1; rowOff < n; rowOff++) {
    		for(int colOff = - n + 1; colOff < n; colOff++) {
    			int count = countOverlaps(img1, img2, rowOff, colOff);
    			
    			maxOverlap = Math.max(maxOverlap, count);
    		}
    	}
    	
    	return maxOverlap;
    }
    
    private int countOverlaps(int[][] a, int[][] b, int rowOff, int colOff) {
    	int count = 0;
    	for(int i=0;i<a.length;i++) {
    		for(int j=0;j<b.length;j++) {
    			int B_i = i + rowOff;
    			int B_j = j + colOff;
    			
    			if(B_i < 0 || B_j < 0 || B_i >= a.length || B_j >= b.length) {
    				continue;
    			}
    			
    			if(a[i][j] == 1 && b[B_i][B_j] == 1) {
    				count++;
    			}
    		}
    	}
    	
    	return count;
    }
    
    public static void main(String[] args) {
    	int[][] img1 = {
    			{1, 1, 0},
    			{0, 1, 0},
    			{0, 1, 0}
    	};
    	
    	int[][] img2 = {
    			{0, 0, 0},
    			{0, 1, 1},
    			{0, 0, 1}
    	};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.largestOverlap(img1, img2));
	}
}
