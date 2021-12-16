class Solution {
    
	/*
	 * This algorithm is almost identical to the brute force approach, except we
	 * first insert each element of nums into a set, allowing us to later query for
	 * containment in \mathcal{O}(1)O(1) time.
	 */

    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
  

	/**
	 * First, we sort nums. Then, we check the two special cases that can be handled
	 * in constant time - ensuring that 0 is at the beginning and that nn is at the
	 * end. Given that those assumptions hold, the missing number must somewhere
	 * between (but not including) 0 and nn. To find it, we ensure that the number
	 * we expect to be at each index is indeed there.
	 * 
	 * 
	 * Because we handled the edge cases, this is simply the previous number plus 1.
	 * 
	 * Thus, as soon as we find an unexpected number, we can simply return the
	 * expected number.
	 */
//	public int missingNumber(int[] nums) {
//		Arrays.sort(nums);
//
//		// Ensure that n is at the last index
//		if (nums[nums.length - 1] != nums.length) {
//			return nums.length;
//		}
//		// Ensure that 0 is at the first index
//		else if (nums[0] != 0) {
//			return 0;
//		}
//
//		// If we get here, then the missing number is on the range (0, n)
//		for (int i = 1; i < nums.length; i++) {
//			int expectedNum = nums[i - 1] + 1;
//			if (nums[i] != expectedNum) {
//				return expectedNum;
//			}
//		}
//
//		// Array was not missing any numbers
//		return -1;
//	}
        
   public static void main(String args[]) {
		int[] s = new int[] { 3, 0, 1 };

		int result = new Solution().missingNumber(s);

		System.out.println(result);

	}
}