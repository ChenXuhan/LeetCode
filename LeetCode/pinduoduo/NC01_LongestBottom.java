package pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

import easy.NC19_printMatrix;

public class NC01_LongestBottom {

    public int findLongest(int[] array){
        if(array.length<3)
            return array.length;
        int max = 0;
        int aHead = array[1];
        boolean down = array[0]>array[1];
        int count = 2;
        for(int i=2;i<array.length;i++) {
            int x = array[i];
//            System.out.println(count+","+x);
            if(x<aHead)
            {
                if(down)
                    count++;
                else{
                    if(count>max)
                        max = count;
                    count = 2;
                    down = true;
                }
            }else if(x>aHead){
                count++;
                down = false;
            }else{
                if(count>max)
                    max = count;
                count = 1;
                down = true;
            }
            if(count>max)
            	max = count;
            aHead = x;
        }
        return max;
    }
    public int[] readIntArray(String line){
    	if(line.isEmpty() || !(line.startsWith("[")&&line.endsWith("]")))
    		return new int[]{};
    	String[] inputs = line.substring(1, line.length()-1).split(",");
        int len = inputs.length;
        int[] values = new int[len];
    	for(int i=0;i<len;i++)
    	{
            values[i] = Integer.valueOf(inputs[i]);
    	}
        return values;
    }
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	NC01_LongestBottom solution = new NC01_LongestBottom();
        	int[] values = solution.readIntArray(line);
        	int res = solution.findLongest(values);
        	System.out.print(res);
        }
    }
     */
}
