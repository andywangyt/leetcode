class Solution {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		if (n == 1) {
			return true;
		}
		List<Integer>[] nexts = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			nexts[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			nexts[x].add(y);
			nexts[y].add(x);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		boolean[] been = new boolean[n];
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : nexts[cur]) {
				if (next == destination) {
					return true;
				}
				if (!been[next]) {
					been[next] = true;
					queue.add(next);
				}
			}
		}
		return false;
	}
}

