class Solution {
    
    int index = 0;
    
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
         //value, out - in
        Map<Integer, Integer> degreeDiffMap = new HashMap<>();
        
        for(int[] e: pairs) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            degreeDiffMap.put(e[0], degreeDiffMap.getOrDefault(e[0], 0) + 1);
            degreeDiffMap.put(e[1], degreeDiffMap.getOrDefault(e[1], 0) - 1);
        }
        
        int startPoint = pairs[0][0];
        
        //start node is outdegree - indegree > 0.
        for(Map.Entry<Integer, Integer> e: degreeDiffMap.entrySet()) {
            if(e.getValue() > 0) {
                startPoint = e.getKey();
                break;
            }
        }
        
        index = pairs.length - 1;
        
        dfs(startPoint, pairs, map);
        
        return pairs;
    }
    
    private void dfs(int vertax, int[][] pairs, Map<Integer, List<Integer>> map) {
        while(map.get(vertax) != null && !map.get(vertax).isEmpty()) {
            List<Integer> list = map.get(vertax);
            int nextVertax = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            dfs(nextVertax, pairs, map);
            pairs[index][1] = nextVertax;
            pairs[index][0] = vertax;
            index--;
        }
    }
}