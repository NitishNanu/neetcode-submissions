class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i=0, j=0;
        int n = nums.length;
        int[] arr = new int[n-k+1];
        int t=0;

        while(j<nums.length){
            while(!dq.isEmpty() && dq.peekLast() < nums[j]) dq.pollLast();
            dq.offerLast(nums[j]);

            if(j-i+1 == k){
                arr[t++] = dq.peekFirst();

                if(nums[i] == dq.peekFirst()){
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return arr;
    }
}
