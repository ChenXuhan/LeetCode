package easy;

public class NC26_ConvertTree {
	public void TestConvertTree(){
		int[] values = {8,5,10,4,6,9,12};
		Tree tr = new Tree();
		TreeNode root = tr.buildTree(values, 0);
		tr.showTree(root);
		System.out.println("输出置换后的双向链表：");
		Convert(root);
		while(root.left!=null)
		{
			root = root.left;
		}
		System.out.println();
		while(root!=null)
		{
			System.out.print(root.val+",");
			root = root.right;
		}
//		tr.showTree(Convert(root));
	}
	
    //分治的思想，将左子树和右子树分别转化为双向链表后，与根节点相连
    public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        if(leftRoot!=null)
        {
            TreeNode max = leftRoot;
            //通过树结构能够更开找到最大点，此时应予以记录，然后转化左子树
            while(max.right!=null)
                max = max.right;
//            System.out.println(root.val+",leftTree:"+root.left.val+"'s max is "+max.val);
            //一定要先转化好左右子树，再对最大节点的指针进行修改，否则叶节点就会因为max.right=root赋值语句变为非叶节点
            Convert(leftRoot);
            root.left = max;
            max.right = root;
        }        
        if(rightRoot!=null)
        {
            TreeNode min = rightRoot;
            while(min.left!=null)
                min = min.left;
//            System.out.println(root.val+",rightTree:"+root.right.val+"'s min is "+min.val);
            Convert(rightRoot);
            root.right = min;
            min.left = root;
        }
        //面试时问清题意，若找到最左边的节点，或最右边的节点，可以再进行遍历
        while(root.left!=null)
            root = root.left;
        return root;
    }
}
