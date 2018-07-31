package easy;

public class NC36_FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null)
             return null;
        int len1 = 1,len2=1;
        ListNode pHead = pHead1;
        while(pHead.next!=null)
        {
            len1++;
            pHead = pHead.next;
        }
        pHead = pHead2;
        while(pHead.next!=null)
        {
            len2++;
            pHead = pHead.next;
        }
        int lenDiff = len1-len2;
        while(lenDiff>0)
        {
        	pHead1 = pHead1.next;
        	lenDiff--;
        }
        while(lenDiff<0)
        {
        	pHead2 = pHead2.next;
        	lenDiff++;
        }
        while(pHead1!=null)
        {
        	if(pHead1==pHead2)
        	{
        		return pHead1;
        	}
        	pHead1 = pHead1.next;
        	pHead2 = pHead2.next;
        }
        return null;
    }
    public void TestFindFirstCommonNode(){
    	int[] inputs = {1,2,3,4,5,6,7};
    	ListNode pHead = null;
    	for(int i=inputs.length-1;i>=0;i--){
    		ListNode pCurrent = new ListNode(inputs[i]);
    		pCurrent.next = pHead;
    		pHead = pCurrent;
    	}
//    	ListNode pHead2 = pHead;
//    	for(int i=1;i<=3;i++)
//    		pHead2 = pHead2.next;

    	ListNode pHead2 = null;
    	for(int i=inputs.length-1;i>=0;i--){
    		ListNode pCurrent = new ListNode(inputs[i]);
    		pCurrent.next = pHead2;
    		pHead2 = pCurrent;
    	}

//    	ListNode pHead2 = new ListNode(8);
    	System.out.println(pHead.val+","+pHead2.val);
    	ListNode pCom = FindFirstCommonNode(pHead2,pHead);
    	System.out.println(pCom);
    	while(pCom!=null)
    	{
    		System.out.print(pCom.val+",");
    		pCom = pCom.next;
    	}
    }
}
