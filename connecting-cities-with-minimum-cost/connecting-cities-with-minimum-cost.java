class Solution {
//     public int minimumCost(int n, int[][] connections) {
        
//     }
    
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
        
        int[][] connections_01 = new int[][]{
            {1,2,5},
            {1,3,6},
            {2,3,1}
        };
        int N_01 = 3;

        System.out.println("Test #1: minimumCost = " + minimumCost(N_01, connections_01));

        int[][] connections_02 = new int[][]{
            {1,2,3},
            {3,4,4}
        };
        int N_02 = 4;
        System.out.println("Test #2: minimumCost = " + minimumCost(N_02, connections_02));
    }

    public static int minimumCost(int N, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<Integer> visited = new HashSet<>();
        int totalCost = 0;

        // Convert to an adjacency list
        // key : value
        // 1 : {2, 5}, {3,6}
        // 2 : {1, 5}. {2,1}
        // 3 : {1, 6}, {2,1}

        // 1 : {2, 5}
        // 2 : {1, 5}
        // 3 : 
        for (int[] connection : connections) {
            int src = connection[0];
            int dst = connection[1];
            int cost = connection[2];

            graph.computeIfAbsent(src, (k) -> new ArrayList<>());
            graph.computeIfAbsent(dst, (k) -> new ArrayList<>());

            // add to adjacency list for both source and destination
            graph.get(src).add(new int[]{dst, cost});
            graph.get(dst).add(new int[]{src, cost});
        }

        int[] origin = new int[] {1, 1, 0};
        minHeap.add(origin);
        while (!minHeap.isEmpty()) {
            int[] connection = minHeap.poll();
            int src = connection[0];
            int dst = connection[1];
            int cost = connection[2];

            if (!visited.contains(dst)) {
                totalCost += cost;
                visited.add(dst);
                for (int[] neighbor : graph.get(dst)) {
                    // add to minHeap as {src, dst, cost}
                    minHeap.add(new int[] {dst, neighbor[0], neighbor[1]});
                }
            }
        }

        return visited.size() == N ? totalCost : -1;
    }
}