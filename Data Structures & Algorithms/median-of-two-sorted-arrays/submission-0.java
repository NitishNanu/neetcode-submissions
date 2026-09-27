class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n=nums2.length;
        int l=0, r=m;

        while(l<=r){
            int mid = l+(r-l)/2;

            int px = mid;
            int py = (m+n+1)/2 - px;

            int x1 = (px == 0 ? Integer.MIN_VALUE : nums1[px-1]);
            int x2 = (py == 0 ? Integer.MIN_VALUE : nums2[py-1]);
            int x3 = (px == m ? Integer.MAX_VALUE : nums1[px]);
            int x4 = (py == n ? Integer.MAX_VALUE : nums2[py]);


            if(x1 <= x4 && x2 <= x3){
                if((m+n)%2 == 1) return Math.max(x1, x2);
                else return (Math.max(x1,x2) + Math.min(x3, x4))/2.0;
            }

            if(x1>x4){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}
