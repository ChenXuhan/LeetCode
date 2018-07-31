package easy;
import java.util.ArrayList;
import java.util.Comparator;

public class NC32_PrintMinNumber {
	//自定义Comparator对象，自定义排序
	Comparator c = new Comparator<Integer>() {
	    @Override
	    public int compare(Integer data1, Integer data2) {
	        // TODO Auto-generated method stub
	        // return data1.compareTo(data2);
	        int m1=10,m2=10;
	        while(m1<=data1)
	            m1 *= 10;
	        while(m2<=data2)
	            m2 *= 10;
	        int x=(data1*m2+data2)-(data2*m1+data1);
	        if(x>0)
	            return 1;
	        else if(x<0) 
	        	return -1;
	        else return 0;
	    }
	};
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length<1)
            return "";
        ArrayList<Integer> arrs = new ArrayList<Integer>();
        for(int i=0;i<numbers.length;i++)
        {
            arrs.add(numbers[i]);
        }
        arrs.sort(c);
        String res = "";
        for(int number: arrs)
        {
            res = res+String.valueOf(number);
        }
        return res;
    }
	public void TestPrintMinNumber(){
		int[] inputs = {3,5,1,4,2};
		System.out.println(PrintMinNumber(inputs));
	}
}
