class Solution {
    /**
    Count number then count occurrence:

    Count the occurrences of each number using HashMap;
    Using TreeMap to count each occurrence;
    Poll out currently least frequent elemnets, and check if reaching k, deduct the correponding unique count remaining.
    
    */
    
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        int remaining = count.size();
        TreeMap<Integer, Integer> occurrenceCount = new TreeMap<>();
        for (int v : count.values())
            occurrenceCount.put(v, 1 + occurrenceCount.getOrDefault(v, 0));
        while (k > 0) {
            Map.Entry<Integer, Integer> entry = occurrenceCount.pollFirstEntry();
            if (k - entry.getKey() * entry.getValue() >= 0) {
                k -= entry.getKey() * entry.getValue();
                remaining -= entry.getValue();
            }else {
                return remaining - k / entry.getKey();
            }
        }
        return remaining;        
    }
}