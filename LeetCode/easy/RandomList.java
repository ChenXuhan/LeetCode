package easy;

import java.util.ArrayList;

public class RandomList {

    public RandomListNode buildTree(int[][] values) {
    	RandomListNode root = null;
		if(values.length<1)
			return null;
		root = new RandomListNode(values[0][0]);
		RandomListNode pAhead = root;
		System.out.println(values.length);
		for(int i=1;i<values.length;i++)
		{
			RandomListNode pCurrent = new RandomListNode(values[i][0]);
			pAhead.next = pCurrent;
			pAhead = pCurrent;
		}
		pAhead = root;
		int i=0;
		while(pAhead!=null)
		{
			if(values[i][1]>0)
			{
				int j=1;
				RandomListNode pRand = root;
				while(j<values[i][1])
				{
					pRand = pRand.next;
					j++;
				}
				pAhead.random = pRand;
			}
			pAhead = pAhead.next;
			i++;
		}
		return root;
    }

	public void showTree(RandomListNode root){
		ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
		while(root!=null)
		{
			int val = root.label;
			int rand = 0;
			if(root.random!=null)
				rand = root.random.label;
			ArrayList<Integer> node = new ArrayList<Integer>();
			node.add(val);
			node.add(rand);
			arrs.add(node);
			root = root.next;
		}
		System.out.println(arrs.toString());
	}
}
