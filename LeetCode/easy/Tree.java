package easy;

public class Tree {

    public TreeNode buildTree(int[] values,int index) {
		TreeNode node = null;
		if(index>=values.length)
			return null;
		if(values[index]>0){
			node = new TreeNode(values[index]);
			node.left = buildTree(values, index*2+1);
			node.right = buildTree(values, index*2+2);
		}
		return node;
    }

	public void showTree(TreeNode root){
		int[] subTree = {0,0,0};
		if(root!=null)
		{
			subTree[0] = root.val;
			if(root.left!=null)
				subTree[1] = root.left.val;
			if(root.right!=null)
				subTree[2] = root.right.val;
			System.out.println("["+subTree[0]+","+subTree[1]+","+subTree[2]+"]");
			if(root.left!=null)
				showTree(root.left);
			if(root.right!=null)
				showTree(root.right);
		}
	}
}
