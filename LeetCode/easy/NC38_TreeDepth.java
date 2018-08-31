package easy;

public class NC38_TreeDepth {
    public int TreeDepth(TreeNode root) {
    	if(root==null)
    		return 0;
    	int left = TreeDepth(root.left);
    	int right = TreeDepth(root.right);
    	int res = max(left,right)+1;
        return res;
    }
    public int max(int a,int b) {
    	if(a>b)
    		return a;
    	else 
    		return b;
    }
}
