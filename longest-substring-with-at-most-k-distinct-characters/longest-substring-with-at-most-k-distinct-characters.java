class Solution {
    
/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * 
    Pseudocode 
    
   1. Return 0 if the string is empty or k is equal to zero.
   2. Set both set pointers in the beginning of the string left = 0 and right = 0 and
    init max substring length max_len = 1.
	While right pointer is less than N:
	
   3. Add the current character s[right] in the hashmap and move right pointer to the right.
   4. If hashmap contains k + 1 distinct characters, remove the leftmost character from
    the hashmap and move the left pointer so that sliding window contains again k distinct characters only.
	Update max_len.
 * 
 * 
 */
    
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new HashMap<>();

        int maxLength = 1;

        while (right < n) {
            rightmostPosition.put(s.charAt(right), right++);

            if (rightmostPosition.size() == k + 1) {
                int lowestIndex = Collections.min(rightmostPosition.values());
                rightmostPosition.remove(s.charAt(lowestIndex));
                left = lowestIndex + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}