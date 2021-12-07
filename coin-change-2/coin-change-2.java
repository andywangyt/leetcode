class Solution {
	  public static int change(int amount, int[] coins) {
		    int[] dp = new int[amount + 1];
		    dp[0] = 1;

		    for (int coin : coins) {
		      for (int x = coin; x < amount + 1; ++x) {
		        dp[x] += dp[x - coin];
		      }
		    }
		    return dp[amount];
		  }
	  

		public static void main(String[] args) {
					
			int[] coins = new int[] {1,2,5};
			int target = 5;
					
			int result = Solution.change(target, coins);
			
			System.out.println("result "+ result);
			
		}
}