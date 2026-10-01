class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        if(s1.length() > s2.length()) return false;
        int i=0, j=0;

        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c-'a']++;
        }

        while(j<s2.length()){
            char ch = s2.charAt(j);
            freq[ch-'a']--;

            if(j-i+1==k){
                if(allZeros(freq)) return true;

                freq[s2.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return false;
    }

    public boolean allZeros(int[] freq){
        for(int i : freq){
            if(i!=0) return false;
        }
        return true;
    }
}
