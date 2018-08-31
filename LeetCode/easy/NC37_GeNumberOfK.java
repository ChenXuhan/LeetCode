package easy;

public class NC37_GeNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
       if(array==null || array.length<1)
           return 0;
        //int index = FindIndexOfK(array,0,array.length-1,k);
        int start = 0;
        int end = array.length-1;
        int mid = (start+end+1)>>1;
        int index = -1;
        while(start<=end)
        {
//        	System.out.println(start+","+mid+","+end);
            if(array[mid]==k)
            {
                index = mid;
                break;
            }
            if(array[mid]>k)
            {
                end = mid-1;
            }else{
                start = mid+1;
            }
            mid = (start+end+1)>>1;
        }
        if(index<0)
            return 0;
        int count = 1;
        for(int i=index-1;i>=0;i--)
        {
            if(array[i]==k)
                count++;
            else break;
        }
        for(int i=index+1;i<array.length;i++)
        {
            if(array[i]==k)
                count++;
            else break;
        }
        return count;
    }
    public void TestGetNumberOfK() {
    	int[] inputs = {1,2,3,5,6};
    	int res = GetNumberOfK(inputs,1);
    	System.out.println(res);
    }
}
