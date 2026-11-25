package Count_Nodes_Equal_to_Average_of_Subtree;

class Tree {
	int val;
	Tree left;
	Tree right;
	
	Tree(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	} 
}

class Solution {
	int index= -1;
	
	Tree buildTree(int[] arr) {
		index++;
		
		if(arr[index] == -1) {
			return null;
		}
		Tree root = new Tree(arr[index]);
		
		root.left = buildTree(arr);
		root.right = buildTree(arr);
		
		return root;
	}
	
	void inOrder(Tree root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val + " ");
		inOrder(root.left);
		inOrder(root.right);
	}
}

public class Solution1 {
	int result;
	int count;
    public int averageOfSubtree(Tree root) {
        result = 0;
        solve(root);
        return result;
    }
    
    private void solve(Tree root) {
    	if(root == null) {
    		return;
    	}
    	
    	count = 0;
    	int total = sum(root);
    	int avg = total/count;
    	if(root.val <= avg) {
    		result++;
    	}
    	
    	solve(root.left);
    	solve(root.right);
    }
    
    private int sum(Tree root) {
    	if(root == null) {
    		return 0;
    	}
    	count++;
    	int leftSum = sum(root.left);
    	int rightSum = sum(root.right);
    	
    	return leftSum + rightSum + root.val;
    }
	
	public static void main(String[] args) {
		int[] arr = {4, 8, 0, -1, -1, 1, -1, -1, 5, -1, 6, -1, -1}; 
		Solution sol = new Solution();
		
		Tree root = sol.buildTree(arr);
		
		sol.inOrder(root);
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.averageOfSubtree(root));
	}
}
