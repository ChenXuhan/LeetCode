package easy;

public class NC25_CloneRandomList {

	public void TestCloneRandomList()
	{
		int[][] values = {{1,3},{2,0},{3,0},{4,2},{5,0},{6,3}};
		RandomList list = new RandomList();
		RandomListNode root = new RandomList().buildTree(values);
		System.out.println("原数据：");
		list.showTree(root);
		System.out.println("重复后：");
		RandomListNode cloneRoot1 = RepeatList(root);
		list.showTree(cloneRoot1);
		System.out.println("拆分后：");
		RandomListNode cloneRoot2 = PartitionList(cloneRoot1);
		list.showTree(root);
		list.showTree(cloneRoot2);
//		RandomListNode cloneRoot = Clone(root);
//		System.out.println("复制后的树：");
//		list.showTree(cloneRoot);
	}

    public RandomListNode Clone(RandomListNode pHead) {
    	RandomListNode pClone = null;
        if(pHead!=null)
            pClone = PartitionList(RepeatList(pHead));
        return pClone;
    }
    
    public RandomListNode RepeatList(RandomListNode pHead) {
    	RandomListNode pClone = pHead;
    	//每个节点后面添加一个相同数值的节点
    	while(pClone!=null)
    	{
    		RandomListNode newP = new RandomListNode(pClone.label);
    		newP.next = pClone.next;
    		pClone.next = newP;
    		pClone = newP.next;
    	}
    	//复制节点的random指针
    	pClone = pHead;
    	while(pClone!=null)
    	{
    		if(pClone.random!=null)
    		{
    			pClone.next.random = pClone.random.next;
    		}
    		pClone = pClone.next.next;
    	}
        return pHead;
    }
    
    public RandomListNode PartitionList(RandomListNode pHead) {
		RandomList list = new RandomList();
    	RandomListNode pOld = pHead;
    	RandomListNode pHeadNew = pHead.next;
    	RandomListNode pNew = pHeadNew;
    	//注意此时很容易出现指向空指针，由于pOld可能在最后一个指向空指针
    	while(true)
    	{
//    		System.out.println("列表1：");
//    		list.showTree(pHead);
//    		System.out.println("列表2：");
//    		list.showTree(pHeadNew);
    		pOld.next = pNew.next;
    		pOld = pOld.next;
    		if(pOld==null)
    			break;
    		pNew.next = pOld.next;
    		pNew = pNew.next;
    	}
        return pHeadNew;
    }
}
