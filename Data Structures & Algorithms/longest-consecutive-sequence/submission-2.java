class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int i : nums)st.add(i);
        int cnt=0;
        for(int i : nums){
            if(!st.contains(i-1)){
                int curr = i;
                int len = 1;
                while(st.contains(curr+1)){
                    curr++;
                    len++;
                }
                cnt = Math.max(cnt, len);
            }
            
        }
        return cnt;
    }
}
