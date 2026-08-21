class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for(char ch : t.toCharArray()){
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int required = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int right = 0; right <s.length(); right++){
        char ch = s.charAt(right);
        window.put(ch, window.getOrDefault(ch, 0) + 1);

        if(need.containsKey(ch) && window.get(ch) <= need.get(ch)){
            required++;
        }
        while(required == t.length()){
            if(right - left + 1 < minLength){
                minLength = right - left + 1;
                startIndex = left;
            }
            char leftChar = s.charAt(left);
            window.put(leftChar, window.get(leftChar) - 1);

            if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                required--;
            }
            left++;
        }
    }
    if(minLength == Integer.MAX_VALUE){
        return "";
    }
    return s.substring(startIndex, startIndex + minLength);
}
}