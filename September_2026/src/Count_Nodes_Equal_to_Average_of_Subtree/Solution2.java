package Count_Nodes_Equal_to_Average_of_Subtree;

class Pair {
	int sum;
	int count;
	
	Pair(int sum, int count) {
		this.sum = sum;
		this.count = count;
	}
}

public class Solution2 {
	int result;
    public int averageOfSubtree(Tree root) {
    	 result = 0;
    	 postOrder(root);
    	 
    	 return result;
    }
    
    private Pair postOrder(Tree root) {
    	if(root == null) {
    		return new Pair(0, 0);
    	} 
    	
    	Pair leftSum = postOrder(root.left);
    	Pair rightSum = postOrder(root.right);
    	
    	int sum = leftSum.sum + rightSum.sum + root.val;
    	int count = leftSum.count + rightSum.count + 1;
    	
    	if(sum/count == root.val) {
    		result++;
    	}
    	
    	return new Pair(sum, count);
    	
    }
	
	public static void main(String[] args) {
		int[] arr = {4, 8, 0, -1, -1, 1, -1, -1, 5, -1, 6, -1, -1}; 
		Solution sol = new Solution();
		
		Tree root = sol.buildTree(arr);
		
		sol.inOrder(root);
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.averageOfSubtree(root));
	}
}
