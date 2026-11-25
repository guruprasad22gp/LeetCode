package Sum_Game;

public class Main {
	public static void main(String[] args) {
		String num = "250?";
		
		Main m = new Main();
		System.out.println("Output: " + m.sumGame(num));
	}
	
	public boolean sumGame(String num) {
		int n = num.length();
        int leftKnownSum = 0;
        int rightKNownSum = 0;
        int leftQnMarkCount = 0;
        int rightQnMarkCount = 0;
        
        for(int i=0;i<n;i++) {
        	if(num.charAt(i) == '?') {
        		if(i < n/2) {
        			leftQnMarkCount++;
        		} else {
        			rightQnMarkCount++;
        		}
        	} else {
        		if(i < n/2) {
        			leftKnownSum += num.charAt(i) - '0';
        		} else {
        			rightKNownSum += num.charAt(i) - '0';
        		}
        	}
        }
        
        if((leftQnMarkCount + rightQnMarkCount) % 2 == 1) {
        	return true;
        }
        
        int left = 2 * leftKnownSum + 9 * leftQnMarkCount;
        int right = 2 * rightKNownSum + 9 * rightQnMarkCount;
        
        if(left == right) {
        	return false;
        }
        
        return true;
        
    }
}
