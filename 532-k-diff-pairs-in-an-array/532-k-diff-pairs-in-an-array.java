public class Solution {
//     public int findPairs(int[] nums, int k) {

//         int result = 0;

//         HashMap <Integer,Integer> counter = new HashMap<>();
//         for (int n: nums) {
//             counter.put(n, counter.getOrDefault(n, 0)+1);
//         }


//         for (Map.Entry <Integer, Integer> entry: counter.entrySet()) {
//             int x = entry.getKey();
//             int val = entry.getValue();
//             if (k > 0 && counter.containsKey(x + k)) {
//                 result++;
//             } else if (k == 0 && val > 1) {
//                 result++;
//             }
//         }
//         return result;
//     }
    
    
        public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }


    
    

//     public int findPairs(int[] nums, int k) {
//         Arrays.sort(nums);
//         int n = nums.length, y = 0, res = 0;
//         for (int x = 0; x < n; x++) {
//             if (x == 0 || nums[x] != nums[x - 1]) {
//                 while (y < n && (nums[y] < nums[x] + k || y <= x)) {
//                     y++;
//                 }
//                 if (y < n && nums[y] == nums[x] + k) {
//                     res++;
//                 }
//             }
//         }
//         return res;
//     }
    
    
    
    
}
