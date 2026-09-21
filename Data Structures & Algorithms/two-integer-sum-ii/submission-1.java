class Solution {
    public int[] twoSum(int[] nums, int target) {
        int s=0, e=nums.length-1;

        while(s<e){
            int sum = nums[s]+nums[e];
            if(sum == target) return new int[]{s+1,e+1};
            if(sum < target) s++;
            else e--;
        }
        return new int[]{-1, -1};
    }
}
