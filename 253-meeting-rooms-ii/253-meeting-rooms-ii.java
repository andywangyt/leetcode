class Solution {
    
/*
 * 
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * 
	    Diagram:
			[[0,30], [5,10], [15,20]]
			
			
			heap = [10, 20, 30]

			- check for intersection
			    -if intersection
			        - append to heap
			- else:
			    - while there is no intersection, pop off heap
			- max_rooms = len(heap))
	
	
	
	     Pseudocode 
     
        1. Sort the given meetings by their start time.
		2. Initialize a new min-heap and add the first meeting's ending time to the heap. 
		   We simply need to keep track of the ending times as that tells us when a meeting
		   room will get free.
		3. For every meeting room check if the minimum element of the heap i.e. 
		   the room at the top of the heap is free or not.
		4. If the room is free, then we extract the topmost element and add it back with
		    the ending time of the current meeting we are processing.
		   If not, then we allocate a new room and add it to the heap.
		5. After processing all the meetings, the size of the heap will tell us the number of 
		   rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings
		        
*/       
                    
    public static int minMeetingRooms(int[][] intervals) {
        
    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }

    // Min heap
    PriorityQueue<Integer> allocator =
        new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>() {
              public int compare(Integer a, Integer b) {
                return a - b;
              }
            });

    // Sort the intervals by start time
    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          public int compare(final int[] a, final int[] b) {
            return a[0] - b[0];
          }
        });

    // Add the first meeting
    allocator.add(intervals[0][1]);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {

      // If the room due to free up the earliest is free, assign that room to this meeting.
      if (intervals[i][0] >= allocator.peek()) {
        allocator.poll();
      }

      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      allocator.add(intervals[i][1]);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size();
  }
    
    public static void main (String[] args)
    {
    	int[][] intervals = new int[][] {{1,4},{2,8},{5,7},{5,9},{3,4}};
    	
    	System.out.println(Solution.minMeetingRooms(intervals));
    }
}