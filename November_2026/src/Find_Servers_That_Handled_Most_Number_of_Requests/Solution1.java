package Find_Servers_That_Handled_Most_Number_of_Requests;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution1 {
	public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
		PriorityQueue<int[]> busyServer = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}

			return Integer.compare(a[0], b[0]);
		});

		TreeSet<Integer> availableServer = new TreeSet<>();
		for (int i = 0; i < k; i++) {
			availableServer.add(i);
		}

		int[] count = new int[k];

		for (int i = 0; i < arrival.length; i++) {
			int time = arrival[i];

			while (!busyServer.isEmpty() && busyServer.peek()[0] <= time) {
				int temp[] = busyServer.poll();
				availableServer.add(temp[1]);
			}
			if (availableServer.isEmpty()) {
				continue;
			}

			int target = i % k;
			Integer targetServer = availableServer.ceiling(target);
			if (targetServer == null) {
				targetServer = availableServer.first();
			}

			availableServer.remove(targetServer);
			busyServer.add(new int[] { time + load[i], targetServer });
			count[targetServer]++;
		}

		int max = -1;
		for (int ele : count) {
			max = Math.max(ele, max);
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			if (max == count[i]) {
				res.add(i);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int k = 3;
		int[] arrival = { 1, 2, 3 };
		int[] load = { 10, 12, 11 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.busiestServers(k, arrival, load));
	}
}