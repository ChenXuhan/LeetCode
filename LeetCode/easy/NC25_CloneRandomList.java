package easy;

public class NC25_CloneRandomList {

	public void TestCloneRandomList()
	{
		int[][] values = {{1,3},{2,0},{3,0},{4,2},{5,0},{6,3}};
		RandomList list = new RandomList();
		RandomListNode root = new RandomList().buildTree(values);
		System.out.println("ԭ���ݣ�");
		list.showTree(root);
		System.out.println("�ظ���");
		RandomListNode cloneRoot1 = RepeatList(root);
		list.showTree(cloneRoot1);
		System.out.println("��ֺ�");
		RandomListNode cloneRoot2 = PartitionList(cloneRoot1);
		list.showTree(root);
		list.showTree(cloneRoot2);
//		RandomListNode cloneRoot = Clone(root);
//		System.out.println("���ƺ������");
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
    	//ÿ���ڵ�������һ����ͬ��ֵ�Ľڵ�
    	while(pClone!=null)
    	{
    		RandomListNode newP = new RandomListNode(pClone.label);
    		newP.next = pClone.next;
    		pClone.next = newP;
    		pClone = newP.next;
    	}
    	//���ƽڵ��randomָ��
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
    	//ע���ʱ�����׳���ָ���ָ�룬����pOld���������һ��ָ���ָ��
    	while(true)
    	{
//    		System.out.println("�б�1��");
//    		list.showTree(pHead);
//    		System.out.println("�б�2��");
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
