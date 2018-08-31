package easy;

import java.util.ArrayList;
import easy.TreeNode;

public class NC22_PrintTree {

	public void TestPrintTree(){
		int[] values = {10,6,14,4,8,12,16};
		TreeNode root = new Tree().buildTree(values,0);
		new Tree().showTree(root);
		ArrayList<Integer> res = new NC22_PrintTree().PrintFromTopToBottom(root);
		System.out.println(res.toString());
	}
	
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //广度搜索，使用队列
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        while(!nodes.isEmpty())
        {
            TreeNode point = nodes.get(0);
            res.add(point.val);
            if(point.left!=null)
            {
                nodes.add(point.left);
            }
            if(point.right!=null)
            {
                nodes.add(point.right);
            }
            nodes.remove(0);
        }
        return res;
    }
}
