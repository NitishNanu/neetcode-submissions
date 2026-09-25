class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1, e=-1;
        for(int i : piles){
            e=Math.max(e, i);
        }
        int ans=-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(isPossible(piles,mid,h)){
                ans = mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] piles, int mid, int h){
        int total=0;
        for(int i : piles){
            total = total + (i+mid-1)/mid;
            if(total>h) return false;
        }
        return total<=h;
    }
}
