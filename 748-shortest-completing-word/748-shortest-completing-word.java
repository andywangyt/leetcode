class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int minLen = Integer.MAX_VALUE;
        String minLenWord = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : licensePlate.toLowerCase().toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                increment(map,c,1);
            }
        }
        for(String word : words) {
            if(word.length() < minLen) {
                HashMap<Character,Integer> charMap = (HashMap<Character,Integer>)map.clone();
                for(char c : word.toCharArray()) {
                    increment(charMap,c,-1);
                }
                if(charMap.size() == 0) {
                    minLen = word.length();
                    minLenWord = word;
                }
            }
        }
        return minLenWord;
    }
    
    private void increment(HashMap<Character,Integer> map, char key, int delta) {
        int newVal = map.getOrDefault(key,0) + delta;
        if(newVal == 0) {
            map.remove(key);
        } else if(newVal > 0) {
            map.put(key,newVal);
        }
    }
}