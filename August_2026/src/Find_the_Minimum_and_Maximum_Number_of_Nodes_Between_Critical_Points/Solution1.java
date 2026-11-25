package Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points;

class Node {
	int val;
	Node next;
	
	Node(int val) {
		this.val = val;
		this.next = null;
	}
}

class Answer {
	Node head;
	Node add(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
			return newNode; 
		}
		
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
		
		return head;
	}
	 public int[] nodesBetweenCriticalPoints(Node head) {
		int firstCriticalPointPos = 0;
		int prevCriticalPointPos = 0;
		int i = 1;
		Node curr = head.next;
		Node prev = head;
		int minDist = Integer.MAX_VALUE;
		
		while(curr.next != null) {
			if((curr.val < curr.next.val && curr.val < prev.val) || (curr.val > curr.next.val && curr.val > prev.val)) {
				if(prevCriticalPointPos == 0) {
					prevCriticalPointPos = i;
					firstCriticalPointPos = i;
				} else {
					minDist = Math.min(minDist, i - prevCriticalPointPos);
					prevCriticalPointPos = i;
				}
			}
			i++;
			prev = curr;
			curr = curr.next;
		}
		if(minDist == Integer.MAX_VALUE) {
			return new int[] {-1, -1};
		}
			
		
		int maxDist = prevCriticalPointPos - firstCriticalPointPos;
		
		return new int[] {minDist, maxDist};
	 }
}

public class Solution1 {
	public static void main(String[] args) {
		int[] arr = {1,3,2,2,3,2,2,2,7};
		
		Node root = null;
		Answer ans = new Answer();
		for(int i=0;i<arr.length;i++) {
			root = ans.add(arr[i]);
		}
		
		Node temp = root;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
		
		int[] a = ans.nodesBetweenCriticalPoints(root);
		
		System.out.println(a[0] + " " + a[1]);
	}
}
