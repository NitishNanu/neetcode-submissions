class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String str : strs){
            int[] freq = new int[26];
            for(char ch : str.toCharArray()){
                freq[ch-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i : freq){
                sb.append("#").append(i);
            }
            String key = sb.toString();
            if(!mp.containsKey(key)){
                mp.put(key, new ArrayList<>());
            }
            mp.get(key).add(str);
        }

        return new ArrayList<>(mp.values());
    }
}
