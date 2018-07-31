package easy;

import java.util.ArrayList;
import java.util.Random;

public class NC35_InversePaires {

	/*注意！！！ 计算结果取模*/
    static int mod = 1000000007;
    public int InversePairs(int [] array) {
        if(array==null || array.length<2)
            return 0;
        int[] sortedArray = array.clone();
        int res = InversePairs(sortedArray,array,0,array.length-1);
//    	for(int i=0;i<sortedArray.length;i++)
//    		System.out.print(sortedArray[i]+",");
        return res;
    }
    private int InversePairs(int [] copy,int [] array,int start,int end) {
        if(start+1>end)
            return 0;
    	
        int mid = (start+end)>>1;
        int res = (InversePairs(array,copy,start,mid)+InversePairs(array,copy,mid+1,end))%mod;
        
        int i = mid;
        int j = end;
        int k = end;
        while(i>=start && j>=mid+1)
        {
        	if(array[i]>array[j])
        	{
        		/*为防止溢出，每次加一个数都要取模*/
        		res = (res+j-mid)%mod;
    		copy[k--] = array[i--];
        	}else{
        		copy[k--] = array[j--];
        	}
        }
        while(i>=start)
        {
        	copy[k--] = array[i--];
        }
        while(j>=mid+1)
        	copy[k--] = array[j--];
        return res;
    }
    public void TestInversePairs() {
    	int val = 493330277;
    	System.out.println(val);
//    	int[] inputs={4,3,5,1};// {1,2,3,4,5,6,7,0};
//    	Random rnd = new Random();
//    	int[] inputs = new int[200000];
//    	for(int i=0;i<inputs.length;i++)
//    		inputs[i] = rnd.nextInt(1000);
    	int[] inputs={1,2,3,4,5,6,7,0};
    	int res = InversePairs(inputs);
    	System.out.println(res+"\n\n");
    	if(inputs.length<1) return;
    }
}
