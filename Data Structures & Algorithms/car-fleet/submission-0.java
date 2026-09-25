class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a,b)->(b[0]-a[0]));

        Stack<Double> st = new Stack<>();
        for(int[] a : arr){
            int pos = a[0];
            int sp = a[1];

            double time = (double)(target - pos)/sp;

            if(st.isEmpty()) st.push(time);
            else{
                if(time <= st.peek()) continue;
                else st.push(time);
            }
        }
        return st.size();
    }
}
