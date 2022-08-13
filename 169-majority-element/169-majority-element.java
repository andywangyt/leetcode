class Solution {
    public int majorityElement(int[] nums) {

       Map<Integer, Integer> counter = new HashMap<>();
        
       for (int num: nums) {
           if (counter.containsKey(num)) {
              int exist = counter.get(num);  
              counter.put(num, exist +1);  
             // System.out.println("exists" + exist + " num " + num);
               
           }
           else {
               //System.out.println("npt exists" + " num " + num);
               counter.put(num,1);   
           }   
       } 
        
       int half = nums.length / 2;
       int found = 0; 
       for (Map.Entry<Integer, Integer> item : counter.entrySet()) {
           //System.out.println("item key" + item.getKey() + " value" +  item.getValue());
           
           if (item.getValue() > half) {
               found = item.getKey();
               break;
           }
           
       }
        
      return found;  
    }
}