class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i=0, j=0;
        int k = s1.length();
        StringBuilder sb = new StringBuilder();
        while(j<s2.length()){
            sb.append(s2.charAt(j));

            if(j-i+1 == k){
                if(isPossible(sb, s1)) return true;
                sb.deleteCharAt(0);
                i++;
            }
            j++;
        }
        return false;
    }

    public boolean isPossible(StringBuilder sb, String s){
        int[] ch = new int[26];
        for(char c : sb.toString().toCharArray()){
            ch[c-'a']++;
        }

        for(char c : s.toCharArray()){
            ch[c-'a']--;
        }

        for(int i : ch){
            if(i!=0) return false;
        }
        return true;
    }
}
