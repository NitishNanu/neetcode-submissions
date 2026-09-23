class MinStack {
    int size;
    List<Integer> st;
    public MinStack() {
        this.size = 0;
        st = new ArrayList<>();
    }
    
    public void push(int val) {
        size++;
        st.add(val);
    }
    
    public void pop() {
        st.remove(st.size()-1);
    }
    
    public int top() {
        return st.get(st.size()-1);
    }
    
    public int getMin() {
        int mini = Integer.MAX_VALUE;
        for(int i : st){
            mini = Math.min(mini, i);
        }
        return mini;
    }
}
