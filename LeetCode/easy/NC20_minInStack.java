package easy;

import java.util.Stack;

public class NC20_minInStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        if(this.stack1.empty())
        {
            this.stack2.push(node);
        }else{
            int minCur = this.min();
            if(node<minCur)
            {
                minCur = node;
            }
            this.stack2.push(minCur);
        }
        this.stack1.push(node);
    }
    
    public void pop() {
        this.stack1.pop();
        this.stack2.pop();
    }
    
    public int top() {
        this.stack2.pop();
        return this.stack1.pop();
    }
    
    public int min() {
        return this.stack2.peek();
    }
}
