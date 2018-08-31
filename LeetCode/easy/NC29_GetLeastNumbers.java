package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NC29_GetLeastNumbers {

    /*借助快排的思想*/
	int[] output;
	//自定义Comparator对象，自定义排序
	Comparator c = new Comparator<Integer>() {
		@Override
		public int compare(Integer data1, Integer data2) {
			// TODO Auto-generated method stub
			return data1.compareTo(data2);
		}
	};
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrs = new ArrayList<Integer>();
        if(k>input.length || k<0 || input.length<1)
        	return arrs;
        for(int i=0;i<input.length;i++)
        	arrs.add(input[i]);
//        arrs.sort(c);
        Collections.sort(arrs);
        return new ArrayList<Integer>(arrs.subList(0, k));
        
//    	output = input;
//        int index = Partition(0,input.length-1);
//        while(index!=k-1)
//        {
//        	if(index>k-1)
//        	{
//        		index = Partition(0,index);
//        	}else{
//        		index = Partition(index+1,input.length-1);
//        	}
//        }
//        for(int i=0;i<k;i++)
//        	arrs.add(output[i]);
//        return arrs;
    }
    
    public int Partition(int start, int end) {
        int index = (start+end)>>1;
        int temp = output[index];
        output[index] = output[end];
        output[end] = temp;
        index = 0;
        for(int i=0;i<end;i++)
        {
        	if(output[i]<output[end])
        	{
        		if(index<i)
        		{
	                temp = output[index];
	                output[index] = output[i];
	                output[i] = temp;
        		}
                index++;
        	}
        }
        temp = output[index];
        output[index] = output[end];
        output[end] = temp;
        
        return index;
    }

	public void TestGetLeastNumbers() {
		int[] in = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> res = GetLeastNumbers_Solution(in,2);
		System.out.println(res.toString());
	}
}
