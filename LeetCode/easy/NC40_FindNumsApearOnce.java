package easy;

public class NC40_FindNumsApearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length<1 || (array.length&1)>0 || num1.length!=1 || num2.length!=1)
            return;
        int len = array.length;
        int findTow = array[0];
        for(int i=1;i<array.length;i++)
            findTow ^= array[i];
        int figure = 1;
        while(true)
        {
            if((findTow&figure)==figure)
                break;
            figure = figure<<1;
        }
//        System.out.println(findTow+","+figure);
        int[] array1 = new int[len];
        int[] array2 = new int[len];
        int i=0,j=0;
        for(int k=0;k<array.length;k++)
            if((array[k]&figure)==figure)
            {
//                System.out.println(array1[i]+","+array[k]);
                array1[i] = array[k];
                i++;
            }
            else
            {
                array2[j] = array[k];
                j++;
            }
        num1[0] = array1[0];
        for(int k=1;k<i;k++)
            num1[0] ^=array1[k];
        num2[0] = array2[0];
        for(int k=1;k<j;k++)
            num2[0] ^=array2[k];        
    }
    public void TestFindNumsAppearOnce() {
    	int[] inputs = {5,6,7,8,2,3,4,5,6,7,3,4};
    	int[] num1 = new int[1];
    	int[] num2 = new int[1];
    	FindNumsAppearOnce(inputs,num1,num2);
    	System.out.print(num1[0]+","+num2[0]);
    }
}
