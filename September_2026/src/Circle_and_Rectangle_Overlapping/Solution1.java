package Circle_and_Rectangle_Overlapping;

public class Solution1 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xi;
        int yi;
        
        if(x1 > xCenter) {
        	xi = x1;
        } else if(x2 < xCenter) {
        	xi = x2;
        } else {
        	xi = xCenter;
        }
        
        
        if(y1 > yCenter) {
        	yi = y1;
        } else if(y2 < yCenter) {
        	yi = y2;
        } else {
        	yi = yCenter;
        }
        
        int d = (int) Math.sqrt((xi - xCenter) * (xi - xCenter) + (yi - yCenter) * (yi - yCenter));
        
        return d <= radius;
    }
    
    public static void main(String[] args) {
    	int radius = 1;
    	
    	int xCenter = 0;
    	int yCenter = 0;
    	int x1 = 1;
    	int y1 = -1;
    	int x2 = 3;
    	int y2 = 1;
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
	}
}
