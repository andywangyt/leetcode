class Solution {
    /**

    Process: 
                pre first 0
                x -2
                pre last -2
                maxAns -2
                ------------------
                pre first -2
                x 1
                pre last 1
                maxAns 1
                ------------------
                pre first 1
                x -3
                pre last -2
                maxAns 1
                ------------------
                pre first -2
                x 4
                pre last 4
                maxAns 4
                ------------------
                pre first 4
                x -1
                pre last 3
                maxAns 4
                ------------------
                pre first 3
                x 2
                pre last 5
                maxAns 5
                ------------------
                pre first 5
                x 1
                pre last 6
                maxAns 6
                ------------------
                pre first 6
                x -5
                pre last 1
                maxAns 6
                ------------------
                pre first 1
                x 4
                pre last 5
                maxAns 6
                ------------------
                result 6



    Pseudocode
        1. Initialize 2 integer variables. Set both of them equal to the first value in the array.

        2. currentSubarray will keep the running count of the current subarray we are focusing on.
        maxSubarray will be our final return value. Continuously update it whenever we find a bigger subarray.
        3.  Iterate through the array, starting with the 2nd element (as we used the first element to initialize our variables). For each number, add it to the currentSubarray we are building. If currentSubarray becomes negative, we know it isn't worth keeping, so throw it away. Update maxSubarray every time we find a new maximum.

        4 Return maxSubarray.

    
    */
    
    
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
//   		 	System.out.println("pre first "+pre);
//   		 	System.out.println("x "+x);
            pre = Math.max(pre + x, x);
//   		 	System.out.println("pre last "+pre);
            maxAns = Math.max(maxAns, pre);
//   		 	System.out.println("maxAns "+maxAns);
   		 	
//   		 	System.out.println("------------------");
        }
        return maxAns;
    }


	 public static void main (String[] args) {
		 int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		 
		 int result = Solution.maxSubArray(nums);
		 
		 System.out.println("result "+result);
	 }
}