package easy;

import java.util.ArrayList;

public class NC21_IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
      //序列长度相等，且所有证书不相同
    	if(pushA.length!=popA.length)
    		return false;
    	ArrayList<Integer> stack = new ArrayList<Integer>();
    	int pushP=0,popP=0;
    	int len = popA.length;
    	for(;popP<len;popP++)
    	{
    		if(stack.isEmpty())
    			stack.add(pushA[pushP++]);
    		while(stack.get(stack.size()-1)!=popA[popP]){
    			if(pushP==len)
    				return false;
    			stack.add(pushA[pushP++]);
    		}
    		stack.remove(stack.size()-1);
    	}
    	return true;
    }
}
