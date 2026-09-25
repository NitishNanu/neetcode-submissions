class Solution {
    public int findMin(int[] nums) {
        int s=0,e=nums.length-1;
        int mini = Integer.MAX_VALUE;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[s] <= nums[mid]){
                mini = Math.min(mini, nums[s]);
                s=mid+1;
            }
            else{
                mini = Math.min(mini, nums[mid]);
                e=mid-1;
            }
        }
        return mini;
    }
}
