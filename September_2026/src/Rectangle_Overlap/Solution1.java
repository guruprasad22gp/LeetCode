package Rectangle_Overlap;

public class Solution1 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    	int x1 = rec1[0];
    	int y1 = rec1[1];
    	int x2 = rec1[2];
    	int y2 = rec1[3];
    	int x3 = rec2[0];
    	int y3 = rec2[1];
    	int x4 = rec2[2];
    	int y4 = rec2[3];
    	
    	return x1 < x4 && x2 > x3 && y1 < y4 && y2 > y3;
    }
    public static void main(String[] args) {
    	int[] rec1 = {0,0,1,1};
    	int[] rec2 = {1,0,2,1};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.isRectangleOverlap(rec1, rec2));
	}
}
