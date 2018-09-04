package easy;

public class NC43_LeftRotateString {

    public String LeftRotateString(String str,int n) {
    	/*注意边界条件，str.length()==0*/
        if(str == null||str.length()<1)
            return str;
        StringBuilder strB = new StringBuilder(str);
        n = n % strB.length();
        for(int i=0,j=strB.length()-1;i<j;i++,j--){
            char ch = strB.charAt(i);
            strB.setCharAt(i,strB.charAt(j));
            strB.setCharAt(j,ch);
        }
        for(int i=0,j=strB.length()-n-1;i<j;i++,j--){
            char ch = strB.charAt(i);
            strB.setCharAt(i,strB.charAt(j));
            strB.setCharAt(j,ch);
        }
        /*起始要算清楚*/
        for(int i=strB.length()-n,j=strB.length()-1;i<j;i++,j--){
            char ch = strB.charAt(i);
            strB.setCharAt(i,strB.charAt(j));
            strB.setCharAt(j,ch);
        }
        return strB.toString();
    }
    public void TestLeftRotateString(){
    	String testStr = "abcdefg";
    	String result = LeftRotateString("",3);
    	System.out.println(result);
    }
}
