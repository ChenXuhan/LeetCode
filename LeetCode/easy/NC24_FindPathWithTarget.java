package easy;

import java.util.ArrayList;

public class NC24_FindPathWithTarget {

    ArrayList<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root!=null)
        	FindAllPath(root,target);
        return allPath;
    }
    
    private void FindAllPath(TreeNode root,int target) {
//    	System.out.println("****"+root.val+"****"+path.toString()+"****"+target+"****");
        if(root.left!=null)
        {
        	path.add(root.val);
        	FindAllPath(root.left,target-root.val);
        	path.remove(path.size()-1);
        }
        if(root.right!=null)
        {
        	path.add(root.val);
        	FindAllPath(root.right,target-root.val);
        	path.remove(path.size()-1);
        }
        if(root.left==null && root.right==null)
        {
            if(target==root.val)
            {
            	ArrayList<Integer> pathCurrent = (ArrayList<Integer>)path.clone();
            	pathCurrent.add(root.val);
                allPath.add(pathCurrent);
//            	System.out.println("****"+path.toString()+"****");
            }
        }
        return;
    }

    public void TestFindPath(){
		int[] values = {10,5,12,4,7};
		TreeNode root = new Tree().buildTree(values,0);
//		new Tree().showTree(root);
		ArrayList<ArrayList<Integer>> res = FindPath(root,22);
		System.out.println(res.toString());
	}
}
