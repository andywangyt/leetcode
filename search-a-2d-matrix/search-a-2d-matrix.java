/**
 * https://leetcode.com/problems/search-a-2d-matrix/solution/
 * 
 * Time complexity : \mathcal{O}(\log(m n))O(log(mn)) since it's a standard
 * binary search.
 * 
 * Space complexity : \mathcal{O}(1)O(1).
 * 
 * 
 * Approach 1: Binary Search Intuition
 * 
 * One could notice that the input matrix m x n could be considered as a sorted
 * array of length m x n.
 * 
 * bla
 * 
 * Sorted array is a perfect candidate for the binary search because the element
 * index in this virtual array (for sure we're not going to construct it for
 * real) could be easily transformed into the row and column in the initial
 * matrix
 * 
 * row = idx // n and col = idx % n.
 * 
 * Algorithm
 * 
 * The algorithm is a standard binary search :
 * 
 * Initialise left and right indexes left = 0 and right = m x n - 1.
 * 
 * While left <= right :
 * 
 * Pick up the index in the middle of the virtual array as a pivot index :
 * pivot_idx = (left + right) / 2.
 * 
 * The index corresponds to row = pivot_idx // n and col = pivot_idx % n in the
 * initial matrix, and hence one could get the pivot_element. This element
 * splits the virtual array in two parts.
 * 
 * Compare pivot_element and target to identify in which part one has to look
 * for target.
 * 

 *
 */


class Solution {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;

		// binary search
		int left = 0, right = m * n - 1;
		int pivotIdx, pivotElement;
		while (left <= right) {
			pivotIdx = (left + right) / 2;
			pivotElement = matrix[pivotIdx / n][pivotIdx % n];
			if (target == pivotElement)
				return true;
			else {
				if (target < pivotElement)
					right = pivotIdx - 1;
				else
					left = pivotIdx + 1;
			}
		}
		return false;
	}
	
    public static void main(String args[]) {

       
    	int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    	
//    	int target = 13;
    	
    	int target = 23;
    	
    	boolean isSearched = Solution.searchMatrix(matrix, target);
    	
    	System.out.println("isSearched " + isSearched);
    	
    
    }
}