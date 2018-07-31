package easy;

public class NC33_GetUglyNumber {
    public int Min(int a,int b,int c) {
        int result = a;
        if(b<result)
            result = b;
        if(c<result)
            result = c;
        return result;
    }
    
    public int GetUglyNumber_Solution(int index) {
        if(index<1)
            return 0;
        int[] res = new int[index];
        res[0] = 1;
        int min2=0,min3=0,min5=0;
        for(int i=1;i<index;i++)
        {
            res[i] = Min(res[min2]*2,res[min3]*3,res[min5]*5);
            while(min2<i)
                if(res[min2]*2<=res[i])
                    min2++;
                else break;
            while(min3<i)
                if(res[min3]*3<=res[i])
                    min3++;
                else break;
            while(min5<i)
                if(res[min5]*5<=res[i])
                    min5++;
                else break;
//            System.out.println(res[i]+","+min2+","+min3+","+min3);
        }
        return res[index-1];
    }
    
    public void TestGetGulyNumber() {
    	System.out.println(GetUglyNumber_Solution(9));
    }
}
