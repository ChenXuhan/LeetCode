package easy;

public class NC34_FirstNotRepeatingChar {

    int size=26;
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()<1)
            return -1;
        int[] counts = new int[size<<1];
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch>='a' && ch <='z')
            {
                if(counts[ch-'a']==0)
                    counts[ch-'a'] = i+1;
                else 
                    counts[ch-'a'] = -1;
                System.out.println(ch+":"+counts[ch-'a']);
            }
            if(ch>='A' && ch <='Z')
            {
                if(counts[ch-'A'+size]==0)
                    counts[ch-'A'+size] = i+1;
                else 
                    counts[ch-'A'+size] = -1;
            }
        }
        int res = -1;
        for(int j=0;j<counts.length;j++)
        {
            if(counts[j]>0)
                if(res<0 || res>counts[j])
                    res = counts[j];
        }
        return res;
    }
    
    public void Test(){
    	System.out.println(FirstNotRepeatingChar("abbac"));
    }
}
