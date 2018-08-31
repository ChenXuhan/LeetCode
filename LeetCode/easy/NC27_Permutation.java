package easy;

import java.util.ArrayList;
import java.util.Comparator;

public class NC27_Permutation {
    /*使用数组记录所有出现过的字母*/
	int Size=26<<1;
	ArrayList<String> res = new ArrayList<String>();
	//自定义Comparator对象，自定义排序
	Comparator c = new Comparator<String>() {
		@Override
		public int compare(String str1, String str2) {
			// TODO Auto-generated method stub
			return str1.compareTo(str2);
		}
	};
    public ArrayList<String> Permutation(String str) {
       if(str==null || str.length()<1)
    	   return res;
       Permutation(str.toCharArray(),0);
       //对结果排序
       res.sort(c);
       return res;
    }
    public void Permutation(char[] chs,int index) {
    	if(index==chs.length)
    	{
    		res.add(String.valueOf(chs));
    		return;
    	}
    	Permutation(chs,index+1);
    	for(int i=index+1;i<chs.length;i++)
    	{
    		if(chs[index]!=chs[i])
    		{
        		char temp = chs[index];
        		chs[index] = chs[i];
        		chs[i] = temp;
        		Permutation(chs,index+1);
        		temp = chs[index];
        		chs[index] = chs[i];
        		chs[i] = temp;
    		}
    	}
    }
    
    public void TestPermutation(){
    	String str = "abc";
    	ArrayList<String> result = Permutation(str);
    	System.out.println(result.toString());
//    	for(String s: result)
//    	{
////    		System.out.println(s.intern());
//    		for(int i=0;i<s.length();i++)
//    		{
//    			System.out.print(s.charAt(i));
//    		}
//    	}
    }
}
