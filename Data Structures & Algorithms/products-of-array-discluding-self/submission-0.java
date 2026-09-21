class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        int pro = 1;
        for(int i=0;i<nums.length;i++){
            out[i] = pro;
            pro = pro*nums[i];
        }

        pro = 1;
        for(int i=n-1;i>=0;i--){
            out[i] = out[i] * pro;
            pro = pro * nums[i];
        }
        return out;
    }
}  
