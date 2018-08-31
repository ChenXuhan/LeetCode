package easy;

import java.util.ArrayList;

public class NC41_FindPaires {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(sum<3)
            return result;

        int start = 0;
        for(int len=(int)Math.sqrt(sum<<1);len>1;len--)
        {
            if(((len&1)==1 && sum%len==0)||((len&1)==0 && (sum%len)*2==len))
            {
                start = sum/len-((len-1)>>1);
                System.out.println(start);
                if(start<1) continue;
                ArrayList<Integer> seq = new ArrayList<Integer>();
                for(int j=0;j<len;j++)
                    seq.add(start+j);
                System.out.println(seq);
                result.add(seq);
            }
        }

        return result;
    }
}
