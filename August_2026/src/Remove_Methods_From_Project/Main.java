package Remove_Methods_From_Project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
    	int[] inDegree = new int[n];
    	List<List<Integer>> adjMatrix = new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		adjMatrix.add(new ArrayList<>());
    	}
    	
    	for(int[] x: invocations) {
    		int u = x[0];
    		int v = x[1];
    		
    		adjMatrix.get(u).add(v);
    		inDegree[v]++;
    	}
    	    	
    	Queue<Integer> queue = new LinkedList<>();
    	boolean[] suspecious = new boolean[n];
    	queue.add(k);
    	suspecious[k] = true;
    	
    	while(!queue.isEmpty()) {
    		int u = queue.poll();
    		
    		for(int v: adjMatrix.get(u)) {
    			inDegree[v]--;
    			if(!suspecious[v]) {
    				queue.add(v);
    				suspecious[v] = true;
    			}
    		}
    	}
    	
    	boolean cannotRemove = false;
    	List<Integer> result = new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		if(suspecious[i] && inDegree[i] > 0) {
    			cannotRemove = true;
    			break;
    		}
    		
    		if(!suspecious[i]) {
    			result.add(i);
    		}
    	}
    	
    	if(cannotRemove) {
    		List<Integer> ans = new ArrayList<>();
    		for(int i=0;i<n;i++) {
    			ans.add(i);
    		}
    		
    		return ans;
    	}
    	
    	return result;
    	
    }

	public static void main(String[] args) {
		int n = 5;
		int k = 0;
		int[][] arr = {
				{1,2},{0,2},{0,1},{3,4}
		};
		
		Main m = new Main();
		List<Integer> ans = m.remainingMethods(n, k, arr);
		
		System.out.println(ans);
		
	}
}
