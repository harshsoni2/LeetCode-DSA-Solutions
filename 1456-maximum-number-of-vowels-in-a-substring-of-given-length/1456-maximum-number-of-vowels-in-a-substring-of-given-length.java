class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxVowels = 0;
        // first window:
        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        maxVowels = count;
        // sliding the window:
        for(int i=k; i<s.length(); i++){
            if(isVowel(s.charAt(i - k))){
                count--;
            }
            if(isVowel(s.charAt(i))){
                count++;
            }
            maxVowels = Math.max(maxVowels, count);
        }
        return maxVowels;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}