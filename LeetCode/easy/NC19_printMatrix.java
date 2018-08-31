package easy;

import java.util.ArrayList;
import java.util.Scanner;

public class NC19_printMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
       if(matrix.length>0 && matrix[0].length>0)
           return MatrixToList(0,0,matrix[0].length,matrix.length,matrix);
       else return new ArrayList<Integer>();
    }
    
    public ArrayList<Integer> MatrixToList(int startX,int startY,int lenX,int lenY,int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<lenX;i++)
        {
            result.add(matrix[startY][startX+i]);
        }
        if(lenY>1){
            for(int i=1;i<lenY;i++)
            {
            	System.out.println(startX+","+lenX+","+(startX+lenX-1));
                result.add(matrix[startY+i][startX+lenX-1]);
            }
        }else return result;
        if(lenX>1){
            for(int i=lenX-2;i>=0;i--)
            {
                result.add(matrix[startY+lenY-1][startX+i]);
            }
        }else return result;
        if(lenY>2){
            for(int i=lenY-2;i>=1;i--)
            {
                result.add(matrix[startY+i][startX]);
            }
        }else return result;
        if(lenX>2 && lenY>2)
        {
            result.addAll(MatrixToList(startX+1,startY+1,lenX-2,lenY-2,matrix));
        }
        return result;
    }
    
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int lenX = in.nextInt();
        	int lenY = in.nextInt();
        	int[][] matrix = new int[lenY][lenX];
        	for(int i=0;i<lenY;i++)
        		for(int j=0;j<lenX;j++)
        		{
        			matrix[i][j] = in.nextInt();
        		}
        	for(int i=0;i<lenY;i++)
        	{
        		for(int j=0;j<lenX;j++)
        		{
        			System.out.print(matrix[i][j]+",");
        		}
        		System.out.println("("+lenX+","+lenY+")");
    		}
        	ArrayList<Integer> res = new NC19_printMatrix().printMatrix(matrix);
        	System.out.print(res);
        }
    }
     */
}
