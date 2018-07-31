package easy;

public class NC26_ConvertTree {
	public void TestConvertTree(){
		int[] values = {8,5,10,4,6,9,12};
		Tree tr = new Tree();
		TreeNode root = tr.buildTree(values, 0);
		tr.showTree(root);
		System.out.println("����û����˫������");
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
	
    //���ε�˼�룬�����������������ֱ�ת��Ϊ˫�����������ڵ�����
    public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        if(leftRoot!=null)
        {
            TreeNode max = leftRoot;
            //ͨ�����ṹ�ܹ������ҵ����㣬��ʱӦ���Լ�¼��Ȼ��ת��������
            while(max.right!=null)
                max = max.right;
//            System.out.println(root.val+",leftTree:"+root.left.val+"'s max is "+max.val);
            //һ��Ҫ��ת���������������ٶ����ڵ��ָ������޸ģ�����Ҷ�ڵ�ͻ���Ϊmax.right=root��ֵ����Ϊ��Ҷ�ڵ�
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
        //����ʱ�������⣬���ҵ�����ߵĽڵ㣬�����ұߵĽڵ㣬�����ٽ��б���
        while(root.left!=null)
            root = root.left;
        return root;
    }
}
