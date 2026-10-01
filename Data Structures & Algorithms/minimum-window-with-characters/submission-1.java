class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char c : t.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }

        int i=0, j=0;
        int size=Integer.MAX_VALUE;
        int cnt=0;
        int start=0;

        while(j<s.length()){
            char ch = s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch, mp.get(ch)-1);
                if(mp.get(ch) >= 0) cnt++;
            }

            while(cnt == t.length()){
                if(j-i+1 < size){
                    size = j-i+1;
                    start = i;
                }

                char removeChar = s.charAt(i);
                if(mp.containsKey(removeChar)){
                    mp.put(removeChar, mp.get(removeChar)+1);
                    if(mp.get(removeChar) > 0) cnt--;
                }
                i++;
            }
            j++;
        }
        if(size == Integer.MAX_VALUE) return "";
        return s.substring(start, start+size);
    }
}
