class Solution {
    static int min = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
       min=Integer.MAX_VALUE;
       HashMap<Integer,Integer> profitMap = new HashMap<>();
       for(int[] trans : transactions) {
           int a = trans[2];
           profitMap.put(trans[0],profitMap.getOrDefault(trans[0],0)+a);
           profitMap.put(trans[1],profitMap.getOrDefault(trans[1],0)-a);
       }
       LinkedList<Integer> positive = new  LinkedList<>();
       LinkedList<Integer> negative = new  LinkedList<>();
       for(Integer key : profitMap.keySet()){
           Integer val = profitMap.get(key);
           if(val > 0){
               positive.add(val);
           }else if(val < 0){
               negative.add(val);
           }
       }
       dfs(positive,negative,0);
       return min;
    }
    
    public void dfs(List<Integer> positive,List<Integer> negative,int count){
        if(positive.size() == 0 && negative.size() == 0){
            min = Math.min(count,min);
            return;
        }
        if(count >= min){
            return;
        }
        int positiveVal = positive.get(0);
		
		// We start will different negative values and use 
        for(int j=0;j<negative.size();j++){
            int negativeVal = negative.get(j);
			// Deduct the balance. If the new values become zero then we remove those values from the list.
            int newPositiveVal = Math.max(positiveVal+negativeVal,0);
            int newNegativeVal = Math.min(0,positiveVal+negativeVal);
            if(newPositiveVal == 0){
                positive.remove(0);
            }else{
                positive.set(0,newPositiveVal);
            }
            if(newNegativeVal == 0){
                negative.remove(j);
            }else{
                negative.set(j,newNegativeVal);
            }

            dfs(positive,negative,count+1);

            // Backtrack, we need to add back the values.
            if(newPositiveVal == 0){
                positive.add(0,positiveVal);
            }else{
                positive.set(0,positiveVal);
            }
            if(newNegativeVal == 0){
                negative.add(j,negativeVal);
            }else{
                negative.set(j,negativeVal);
            }
        }
    }
}