class Solution {
    public int maxArea(int[] heights) {
        int ans = -1;

        int i=0, j=heights.length-1;

        while(i<j){
            int maxi=0;
            if(heights[i] > heights[j]){
                maxi = heights[j]*(j-i);
                j--;
            }
            else{
                maxi = heights[i]*(j-i);
                i++;
            }
            ans=Math.max(ans, maxi);
        }
        return ans;
    }
}
