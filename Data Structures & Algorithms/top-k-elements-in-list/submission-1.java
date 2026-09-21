class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (mp.get(b)-mp.get(a)));

        for(int i : mp.keySet()){
            pq.offer(i);
        }
        int[] arr = new int[k];
        int i=0;
        while(k>0){
            arr[i++] = pq.poll();
            k--;
        }
        return arr;
    }
}
