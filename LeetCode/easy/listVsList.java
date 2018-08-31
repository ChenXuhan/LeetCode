package easy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class listVsList {

	public void compare() {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3,4,5};
		List<Integer> arr2 = new ArrayList<Integer>();
		int n= 100;
		for(int i=0; i<n; i++)
		{
			arr2.add(i);
		}
		Date date0 = new Date();
		for(Integer obj: arr2)
		{
			System.out.print(obj+" ");
		}
		Date date1 = new Date();
		System.out.printf("\n for circle spent %d s.\n", date1.getTime()-date0.getTime());

		date0 = date1;
		Iterator<Integer> it = arr2.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		date1 = new Date();
		System.out.printf("\nIterator spent %d s.\n", date1.getTime()-date0.getTime());
		
		date0 = date1;
		for(int i=0; i<arr2.size();i++)
		{
			System.out.print(arr2.get(i)+" ");
		}
		date1 = new Date();
		System.out.printf("\n Index map spent %d s.\n", date1.getTime()-date0.getTime());
		
		
		
		
		
		/*
		Integer[] arr3 = arr2.toArray(new Integer[0]);
		for(int i : arr1)
		{
			arr2.add(i);
		}
		System.out.println(String.valueOf(arr1.hashCode())+": "+arr1.toString());
		System.out.println(String.valueOf(arr2.hashCode())+": "+arr2.toString());
		System.out.println(String.valueOf(arr3.hashCode())+": "+arr3.toString());
		if(arr2.equals(arr1))
			System.out.println("they are equal.");
		else
			System.out.println("they are NOT equal.");
		*/
	}

}
