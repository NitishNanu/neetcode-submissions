class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        List<Integer> right = NSR(heights, n);
        List<Integer> left = NSL(heights, n);
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int l = heights[i];
            if(right.get(i)==-1) right.set(i, n);

            int w = right.get(i) - left.get(i) - 1;
            maxArea = Math.max(maxArea, l*w);
        }
        return maxArea;
    }

    public List<Integer> NSR(int[] heights, int n){
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        st.push(-1);
        for(int i=n-1;i>=0;i--){
            while(st.peek()!=-1 && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            list.add(st.peek());
            st.push(i);
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> NSL(int[] heights, int n){
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        st.push(-1);
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            list.add(st.peek());
            st.push(i);
        }
        return list;
    }
}
