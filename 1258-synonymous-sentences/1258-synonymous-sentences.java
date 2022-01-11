class Solution {
    
    Map<String, List<String>> graph = new HashMap<>(); 
    
    private void dfs(String curr, Set<String> visited, List<String> traversal) {
        if(visited.contains(curr)) return; 
        visited.add(curr); 
        for(String neighbor : graph.get(curr)) {
            dfs(neighbor, visited, traversal); 
        }
        traversal.add(curr); 
    }
    
    private void buildGraph(List<List<String>> synonyms) {
        for(List<String> list : synonyms) {
            graph.putIfAbsent(list.get(0), new ArrayList<>());
            graph.putIfAbsent(list.get(1), new ArrayList<>());
            graph.get(list.get(0)).add(list.get(1)); 
            graph.get(list.get(1)).add(list.get(0)); 
        }
    }
    
    private String getJoinedStrings(List<String> curr) {
        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<curr.size(); i++) {
            if(i != 0) sb.append(" "); 
            sb.append(curr.get(i)); 
        }
        return new String(sb); 
    }
                            
    private void helper(String[] arr, int i, List<String> curr, List<String> ret) {
        if(i == arr.length) {
            ret.add(getJoinedStrings(curr)); 
            return; 
        }
        String word = arr[i]; 
        if(!graph.containsKey(word)) {
            curr.add(word); 
            helper(arr, i+1, curr, ret);
            curr.remove(curr.size()-1); 
        } else {
            List<String> synonyms = new ArrayList<>(); 
            Set<String> visited = new HashSet<>();
            dfs(word, visited, synonyms); 
            Collections.sort(synonyms);
            for(String synonym : synonyms) {
                curr.add(synonym); 
                helper(arr, i+1, curr, ret);
                curr.remove(curr.size()-1); 
            }    
        }    
    }
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> ret = new ArrayList<>(), curr = new ArrayList<>();
        buildGraph(synonyms); 
        String[] arr = text.split("\\s"); 
        helper(arr, 0, curr, ret); 
        return ret; 
    }                        
}