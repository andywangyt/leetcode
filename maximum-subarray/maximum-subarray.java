class Solution {
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