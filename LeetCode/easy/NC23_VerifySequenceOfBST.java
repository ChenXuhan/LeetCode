package easy;

public class NC23_VerifySequenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length<1)
            return false;
        return VerifyWithIndex(0,sequence.length-1,sequence);
    }
    private boolean VerifyWithIndex(int start,int end,int[] sequence) {
    	if(end-start<2)
    		return true;
    	int root = sequence[end];
    	boolean flag = true;
    	int des = start;
    	while(des<end)
    	{
    		if(sequence[des]<root) des++;
    		else break;
    	}
    	if(des>start) 
    		flag = VerifyWithIndex(start,des-1,sequence);
    	if(flag)
    	{
    		int mid = des;
    		while(des<end)
        	{
        		if(sequence[des]>root) des++;
        		else break;
        	}
    		if(des<end)
    			return false;
    		flag = VerifyWithIndex(mid,end-1,sequence);
    	}
    	return flag;
    }
}
