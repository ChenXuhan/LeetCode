package easy;

public class NC31_NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        if(n<1)
            return count;
        int weight=1;
        while(true)
        {
            int rounds = n/(weight*10);
            count += rounds*weight;
            if(n%(weight*10)/weight>1)
                count += weight;
            else if(n%(weight*10)/weight==1)
            {
                count += n%weight+1;
            }
            if(rounds==0) break;
            weight *= 10;
//            System.out.println(weight/10+","+rounds+","+count);
        }
        return count;
    }
    
    public void TestNumberOf1(){
    	System.out.println(NumberOf1Between1AndN_Solution(13));
    }
}
